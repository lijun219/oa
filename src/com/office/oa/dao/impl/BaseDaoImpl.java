package com.office.oa.dao.impl;

import java.io.Serializable;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import lombok.Getter;
import lombok.Setter;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.CriteriaSpecification;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.internal.CriteriaImpl;
import org.hibernate.internal.CriteriaImpl.OrderEntry;
import org.hibernate.metadata.ClassMetadata;
import org.hibernate.transform.ResultTransformer;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.office.oa.dao.BaseDao;
import com.office.oa.model.BaseEntity;
import com.office.oa.util.Pager;
import com.office.oa.util.ReflectionUtil;

/**
 * Dao基类，提供一系列操作数据的方法
 * 
 * @author huan.tao
 * 
 * @param <T>
 * @param <PK>
 */

@SuppressWarnings("unchecked")
@Repository("baseDao")
public class BaseDaoImpl<T, PK extends Serializable> implements BaseDao<T, PK> {

	private static final String ORDER_LIST_PROPERTY_NAME = "orderList";// "排序"属性名称
	private static final String CREATE_DATE_PROPERTY_NAME = "createDate";// "创建日期"属性名称

	private Class<T> entityClass;

	@Getter
	@Setter
	@Resource(name = "sessionFactory")
	SessionFactory sessionFactory;

	private static Session session;

	// 获得泛型的实体对象
	public BaseDaoImpl() {
		Type type = getClass().getGenericSuperclass();
		if (type instanceof ParameterizedType) {
			Type[] parameterizedType = ((ParameterizedType) type).getActualTypeArguments();
			this.entityClass = (Class<T>) parameterizedType[0];
		}
	}

	@Override
	public Session getSession() {
		if (session == null)
			session = sessionFactory.openSession();
		return session;
	}

	@Override
	public T get(PK id) {
		return (T) this.getSession().get(this.entityClass, id);
	}

	@Override
	public T load(PK id) {
		return (T) this.getSession().load(this.entityClass, id);
	}

	@Override
	public List<T> getAllList() {
		Criteria criteria = getSession().createCriteria(entityClass);
		criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		return criteria.list();
	}

	@Override
	public Long getTotalCount() {
		return (Long) uniqueResult("SELECT COUNT(*) FROM " + entityClass.getName());
	}

	@Override
	public PK save(T entity) {
		if (entity instanceof BaseEntity) {
			try {
				// 反射执行实体的onSave()方法
				Method method = entity.getClass().getMethod(BaseEntity.ON_SAVE_METHOD_NAME);
				method.invoke(entity);
				return (PK) this.getSession().save(entity);
			} catch (Exception e) {
				e.printStackTrace();
				return null;
			}
		}
		return (PK) this.getSession().save(entity);
	}

	@Override
	public void update(T entity) {
		if (entity instanceof BaseEntity) {
			try {
				// 执行实体的onUpdate()方法
				Method method = entity.getClass().getMethod(BaseEntity.ON_UPDATE_METHOD_NAME);
				method.invoke(entity);
				this.getSession().update(entity);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void saveOrUpdate(T entity) {
		this.getSession().saveOrUpdate(entity);
	}

	@Override
	public void delete(T entity) {
		this.getSession().delete(entity);
	}

	@Override
	public void delete(PK id) {
		T entity = (T) getSession().get(this.entityClass, id);
		getSession().delete(entity);
	}

	@Override
	public T merge(T entity) {
		return (T) getSession().merge(entity);
	}

	@Override
	public void delete(PK[] ids) {

		for (PK id : ids) {
			T entity = (T) getSession().get(this.entityClass, id);
			getSession().delete(entity);
		}
	}

	@Override
	public List<T> find(String HQL) {
		return this.getSession().createQuery(HQL).list();
	}

	@Override
	public List<T> find(String HQL, Object... parameters) {
		Query query = getSession().createQuery(HQL);
		if (parameters != null) {
			for (int i = 0; i < parameters.length; i++) {
				query.setParameter(i, parameters[i]);
			}
		}
		return query.list();
	}

	@Override
	public T uniqueResult(final String HQL, final Object... parameters) throws DataAccessException {
		// 创建Query
		Query query = getSession().createQuery(HQL);
		// 遍历传递的可变参数
		if (parameters != null) {
			// 添加查询条件
			for (int i = 0; i < parameters.length; i++) {
				query.setParameter(i, parameters[i]);
			}
		}
		// 返回查询的唯一结果
		return (T) query.uniqueResult();
	}

	@Override
	public Pager findPager(Pager pager) {
		Criteria criteria = getSession().createCriteria(entityClass);
		return findPager(pager, criteria);
	}

	@Override
	public Pager findPager(Pager pager, Criterion... criterions) {
		Criteria criteria = getSession().createCriteria(entityClass);
		for (Criterion criterion : criterions) {
			criteria.add(criterion);
		}
		return findPager(pager, criteria);
	}

	@Override
	public Pager findPager(Pager pager, Order... orders) {
		Criteria criteria = getSession().createCriteria(entityClass);
		for (Order order : orders) {
			criteria.addOrder(order);
		}
		return findPager(pager, criteria);
	}

	@Override
	public Pager findPager(Pager pager, Criteria criteria) {
		Integer pageNumber = pager.getPageNumber();
		Integer pageSize = pager.getPageSize();
		String searchBy = pager.getSearchBy();
		String keyword = pager.getKeyword();
		String orderBy = pager.getOrderBy();
		Pager.Order order = pager.getOrder();

		if (StringUtils.isNotEmpty(searchBy) && StringUtils.isNotEmpty(keyword)) {
			if (searchBy.contains(".")) {
				String alias = StringUtils.substringBefore(searchBy, ".");
				criteria.createAlias(alias, alias);
			}
			criteria.add(Restrictions.like(searchBy, "%" + keyword + "%"));
		}

		pager.setTotalCount(criteriaResultTotalCount(criteria));

		if (StringUtils.isNotEmpty(orderBy) && order != null) {
			if (order == Pager.Order.asc) {
				criteria.addOrder(Order.asc(orderBy));
			} else {
				criteria.addOrder(Order.desc(orderBy));
			}
		}

		ClassMetadata classMetadata = sessionFactory.getClassMetadata(entityClass);
		if (!StringUtils.equals(orderBy, ORDER_LIST_PROPERTY_NAME) && ArrayUtils.contains(classMetadata.getPropertyNames(), ORDER_LIST_PROPERTY_NAME)) {
			criteria.addOrder(Order.asc(ORDER_LIST_PROPERTY_NAME));
			criteria.addOrder(Order.desc(CREATE_DATE_PROPERTY_NAME));
			if (StringUtils.isEmpty(orderBy) || order == null) {
				pager.setOrderBy(ORDER_LIST_PROPERTY_NAME);
				pager.setOrder(Pager.Order.asc);
			}
		} else if (!StringUtils.equals(orderBy, CREATE_DATE_PROPERTY_NAME) && ArrayUtils.contains(classMetadata.getPropertyNames(), CREATE_DATE_PROPERTY_NAME)) {
			criteria.addOrder(Order.desc(CREATE_DATE_PROPERTY_NAME));
			if (StringUtils.isEmpty(orderBy) || order == null) {
				pager.setOrderBy(CREATE_DATE_PROPERTY_NAME);
				pager.setOrder(Pager.Order.desc);
			}
		}

		criteria.setFirstResult((pageNumber - 1) * pageSize);
		criteria.setMaxResults(pageSize);

		pager.setResult(criteria.list());
		return pager;
	}

	private int criteriaResultTotalCount(Criteria criteria) {
		int criteriaResultTotalCount = 0;
		try {
			CriteriaImpl criteriaImpl = (CriteriaImpl) criteria;
			Projection projection = criteriaImpl.getProjection();
			ResultTransformer resultTransformer = criteriaImpl.getResultTransformer();
			List<OrderEntry> orderEntries = (List<OrderEntry>) ReflectionUtil.getFieldValue(criteriaImpl, "orderEntries");
			ReflectionUtil.setFieldValue(criteriaImpl, "orderEntries", new ArrayList<Object>());
			Integer totalCount = ((Integer) criteriaImpl.setProjection(Projections.rowCount()).uniqueResult()).intValue();
			if (totalCount != null) {
				criteriaResultTotalCount = totalCount;
			}

			criteriaImpl.setProjection(projection);
			if (projection == null) {
				criteriaImpl.setResultTransformer(CriteriaSpecification.ROOT_ENTITY);
			}
			if (resultTransformer != null) {
				criteriaImpl.setResultTransformer(resultTransformer);
			}
			ReflectionUtil.setFieldValue(criteriaImpl, "orderEntries", orderEntries);
		} catch (Exception e) {
			e.printStackTrace();

		}
		return criteriaResultTotalCount;
	}

	@Override
	public void flush() {
		this.getSession().flush();
	}

	@Override
	public void evict(Object object) {
		this.getSession().evict(object);
	}

	@Override
	public void clear() {
		this.getSession().clear();
	}

}

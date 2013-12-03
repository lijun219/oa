package com.office.oa.service.impl;

import java.io.Serializable;
import java.util.List;

import javax.annotation.Resource;

import lombok.Getter;
import lombok.Setter;

import org.hibernate.Criteria;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;
import org.springframework.transaction.annotation.Transactional;

import com.office.oa.dao.BaseDao;
import com.office.oa.service.BaseService;
import com.office.oa.util.Pager;

/**
 * 
 * Service基类，提供一系列操作方法
 * 
 * @author huan.tao
 * 
 * @param <T>
 * @param <PK>
 */
@Transactional
public class BaseServiceImpl<T, PK extends Serializable> implements BaseService<T, PK> {

	@Getter
	@Setter
	@Resource(name = "baseDao")
	BaseDao<T, PK> baseDao;

	@Override
	@Transactional(readOnly = true)
	public T get(PK id) {
		return baseDao.get(id);
	}

	@Override
	@Transactional(readOnly = true)
	public T load(PK id) {
		return baseDao.load(id);
	}

	@Override
	@Transactional(readOnly = true)
	public List<T> getAllList() {
		return baseDao.getAllList();
	}

	@Override
	@Transactional(readOnly = true)
	public Long getTotalCount() {
		return baseDao.getTotalCount();
	}

	@Override
	@Transactional
	public PK save(T entity) {
		return baseDao.save(entity);
	}

	@Override
	@Transactional
	public void update(T entity) {
		baseDao.update(entity);
	}

	@Override
	public T merge(T entity) {
		return baseDao.merge(entity);
	}

	@Override
	@Transactional
	public void delete(T entity) {
		baseDao.delete(entity);
	}

	@Override
	@Transactional
	public void delete(PK id) {
		baseDao.delete(id);
	}

	@Override
	@Transactional
	public void delete(PK[] ids) {
		baseDao.delete(ids);
	}

	@Override
	@Transactional(readOnly = true)
	public void flush() {
		baseDao.flush();
	}

	@Override
	@Transactional(readOnly = true)
	public void evict(Object object) {
		baseDao.evict(object);
	}

	@Override
	@Transactional(readOnly = true)
	public void clear() {
		baseDao.clear();
	}

	@Override
	@Transactional(readOnly = true)
	public Pager findPager(Pager pager) {
		return baseDao.findPager(pager);
	}

	@Override
	@Transactional(readOnly = true)
	public Pager findPager(Pager pager, Criterion... criterions) {
		return findPager(pager, criterions);
	}

	@Override
	@Transactional(readOnly = true)
	public Pager findPager(Pager pager, Order... orders) {
		return findPager(pager, orders);
	}

	@Override
	@Transactional(readOnly = true)
	public Pager findPager(Pager pager, Criteria criteria) {
		return baseDao.findPager(pager, criteria);
	}

}

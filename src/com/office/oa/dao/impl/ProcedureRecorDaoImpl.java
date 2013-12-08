package com.office.oa.dao.impl;



import com.office.oa.dao.ProcedureRecorDao;
import com.office.oa.model.ProcedureRecord;

public class ProcedureRecorDaoImpl extends BaseDaoO implements  ProcedureRecorDao{

	@Override
	public ProcedureRecord getById(int id) {
		// TODO Auto-generated method stub
		String hql = "from ProcedureRecord Where id=:id";
		Object object = getCurrentSession().createQuery(hql).setParameter("id", id)
				.uniqueResult();
		return object == null ? null : (ProcedureRecord) object;
	}

}

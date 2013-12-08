package com.office.oa.dao.impl;

import com.office.oa.dao.ProceduresDao;
import com.office.oa.model.Procedure;


public class ProceduresDaoImpl extends BaseDaoO implements ProceduresDao{

	@Override
	public Procedure getById(int id) {
		String hql = "from Procedure Where id=:id";
		Object object = getCurrentSession().createQuery(hql).setParameter("id", id)
				.uniqueResult();
		return object == null ? null : (Procedure) object;
	}

}

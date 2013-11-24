package com.lijun.oa.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;


/***
 * 
 * @author lijun
 *
 */
public class BaseDao{
	@Autowired
	private SessionFactory sessionFactory;

	/**
	 * 获取当前Session对象
	 * 
	 * @return
	 */
	protected  Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	
}

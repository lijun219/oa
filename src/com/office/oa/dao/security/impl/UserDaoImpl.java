package com.office.oa.dao.security.impl;

import org.springframework.stereotype.Repository;

import com.office.oa.dao.impl.BaseDaoImpl;
import com.office.oa.dao.security.UserDao;
import com.office.oa.model.security.User;

@Repository("userDao")
public class UserDaoImpl extends BaseDaoImpl<User, String> implements UserDao {

	@Override
	public User getUserByUsername(String username) {
		User user = uniqueResult("FROM User WHERE username = ?", username);
		return user;
	}

}

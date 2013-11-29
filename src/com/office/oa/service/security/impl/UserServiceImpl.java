package com.office.oa.service.security.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.office.oa.dao.security.UserDao;
import com.office.oa.model.security.User;
import com.office.oa.service.impl.BaseServiceImpl;
import com.office.oa.service.security.UserService;

@Service("userService")
public class UserServiceImpl extends BaseServiceImpl<User, String> implements UserService {

	@Resource(name = "userDao")
	UserDao userDao;

	@Override
	public User getUserByUsername(String userName) {
		if (userName != null) {
			return userDao.getUserByUsername(userName);
		}
		return null;
	}

}

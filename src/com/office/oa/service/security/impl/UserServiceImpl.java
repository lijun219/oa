package com.office.oa.service.security.impl;

import java.util.Collection;
import java.util.HashSet;

import javax.annotation.Resource;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.GrantedAuthorityImpl;
import org.springframework.stereotype.Service;

import com.office.oa.dao.security.UserDao;
import com.office.oa.model.security.Role;
import com.office.oa.model.security.User;
import com.office.oa.service.impl.BaseServiceImpl;
import com.office.oa.service.security.UserService;

@SuppressWarnings("deprecation")
@Service("userService")
public class UserServiceImpl extends BaseServiceImpl<User, String> implements UserService {

	@Resource(name = "userDao")
	UserDao userDao;

	@Resource(name = "userDao")
	public void setUserDao(UserDao userDao) {
		super.setBaseDao(userDao);
	}

	@Override
	public User getUserByUsername(String userName) {
		if (userName != null) {
			return userDao.getUserByUsername(userName);
		}
		return null;
	}

	@Override
	public Collection<GrantedAuthority> getUserAuthoritiesByUser(User user) {
		Collection<GrantedAuthority> authorities = new HashSet<GrantedAuthority>();
		for (Role role : user.getRoles()) {
			for (com.office.oa.model.security.Resource resource : role.getResources()) {
				authorities.add(new GrantedAuthorityImpl(resource.getName()));
			}
		}
		return authorities;
	}

}

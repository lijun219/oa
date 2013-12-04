package com.office.oa.security.authentication.details;

import javax.annotation.Resource;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.office.oa.model.security.User;
import com.office.oa.service.security.UserService;

/**
 * 
 * @author huan.tao
 * 
 */
public class SimpleUserDetailService implements UserDetailsService {

	@Resource(name = "userService")
	UserService userService;

	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {

		User user = userService.getUserByUsername(userName);

		user.setAuthorities(userService.getUserAuthoritiesByUser(user));

		return user;
	}

}

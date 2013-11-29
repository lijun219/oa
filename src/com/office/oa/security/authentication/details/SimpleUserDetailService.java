package com.office.oa.security.authentication.details;

import java.util.Collection;
import java.util.HashSet;

import javax.annotation.Resource;

import lombok.extern.log4j.Log4j;

import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.encoding.ShaPasswordEncoder;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.GrantedAuthorityImpl;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.office.oa.model.security.Role;
import com.office.oa.model.security.User;
import com.office.oa.service.security.UserService;
import com.sun.tools.apt.Main;

/**
 * 
 * @author huan.tao
 * 
 */
@Log4j
public class SimpleUserDetailService implements UserDetailsService {

	@Resource(name = "userService")
	UserService userService;

	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {

		User user = userService.getUserByUsername(userName);
		if (user == null) {
			throw new BadCredentialsException("Not Found UserDetail,userName=" + userName);
		}
		user.setAuthorities(getUserAuthoritiesByUser(user));
		log.info("\r\nload user by user name ");

		return user;
	}

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

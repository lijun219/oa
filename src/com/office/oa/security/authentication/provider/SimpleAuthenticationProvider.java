package com.office.oa.security.authentication.provider;

import lombok.Getter;
import lombok.Setter;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.AbstractUserDetailsAuthenticationProvider;
import org.springframework.security.authentication.dao.ReflectionSaltSource;
import org.springframework.security.authentication.encoding.ShaPasswordEncoder;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

@Getter
@Setter
public class SimpleAuthenticationProvider extends AbstractUserDetailsAuthenticationProvider implements AuthenticationProvider {

	UserDetailsService userDetailsService;

	ShaPasswordEncoder passwordEncoder;

	ReflectionSaltSource saltSource;

	@Override
	protected void additionalAuthenticationChecks(UserDetails userDetails, UsernamePasswordAuthenticationToken authentication) throws AuthenticationException {
		// 获得的用户输入密码
		String presentedPassword = authentication.getCredentials().toString();
		// 获得用户名，作为加密盐值
		Object salt = getSaltSource().getSalt(userDetails);
		// 判断密码是否匹配
		System.err.println(passwordEncoder.encodePassword(presentedPassword, salt));
		if (!getPasswordEncoder().isPasswordValid(userDetails.getPassword(), presentedPassword, salt)) {
			throw new AuthenticationServiceException("用户名或密码错误。");
		}
	}

	@Override
	protected UserDetails retrieveUser(String username, UsernamePasswordAuthenticationToken authentication) throws AuthenticationException {
		return getUserDetailsService().loadUserByUsername(username);
	}
}

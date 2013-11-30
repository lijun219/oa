package com.office.oa.security.authentication.provider;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;

import com.office.oa.security.authentication.token.SimpleAuthenticationToken;

public class SimpleAuthenticationProvider extends DaoAuthenticationProvider implements AuthenticationProvider {

	@SuppressWarnings("deprecation")
	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		SimpleAuthenticationToken authenticationToken = (SimpleAuthenticationToken) authentication;
		UserDetails userDetails = getUserDetailsService().loadUserByUsername(authenticationToken.getPrincipal().toString());
		if (userDetails == null) {
			throw new AuthenticationServiceException("用户名或密码错误。");
		}

		// 获得的用户输入密码
		String presentedPassword = authentication.getCredentials().toString();
		// 获得用户名，作为加密盐值
		Object salt = getSaltSource().getSalt(userDetails);

		// 判断密码是否匹配
		if (!getPasswordEncoder().isPasswordValid(userDetails.getPassword(), presentedPassword, salt)) {
			throw new BadCredentialsException("用户名或密码错误。");
		}
		// 重新构建UsernamePasswordAuthenticationToken传递给决策管理器进行授权管理
		
		return new SimpleAuthenticationToken(userDetails, authentication.getPrincipal(), userDetails.getAuthorities());
	}

	// 根据凭证判断登陆类型
	@Override
	public boolean supports(Class<?> authentication) {
		return SimpleAuthenticationToken.class.isAssignableFrom(authentication);
	}
}

package com.office.oa.security.authentication.filter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.office.oa.security.authentication.token.AuthenticationTokenResolver;

/**
 * 登录过滤器
 * 
 * @author huan.tao
 * 
 */
public class SimpleUsernamePasswordAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

	AuthenticationTokenResolver authenticationTokenResolver;

	/**
	 * 重写验证方法
	 */
	@Override
	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
		// 判断登陆类型
		if (authenticationTokenResolver.support(request)) {
			// 获得用户凭证
			Authentication authentication = authenticationTokenResolver.resolve(request);
			// 验证用户凭证
			return this.getAuthenticationManager().authenticate(authentication);
		}
		throw new UnsupportedOperationException("No authentication token resolver found!");
	}

	public AuthenticationTokenResolver getAuthenticationTokenResolver() {
		return authenticationTokenResolver;
	}

	public void setAuthenticationTokenResolver(AuthenticationTokenResolver authenticationTokenResolver) {
		this.authenticationTokenResolver = authenticationTokenResolver;
	}

}

package com.office.oa.security.authentication.token;

import javax.servlet.http.HttpServletRequest;

import org.springframework.security.core.Authentication;

/**
 * 登录凭证
 * 
 * @author huan.tao
 * 
 */
public class SimpleAuthenticationTokenResolver implements AuthenticationTokenResolver {

	public static final String USERNAME = "username"; // 登陆用户名
	public static final String PASSWORD = "password"; // 登陆密码

	@Override
	public Authentication resolve(HttpServletRequest request) {
		String username = request.getParameter(USERNAME);
		String password = request.getParameter(PASSWORD);
		return new SimpleAuthenticationToken(username, password);
	}

}

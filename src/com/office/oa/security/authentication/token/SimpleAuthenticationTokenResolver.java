package com.office.oa.security.authentication.token;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.security.core.Authentication;

/**
 * 登录凭证
 * 
 * @author huan.tao
 * 
 */
public class SimpleAuthenticationTokenResolver extends AbstractAuthenticationTokenResolver {

	private static final Logger logger = Logger.getLogger(SimpleAuthenticationTokenResolver.class);
	public static final String USERNAME = "username"; // 登陆用户名
	public static final String PASSWORD = "password"; // 登陆密码

	@Override
	public Authentication resolve(HttpServletRequest request) {
		String username = request.getParameter(USERNAME);
		String password = request.getParameter(PASSWORD);
		if (logger.isDebugEnabled()) {
			logger.info("登陆的用户名：" + username);
		}
		return new SimpleAuthenticationToken(username, password);
	}

}

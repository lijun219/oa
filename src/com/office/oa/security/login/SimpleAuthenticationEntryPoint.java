package com.office.oa.security.login;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;

import com.office.oa.security.shared.DirectUrlResolver;

/**
 * 
 * @author huan.tao
 * 
 */
public class SimpleAuthenticationEntryPoint implements AuthenticationEntryPoint {

	DirectUrlResolver directUrlResolver;

	@Override
	public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {
		if (directUrlResolver.support(request)) {
			// 跳转到登陆依据所绑定的登录页面
			response.sendRedirect(request.getContextPath() + directUrlResolver.getDirectUrl());
			return;
		}
	}

	public DirectUrlResolver getDirectUrlResolver() {
		return directUrlResolver;
	}

	public void setDirectUrlResolver(DirectUrlResolver directUrlResolver) {
		this.directUrlResolver = directUrlResolver;
	}

}

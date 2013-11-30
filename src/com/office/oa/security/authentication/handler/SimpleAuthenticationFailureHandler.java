package com.office.oa.security.authentication.handler;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.ExceptionMappingAuthenticationFailureHandler;

import com.office.oa.security.shared.DirectUrlResolver;

/**
 * 
 * @author huan.tao
 * 
 */
public class SimpleAuthenticationFailureHandler extends ExceptionMappingAuthenticationFailureHandler {

	DirectUrlResolver directUrlResolver;

	// 验证失败执行的方法，跳转到失败的URL
	@Override
	public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {

		// 添加跳转的URL
		setDefaultFailureUrl(directUrlResolver.getDirectUrl());
		
		super.onAuthenticationFailure(request, response, exception);
	}

	public DirectUrlResolver getDirectUrlResolver() {
		return directUrlResolver;
	}

	public void setDirectUrlResolver(DirectUrlResolver directUrlResolver) {
		this.directUrlResolver = directUrlResolver;
	}

}

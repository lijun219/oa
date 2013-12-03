package com.office.oa.security.login;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lombok.Getter;
import lombok.Setter;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;

/**
 * 
 * @author huan.tao
 * 
 */
public class SimpleAuthenticationEntryPoint implements AuthenticationEntryPoint {

	@Getter
	@Setter
	String directUrl;

	@Override
	public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {
		// 跳转到登陆依据所绑定的登录页面
		request.getRequestDispatcher(directUrl).forward(request, response);
		//response.sendRedirect(request.getContextPath() + directUrlResolver.getDirectUrl());
	}
}

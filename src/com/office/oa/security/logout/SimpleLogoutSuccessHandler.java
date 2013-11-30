package com.office.oa.security.logout;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;

import com.office.oa.security.shared.DirectUrlResolver;

public class SimpleLogoutSuccessHandler implements LogoutSuccessHandler {

	DirectUrlResolver directUrlResolver;

	@Override
	public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
		response.sendRedirect(request.getContextPath() + directUrlResolver.getDirectUrl());
	}

	public DirectUrlResolver getDirectUrlResolvers() {
		return directUrlResolver;
	}

	public void setDirectUrlResolvers(DirectUrlResolver directUrlResolvers) {
		this.directUrlResolver = directUrlResolvers;
	}

}

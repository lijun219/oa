package com.office.oa.security.authentication.handler;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;

import com.office.oa.model.security.User;
import com.office.oa.service.security.UserService;

public class SimpleLogoutSuccessHandler implements LogoutSuccessHandler {

	@Resource
	UserService userService;

	@Override
	public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {

		User user = (User) authentication.getPrincipal();
		user.setOnline(false);
		userService.update(user);
		userService.flush();

		response.sendRedirect(request.getContextPath() + "/");
	}

}

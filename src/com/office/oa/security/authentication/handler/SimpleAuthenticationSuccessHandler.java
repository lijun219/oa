package com.office.oa.security.authentication.handler;

import java.io.IOException;
import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;

import com.office.oa.model.security.User;
import com.office.oa.service.security.UserService;

/**
 * 
 * @author huan.tao
 * 
 */
public class SimpleAuthenticationSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {

	@Resource
	UserService userService;

	// 验证成功执行的方法，跳转到成功的URL
	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {

		User user = (User) authentication.getPrincipal();

		user.setOnline(true);
		user.setLoginDate(new Date());
		user.setLoginIp(request.getRemoteAddr());
		userService.update(user);
		userService.flush();

		// 添加跳转的URL
		setDefaultTargetUrl("/");
		super.onAuthenticationSuccess(request, response, authentication);
	}
}

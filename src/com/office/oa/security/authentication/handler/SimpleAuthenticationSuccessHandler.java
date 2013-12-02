package com.office.oa.security.authentication.handler;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lombok.Getter;
import lombok.Setter;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;

import com.office.oa.security.shared.DirectUrlResolver;

/**
 * 
 * @author huan.tao
 * 
 */
public class SimpleAuthenticationSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {

	@Getter
	@Setter
	DirectUrlResolver directUrlResolver;

	// 验证成功执行的方法，跳转到成功的URL
	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {

		// 添加跳转的URL
		 setDefaultTargetUrl(directUrlResolver.getDirectUrl());
		//request.getRequestDispatcher("").forward(request, response);
		super.onAuthenticationSuccess(request, response, authentication);
	}

}

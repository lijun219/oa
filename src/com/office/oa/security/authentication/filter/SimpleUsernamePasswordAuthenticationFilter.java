package com.office.oa.security.authentication.filter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lombok.Getter;
import lombok.Setter;

import org.apache.commons.lang3.StringUtils;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.office.oa.security.authentication.token.AuthenticationTokenResolver;
import com.office.oa.security.shared.DirectUrlResolverImpl;

/**
 * 登录过滤器
 * 
 * @author huan.tao
 * 
 */
public class SimpleUsernamePasswordAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

	@Getter
	@Setter
	AuthenticationTokenResolver authenticationTokenResolver;
	@Getter
	@Setter
	DirectUrlResolverImpl loginUrlResolver;

	/**
	 * 重写验证方法
	 */
	@Override
	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {

		// 获得用户凭证
		Authentication authentication = authenticationTokenResolver.resolve(request);
		if (StringUtils.isEmpty(authentication.getPrincipal().toString()) || StringUtils.isEmpty(authentication.getCredentials().toString())) {
			throw new AuthenticationServiceException("用户名或密码不能为空。");
		}
		// 验证用户凭证
		return this.getAuthenticationManager().authenticate(authentication);

	}
}

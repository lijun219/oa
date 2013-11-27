package com.office.oa.security.authentication.token;

import org.springframework.security.core.Authentication;

import javax.servlet.http.HttpServletRequest;

/**
 * 
 * @author huan.tao
 * 
 */
public interface AuthenticationTokenResolver {

	/**
	 * 判断登录URL类型
	 * 
	 * @param request
	 * @return
	 */
	public boolean support(HttpServletRequest request);

	/**
	 * 返回登录的用户凭证
	 * 
	 * @param request
	 * @return
	 */
	public Authentication resolve(HttpServletRequest request);

}

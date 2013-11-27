package com.office.oa.security.shared;

import javax.servlet.http.HttpServletRequest;


/**
 * 
 * @author huan.tao
 * 
 */
public interface DirectUrlResolver {
	
	/**
	 * 当前请求Url是否是接口允许的请求地址
	 * 
	 * @param request
	 * @return
	 */
	public boolean support(HttpServletRequest request);

	/**
	 * 跳转页面的Url
	 * 
	 * @return
	 */
	public String getDirectUrl();
}

package com.office.oa.security.shared;

import javax.servlet.http.HttpServletRequest;

/**
 * 
 * @author huan.tao
 * 
 */
public interface DirectUrlResolver {

	/**
	 * 跳转页面的Url
	 * 
	 * @return
	 */
	public String getDirectUrl();
}

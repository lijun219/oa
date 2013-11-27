package com.office.oa.security.shared;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;

public class ParameterDirectUrlResolverImpl extends AbstarctDirectUrlResolver {

	@Override
	public boolean support(HttpServletRequest request) {
		// 获得请求的登录参数
		String parameterValue = request.getParameter(parameterName);
		if (StringUtils.isEmpty(parameterValue)) {
			return false;
		}
		// 参数是否匹配
		return parameterValue.equals(this.pattern);
	}
}

package com.office.oa.security.authentication.token;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;

/**
 * 
 * @author huan.tao
 * 
 */
public abstract class AbstractAuthenticationTokenResolver implements AuthenticationTokenResolver {

	protected String parameterName;
	protected String parameterValue;

	@Override
	public boolean support(HttpServletRequest request) {
		String parameterValue = request.getParameter(parameterName);
		if (StringUtils.isEmpty(parameterValue)) {
			return false;
		}
		return parameterValue.equals(this.parameterValue);
	}

	public String getParameterName() {
		return parameterName;
	}

	public String getParameterValue() {
		return parameterValue;
	}

	public void setParameterName(String parameterName) {
		this.parameterName = parameterName;
	}

	public void setParameterValue(String parameterValue) {
		this.parameterValue = parameterValue;
	}
}

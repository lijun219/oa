package com.office.oa.security.authentication.metadata;

import java.util.ArrayList;
import java.util.Collection;

import javax.servlet.http.HttpServletRequest;

import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;

public abstract class AbstractMetadataSource implements MetadataSource {

	protected String pattern; // 访问资源依据

	public String getPattern() {
		return pattern;
	}

	public void setPattern(String pattern) {
		this.pattern = pattern;
	}

	// 自定义方法,转换为 框架需要的Collection<ConfigAttribute>数据
	public Collection<ConfigAttribute> ListToCollection(String resourceName) {
		Collection<ConfigAttribute> configAttributes = new ArrayList<ConfigAttribute>();
		configAttributes.add(new SecurityConfig(resourceName));
		return configAttributes;
	}

	@Override
	public boolean supports(HttpServletRequest request) {
		String requestURI = request.getRequestURI();
		return requestURI.contains(pattern);

	}

}

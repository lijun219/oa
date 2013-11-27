package com.office.oa.security.authentication.metadata;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;

import lombok.extern.java.Log;
import lombok.extern.log4j.Log4j;

import org.apache.log4j.Logger;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.security.web.util.AntPathRequestMatcher;

@Log4j
public class SimpleSecurityMetadataSource extends AbstractMetadataSource implements FilterInvocationSecurityMetadataSource {

	private Map<String, Collection<ConfigAttribute>> resourceMap = new HashMap<String, Collection<ConfigAttribute>>();;

	@PostConstruct
	public void init() {
		System.out.println("******************");
	}

	@Override
	public Collection<ConfigAttribute> getAttributes(Object filter) {
		Collection<ConfigAttribute> collection = new ArrayList<ConfigAttribute>();
		FilterInvocation invocation = ((FilterInvocation) filter);
		HttpServletRequest request = invocation.getHttpRequest();
		String url = invocation.getRequestUrl();

		for (String resURL : resourceMap.keySet()) {
			if (new AntPathRequestMatcher(resURL).matches(request)) {
				collection = resourceMap.get(resURL);
				break;
			}
		}

		if (log.isDebugEnabled()) {
			log.info("访问的URL：" + url);
		}
		return collection;
	}

	@Override
	public Collection<ConfigAttribute> getAllConfigAttributes() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return true;
	}

}

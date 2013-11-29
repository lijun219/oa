package com.office.oa.security.authentication.metadata;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import lombok.extern.log4j.Log4j;

import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.security.web.util.AntPathRequestMatcher;

import com.office.oa.service.security.ResourceService;

@Log4j
public class SimpleSecurityMetadataSource extends AbstractMetadataSource implements FilterInvocationSecurityMetadataSource {

	private Map<String, Collection<ConfigAttribute>> resourceMap = new HashMap<String, Collection<ConfigAttribute>>();;

	@Resource(name = "resourceService")
	ResourceService resourceService;

	@PostConstruct
	public void init() {
		List<com.office.oa.model.security.Resource> resources = resourceService.getAllList();

		log.info("\r\nInitialize all the resources ...");
		for (com.office.oa.model.security.Resource resource : resources) {
			resourceMap.put(resource.getUrl(), listToCollection(resource.getName()));
			log.info("\r\n" + resource.getName() + " : " + resource.getUrl());
		}
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

		log.info("\r\nRequest path : " + url);

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

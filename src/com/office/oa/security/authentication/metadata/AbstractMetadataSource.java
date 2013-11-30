package com.office.oa.security.authentication.metadata;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;

public abstract class AbstractMetadataSource implements MetadataSource {

	// 自定义方法,转换为 框架需要的Collection<ConfigAttribute>数据
	public Collection<ConfigAttribute> listToCollection(String resourceName) {
		Collection<ConfigAttribute> configAttributes = new ArrayList<ConfigAttribute>();
		configAttributes.add(new SecurityConfig(resourceName));
		return configAttributes;
	}

}

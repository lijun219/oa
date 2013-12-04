package com.office.oa.security.authentication.metadata;

import java.util.Collection;

import org.springframework.security.access.ConfigAttribute;

/**
 * 返回所访问资源所匹配的属性集合
 * 
 * @author huan.tao
 * 
 */
public interface MetadataSource {

	/**
	 * 返回请求URL的资源集合
	 * 
	 * @param filter
	 * @return
	 */
	public Collection<ConfigAttribute> getAttributes(Object filter);

}

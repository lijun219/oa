package com.office.oa.security.authentication.decide;

import java.util.Collection;

import lombok.extern.log4j.Log4j;

import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.FilterInvocation;

/**
 * 判断用户所拥有的角色是否有访问当前请求资源的权限
 * 
 * @author huan.tao
 * 
 */
@Log4j
public class SimpleAccessDecisionManager implements AccessDecisionManager {
	
	@Override
	public void decide(Authentication authentication, Object filter, Collection<ConfigAttribute> configAttributes) throws AccessDeniedException, InsufficientAuthenticationException {

		String URL = ((FilterInvocation) filter).getRequestUrl();
		// 判断当前访问的资源是否属于受限资源
		if (configAttributes == null || configAttributes.size() == 0) {
			log.info("当前访问的资源" + URL + "不属于受限资源");
			return;
		}
		// 遍历访问该资源的所需权限属性
		for (ConfigAttribute attribute : configAttributes) {
			// 遍历访问用户当前的权限属性
			for (GrantedAuthority authority : authentication.getAuthorities()) {
				if (attribute.getAttribute().equals(authority.getAuthority())) {
					log.info("当前用户的{" + authority.getAuthority() + "}角色满足访问条件");
					return;
				}
			}
		}

		// 不满足访问条件抛出异常
		throw new AccessDeniedException("没有权限访问！");

	}

	@Override
	public boolean supports(ConfigAttribute attribute) {
		return true;
	}

	@Override
	public boolean supports(Class<?> clazz) {
		return true;
	}

}

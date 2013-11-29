package com.office.oa.service.security;

import java.util.List;

import com.office.oa.model.security.Resource;
import com.office.oa.service.BaseService;

/**
 * 
 * @author huan.tao
 * 
 */
public interface ResourceService extends BaseService<Resource, String> {

	/**
	 * 根据用户名获取该用户所有资源属性
	 * 
	 * @param userName
	 * @return
	 */
	public List<Resource> getResourceByUserName(String userName);

}

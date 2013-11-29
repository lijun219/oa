package com.office.oa.service.security.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.office.oa.dao.security.ResourceDao;
import com.office.oa.model.security.Resource;
import com.office.oa.service.impl.BaseServiceImpl;
import com.office.oa.service.security.ResourceService;

/**
 * 
 * @author huan.tao
 * 
 */
@Service("resourceService")
public class ResourceServiceImpl extends BaseServiceImpl<Resource, String> implements ResourceService {

	@javax.annotation.Resource(name = "resourceDao")
	ResourceDao resourceDao;

	@javax.annotation.Resource(name = "resourceDao")
	public void setResourceDao(ResourceDao resourceDao) {
		super.setBaseDao(resourceDao);
	}

	@Transactional
	@Override
	public List<Resource> getResourceByUserName(String userName) {
		return null;
	}

}

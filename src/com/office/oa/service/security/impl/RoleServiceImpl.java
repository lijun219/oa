package com.office.oa.service.security.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.office.oa.dao.security.RoleDao;
import com.office.oa.model.security.Role;
import com.office.oa.service.impl.BaseServiceImpl;
import com.office.oa.service.security.RoleService;

/**
 * 
 * @author huan.tao
 * 
 */
@Service("roleService")
public class RoleServiceImpl extends BaseServiceImpl<Role, String> implements RoleService {

	@Resource(name = "roleDao")
	RoleDao roleDao;

	@Resource(name = "roleDao")
	public void setRoleDao(RoleDao roleDao) {
		super.setBaseDao(roleDao);
	}
}

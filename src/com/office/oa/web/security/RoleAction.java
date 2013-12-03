package com.office.oa.web.security;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import lombok.Getter;
import lombok.Setter;

import com.office.oa.model.security.Role;
import com.office.oa.service.security.RoleService;

/**
 * 
 * @author huan.tao
 * 
 */
public class RoleAction {

	@Getter
	@Setter
	@Resource(name = "roleService")
	RoleService roleService;

	@Getter
	@Setter
	List<Role> rows = new ArrayList<Role>();

	public String list() {
		System.out.println(roleService.getTotalCount());
		return "json";
	}
}

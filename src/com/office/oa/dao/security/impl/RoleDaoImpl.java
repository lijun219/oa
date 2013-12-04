package com.office.oa.dao.security.impl;

import org.springframework.stereotype.Repository;

import com.office.oa.dao.impl.BaseDaoImpl;
import com.office.oa.dao.security.RoleDao;
import com.office.oa.model.security.Role;

/**
 * 
 * @author huan.tao
 * 
 */
@Repository("roleDao")
public class RoleDaoImpl extends BaseDaoImpl<Role, String> implements RoleDao {

}

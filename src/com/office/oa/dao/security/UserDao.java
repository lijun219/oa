package com.office.oa.dao.security;

import com.office.oa.dao.BaseDao;
import com.office.oa.model.security.User;

/**
 * 
 * @author huan.tao
 * 
 */
public interface UserDao extends BaseDao<User, String> {

	User getUserByUsername(String username);

}

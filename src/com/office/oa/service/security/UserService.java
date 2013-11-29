package com.office.oa.service.security;

import com.office.oa.model.security.User;
import com.office.oa.service.BaseService;

public interface UserService extends BaseService<User, String> {

	public User getUserByUsername(String userName);

}

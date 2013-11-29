package com.office.oa.dao.security.impl;

import org.springframework.stereotype.Repository;

import com.office.oa.dao.impl.BaseDaoImpl;
import com.office.oa.dao.security.ResourceDao;
import com.office.oa.model.security.Resource;

@Repository("resourceDao")
public class ResourceDaoImpl extends BaseDaoImpl<Resource, String> implements ResourceDao {

}

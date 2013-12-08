package com.office.oa.dao;

import com.office.oa.model.Procedure;
/***
 * 流程数据层
 * @author lijun
 *
 */
public interface ProceduresDao {
		/***
		 * 根据ID查询流程
		 * @param id
		 * @return
		 */
		Procedure getById(int id);
}	

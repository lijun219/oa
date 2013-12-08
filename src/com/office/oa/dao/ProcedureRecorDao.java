package com.office.oa.dao;

import com.office.oa.model.ProcedureRecord;
/***
 * 流程日志
 * @author lijun
 *
 */
public interface ProcedureRecorDao  {
	
	ProcedureRecord getById(int id);
}

package com.lijun.oa.web;

import java.util.ArrayList;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;

import com.lijun.oa.model.Employee;
import com.lijun.oa.service.EmployeeService;


/***
 * 员工信息交互action
 * @author lijun
 *
 */
public class EmployeeAction {
    @Autowired
	private EmployeeService employeeService;
	
	private List<Employee> rows = new ArrayList<Employee>();
	/***
	 * 员工登录 
	 * @return
	 */
	public String login(){
		return "success";
	}

	/***
	 * 首页
	 * @return
	 */
	public String index(){
		return "index";
	}

	/***
	 * 列表
	 * @return
	 */
	public String list(){
		rows=employeeService.listAll();
		return "json";
	}

	public List<Employee> getRows() {
		return rows;
	}

	public void setRows(List<Employee> rows) {
		this.rows = rows;
	}
	public String  addEmployee(){
       return "add";
	}
}

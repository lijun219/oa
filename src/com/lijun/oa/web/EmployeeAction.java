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
	
	private List<Employee> emlist = new ArrayList<Employee>();
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
		emlist=employeeService.listAll();
		return "json";
	}
	
	public List<Employee> getEmlist() {
		return emlist;
	}
	public void setEmlist(List<Employee> emlist) {

		this.emlist = emlist;
	}
	
//	public String  addEmployee(){
//        Employee employee=new Employee();
//        employee.setId(1);
//        employee.setName("我要向上");
//        employee.setAge("20");
//        employee.setMobile("1388886666");
//        employee.setAccount("wolegq");
//        employeeService.addEmployee(employee);
//        return null;
//	}
}

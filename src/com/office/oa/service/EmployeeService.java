package com.office.oa.service;

import java.util.List;

import com.office.oa.model.Employee;



/***
 *
 * @author lijun
 *
 */
public interface EmployeeService {
	
	List<Employee> listAll();
	/***
	 * 添加员工
	 * @return
	 */
	String addEmployee(Employee employee);
}

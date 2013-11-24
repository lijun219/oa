package com.lijun.oa.dao;

import java.util.List;


import com.lijun.oa.model.Employee;

public interface EmployeeDao {
	 List<Employee> queryList();
	 boolean addEmployee(Employee employee);
}

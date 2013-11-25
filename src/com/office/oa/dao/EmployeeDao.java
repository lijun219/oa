package com.office.oa.dao;

import java.util.List;


import com.office.oa.model.Employee;

public interface EmployeeDao {
	 List<Employee> queryList();
	 boolean addEmployee(Employee employee);
}

package com.lijun.oa.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.lijun.oa.dao.EmployeeDao;
import com.lijun.oa.model.Employee;
import com.lijun.oa.service.EmployeeService;
@Service(value="employeeService")
public class EmployeeServiceImpl implements EmployeeService {
	@Resource
	private EmployeeDao employeedao;
	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public List<Employee> listAll() {
		// TODO Auto-generated method stub
		return employeedao.queryList();
	}
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = java.lang.RuntimeException.class)
	public String  addEmployee(Employee employee) {
		// TODO Auto-generated method stub
		boolean result=employeedao.addEmployee(employee);
		if(result){
			return "新增员工成功!";
		}
		return "添加失败!";
	}

}

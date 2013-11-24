package com.lijun.oa.dao.impl;

import java.util.List;
import org.springframework.stereotype.Repository;
import com.lijun.oa.dao.BaseDao;
import com.lijun.oa.dao.EmployeeDao;
import com.lijun.oa.model.Employee;

@Repository(value = "employeeDao")
public class EmployeeImplDao extends BaseDao implements EmployeeDao  {


	@SuppressWarnings("unchecked")
	public List<Employee> queryList() {
			
	       String hql = "from Employee";
	       return super.getCurrentSession().createQuery(hql).list();
	}

	public boolean addEmployee(Employee employee) {
		// TODO Auto-generated method stub
		int row=super.getCurrentSession().save(employee).hashCode();
		if(row>0){
			return true;
		}
		return  false;
	}


}

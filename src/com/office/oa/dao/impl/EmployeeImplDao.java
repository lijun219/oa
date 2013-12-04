package com.office.oa.dao.impl;

import java.util.List;
import org.springframework.stereotype.Repository;
import com.office.oa.dao.EmployeeDao;
import com.office.oa.model.Employee;

@Repository(value = "employeeDao")
public class EmployeeImplDao extends BaseDaoO implements EmployeeDao  {


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

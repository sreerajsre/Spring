package com.springmvc_withoutxml_crud_ops.dao;

import java.util.List;

import com.springmvc_withoutxml_crud_ops.pojo.EmployeeBean;


public interface EmployeeDao {
	
	List<EmployeeBean> getEmployeeList();
	void addEmployee(EmployeeBean employeeBean);
	void updateEmployeeDetails(EmployeeBean employeeBean);
	void deleteEmployee(int id);
	void deleteAllEmployee();
	EmployeeBean getSingleUserDetails(int empId);

}

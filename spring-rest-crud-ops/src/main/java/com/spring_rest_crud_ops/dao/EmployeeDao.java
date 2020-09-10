package com.spring_rest_crud_ops.dao;

import java.util.List;

import com.spring_rest_crud_ops.pojo.EmployeeBean;

public interface EmployeeDao {
	EmployeeBean getSingleEmployeeDetails(int empId);
	List<EmployeeBean> getAllEmployeeDetails();
	void deleteSingleEmployee(int empId);
	void updateEmployee(EmployeeBean bean);
	void deleteAllEmployees();
	void addEmployee(EmployeeBean bean);
}

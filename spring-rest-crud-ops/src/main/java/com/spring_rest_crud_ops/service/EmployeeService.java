package com.spring_rest_crud_ops.service;

import java.util.List;

import com.spring_rest_crud_ops.pojo.EmployeeBean;

public interface EmployeeService {
	EmployeeBean getSingleEmployeeDetails(int empId);
	List<EmployeeBean> getAllEmployeeDetails();
	void deleteSingleEmployee(int empId);
	void updateEmployee(EmployeeBean bean);
	void deleteAllEmployees();
	void addEmployee(EmployeeBean bean);

}

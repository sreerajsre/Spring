package com.spring_rest_crud_ops.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.spring_rest_crud_ops.dao.EmployeeDao;
import com.spring_rest_crud_ops.pojo.EmployeeBean;

public class EmployeeServiceImpl implements EmployeeService {
	@Autowired
	EmployeeDao dao;

	@Override
	public EmployeeBean getSingleEmployeeDetails(int empId) {
		return dao.getSingleEmployeeDetails(empId);
	}

	@Override
	public List<EmployeeBean> getAllEmployeeDetails() {
		return dao.getAllEmployeeDetails();
	}

	@Override
	public void deleteSingleEmployee(int empId) {
		dao.deleteSingleEmployee(empId);
		
	}

	@Override
	public void updateEmployee(EmployeeBean bean) {
		dao.updateEmployee(bean);
	}

	@Override
	public void deleteAllEmployees() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addEmployee(EmployeeBean bean) {
		dao.addEmployee(bean);
		
	}

}

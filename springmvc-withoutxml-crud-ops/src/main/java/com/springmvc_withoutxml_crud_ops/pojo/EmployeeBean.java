package com.springmvc_withoutxml_crud_ops.pojo;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class EmployeeBean {
	
	@NotNull(message = "cannot be empty")
	private String employeeName;
	
	@NotNull(message = "cannot be empty")
	private int employeeId;
	
	@NotNull(message = "cannot be empty")
	private int salary;
	
	private int deptId;
	
	
	private String department;
	
	@NotNull(message = "cannot be empty")
	@Size(min = 1, max = 10,message = "length should be between 1 and 10")
	private String city;
	
	@NotNull(message = "cannot be empty")
	@Size(min = 1, max = 10,message = "length should be between 1 and 10")
	private String street;
	
	@NotNull
	private int zipCode;
	
	
	public EmployeeBean() {
		System.out.println("insdie EmployeeBean ");
	}
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	public int getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public int getDeptId() {
		return deptId;
	}
	public void setDeptId(int deptId) {
		this.deptId = deptId;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public int getZipCode() {
		return zipCode;
	}
	public void setZipCode(int zipCode) {
		this.zipCode = zipCode;
	}
	

}

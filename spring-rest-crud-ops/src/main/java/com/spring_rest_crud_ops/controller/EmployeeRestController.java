package com.spring_rest_crud_ops.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.spring_rest_crud_ops.exception.EmployeeCustomException;
import com.spring_rest_crud_ops.pojo.EmployeeBean;
import com.spring_rest_crud_ops.service.EmployeeService;

@RestController
@RequestMapping(value="/api")
public class EmployeeRestController {
	
	@Autowired
	EmployeeService service;

	@GetMapping(value="/home")
	public ModelAndView test(HttpServletResponse response) throws IOException{
		return new ModelAndView("home");
	}
	
	@GetMapping(value="/employees")
	public List<EmployeeBean> getAllEmployeeDetails(){
		List<EmployeeBean> bean =  service.getAllEmployeeDetails();
		return bean;
	}
	
	@GetMapping(value="/employees/{empid}")
	public EmployeeBean getSingleEmployeeDetails(@PathVariable int empid) {
		EmployeeBean bean =  service.getSingleEmployeeDetails(empid);
		return bean;
	}
	
	@PostMapping(value="/employees")
	public void addEmployee(@RequestBody EmployeeBean bean) {
		service.addEmployee(bean);
	}
	
	@PutMapping(value="/employees")
	public void editEmployeeDetail(@RequestBody EmployeeBean bean) {
		service.updateEmployee(bean);
	}
	@DeleteMapping(value="/employees")
	public void deleteEmployee (@RequestBody EmployeeBean bean) {
		service.deleteSingleEmployee(bean.getEmployeeId());;
	}
}

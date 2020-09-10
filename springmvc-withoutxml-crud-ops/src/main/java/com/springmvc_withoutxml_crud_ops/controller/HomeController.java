package com.springmvc_withoutxml_crud_ops.controller;

import java.io.IOException;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.springmvc_withoutxml_crud_ops.dao.EmployeeDao;
import com.springmvc_withoutxml_crud_ops.pojo.EmployeeBean;

@Controller
@RequestMapping("/details")
public class HomeController {
	
	@Autowired
	EmployeeDao employeeDaoImpl;
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		StringTrimmerEditor editor = new StringTrimmerEditor(true);
		binder.registerCustomEditor(String.class, editor);
	}
	
	@GetMapping(value="/emp")
	public ModelAndView showInitialPage() throws IOException{
		List<EmployeeBean> employeeList = employeeDaoImpl.getEmployeeList();
		//List<EmployeeBean> employeeList = new ArrayList<>();
		return new ModelAndView("home","employeeList",employeeList);
	}
	
	@GetMapping("/add")
	public ModelAndView showAddPage() {
		return new ModelAndView("add-employee","employeeData",new EmployeeBean());
	}
	
	@PostMapping("/addData")
	public ModelAndView addEmployee( @Valid @ModelAttribute("employeeData") EmployeeBean employeeBean,
			BindingResult bindingresult) {
		if(bindingresult.hasErrors())
			return new ModelAndView("add-employee"); 
		employeeDaoImpl.addEmployee(employeeBean);
		return new ModelAndView("redirect:emp");
	}
	
	@GetMapping("/edit/{empid}")
	public ModelAndView showEditPage(@PathVariable("empid") int empId) {
		EmployeeBean empBean = employeeDaoImpl.getSingleUserDetails(empId);
		return new ModelAndView("edit-employee","empBean",empBean);
	}
	
	@PostMapping("/editData")
	public ModelAndView editDetails(@Valid @ModelAttribute("empBean") EmployeeBean bean, BindingResult result) {
		if(result.hasErrors())
			return new ModelAndView("edit-employee");
		employeeDaoImpl.updateEmployeeDetails(bean);
		return new ModelAndView("redirect:emp");
	}
	
	@GetMapping("/delete/{empid}")
	public ModelAndView deleteData(@PathVariable("empid") int empId) {
		employeeDaoImpl.deleteEmployee(empId);
		return new ModelAndView("redirect:/details/emp");
	}
}

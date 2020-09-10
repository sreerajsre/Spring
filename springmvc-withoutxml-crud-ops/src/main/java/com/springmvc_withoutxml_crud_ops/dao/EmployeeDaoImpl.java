package com.springmvc_withoutxml_crud_ops.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.springmvc_withoutxml_crud_ops.pojo.EmployeeBean;


public class EmployeeDaoImpl implements EmployeeDao {

	@Autowired
	JdbcTemplate jdbcTemplate;

	@Override
	public EmployeeBean getSingleUserDetails(int empId) {

		return jdbcTemplate.queryForObject("SELECT emp.* ,dept.dept_name FROM spring_mvc.employee_details emp "
				+ "inner join spring_mvc.department_details dept on " + 
				"emp.dept_id = dept.dept_id where emp.emp_id =?", new Object[]{empId}, 
				(rs,rowNum)-> {
					EmployeeBean bean = new EmployeeBean();
					bean.setEmployeeId(rs.getInt("emp_id"));
					bean.setDeptId(rs.getInt("dept_id"));
					bean.setDepartment(rs.getString("dept_name"));
					bean.setEmployeeName(rs.getString("emp_name"));
					bean.setCity(rs.getString("city"));
					bean.setSalary(rs.getInt("salary"));
					bean.setStreet(rs.getString("street"));
					bean.setZipCode(rs.getInt("zipcode"));
					return bean;
				});
	}

	@Override
	public List<EmployeeBean> getEmployeeList() {
		List<EmployeeBean> list = jdbcTemplate.query("SELECT emp.* ,dept.dept_name FROM spring_mvc.employee_details emp inner join spring_mvc.department_details dept on " + 
				"emp.dept_id = dept.dept_id;",
				(rs,num)->{
					EmployeeBean bean =  new EmployeeBean();
					bean.setEmployeeId(rs.getInt("emp_id"));
					bean.setDeptId(rs.getInt("dept_id"));
					bean.setDepartment(rs.getString("dept_name"));
					bean.setEmployeeName(rs.getString("emp_name"));
					bean.setCity(rs.getString("city"));
					bean.setSalary(rs.getInt("salary"));
					bean.setStreet(rs.getString("street"));
					bean.setZipCode(rs.getInt("zipcode"));
					return bean;
				}
				);
		return list;
	}

	@Override
	public void addEmployee(EmployeeBean employeeBean) {
		System.out.println("inside addEmployee");
		jdbcTemplate.update("insert into spring_mvc.employee_details value(default,?,?,?,?,?,?)", 
				(ps)->{
					ps.setString(1, employeeBean.getEmployeeName());
					ps.setInt(2, employeeBean.getDeptId());
					ps.setInt(3, employeeBean.getSalary());
					ps.setString(4, employeeBean.getCity());
					ps.setString(5, employeeBean.getStreet());
					ps.setInt(6, employeeBean.getZipCode());
					System.out.println("ps :"+ps);
				});
	}

	@Override
	public void updateEmployeeDetails(EmployeeBean employeeBean) {
		jdbcTemplate.update("update spring_mvc.employee_details set "
				+ "emp_name =?,dept_id=?,salary=?,city=?,street=?,zipcode=? where emp_id=?;", 
				(ps)->{
					ps.setString(1, employeeBean.getEmployeeName());
					ps.setInt(2, employeeBean.getDeptId());
					ps.setInt(3, employeeBean.getSalary());
					ps.setString(4, employeeBean.getCity());
					ps.setString(5, employeeBean.getStreet());
					ps.setInt(6, employeeBean.getZipCode());
					ps.setInt(7, employeeBean.getEmployeeId());
					System.out.println(ps);
				}
				);
	}

	@Override
	public void deleteEmployee(int empId) {
		jdbcTemplate.update("Delete from spring_mvc.employee_details where emp_id=?", (ps)-> {ps.setInt(1, empId);
		System.out.println(ps);
			});

	}

	@Override
	public void deleteAllEmployee() {
		// TODO Auto-generated method stub

	}

	
}

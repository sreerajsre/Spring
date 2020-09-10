package com.spring_rest_crud_ops.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

import com.spring_rest_crud_ops.exception.EmployeeCustomException;
import com.spring_rest_crud_ops.pojo.EmployeeBean;

public class EmployeeDaoImpl implements EmployeeDao {
	@Autowired
	JdbcTemplate template;

	@Override
	public EmployeeBean getSingleEmployeeDetails(int empId) {
		try {
			EmployeeBean empBean =  template.queryForObject("Select emp.*, dept.dept_name from spring_mvc.employee_details emp "
					+ "inner join spring_mvc.department_details dept on emp.dept_id= dept.dept_id  where emp.emp_id=?", 
					new Object[] {empId}, (rs,count)->{
						if(count <=0)
							return null;
						EmployeeBean bean =  new EmployeeBean();
						bean.setEmployeeId(rs.getInt("emp_id"));
						bean.setEmployeeName(rs.getString("emp_name"));
						bean.setDeptId(rs.getInt("dept_id"));
						bean.setDepartment(rs.getString("dept_name"));
						bean.setSalary(rs.getInt("salary"));
						bean.setCity(rs.getString("city"));
						bean.setStreet(rs.getString("street"));
						bean.setZipCode(rs.getInt("zipcode"));
						return bean;
					});
			return empBean;
		}catch(EmptyResultDataAccessException exc) {
			throw new EmployeeCustomException("Employee not found!");
		}
	}

	@Override
	public List<EmployeeBean> getAllEmployeeDetails() {
		return template.query("Select emp.*, dept.dept_name from spring_mvc.employee_details emp " + 
				"inner join spring_mvc.department_details dept on emp.dept_id= dept.dept_id;", (rs,count)->{
					EmployeeBean bean =  new EmployeeBean();
					bean.setEmployeeId(rs.getInt("emp_id"));
					bean.setEmployeeName(rs.getString("emp_name"));
					bean.setDeptId(rs.getInt("dept_id"));
					bean.setDepartment(rs.getString("dept_name"));
					bean.setSalary(rs.getInt("salary"));
					bean.setCity(rs.getString("city"));
					bean.setStreet(rs.getString("street"));
					bean.setZipCode(rs.getInt("zipcode"));
					return bean;
				});
	}

	@Override
	public void addEmployee(EmployeeBean bean) {
		template.update("insert into spring_mvc.employee_details value (default,?,?,?,?,?,?)", 
				(ps)->{
					ps.setString(1, bean.getEmployeeName());
					ps.setInt(2, bean.getDeptId());
					ps.setInt(3,bean.getSalary());
					ps.setString(4, bean.getCity());
					ps.setString(5, bean.getStreet());
					ps.setInt(6, bean.getZipCode());
				});
	}

	@Override
	public void deleteSingleEmployee(int empId) {
		template.update("Delete from spring_mvc.employee_details where emp_id=?",(ps)->{
			ps.setInt(1, empId);
		});


	}

	@Override
	public void updateEmployee(EmployeeBean bean) {
		template.update("update spring_mvc.employee_details set emp_name=?,"
				+ "dept_id=?,salary=?,city=?,street=?,zipcode=? where emp_id=?",
				(ps)->{
					ps.setString(1, bean.getEmployeeName());
					ps.setInt(2, bean.getDeptId());
					ps.setInt(3, bean.getSalary());
					ps.setString(4, bean.getCity());
					ps.setString(5, bean.getStreet());
					ps.setInt(6, bean.getZipCode());
					ps.setInt(7, bean.getEmployeeId());
					System.out.println(ps);
				});
	}

	@Override
	public void deleteAllEmployees() {
		// TODO Auto-generated method stub

	}

}

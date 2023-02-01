package com.cg.iservice;

import java.util.List;

import com.cg.entity.Employee;

public interface IEmployeeService {
	
	public Employee addEmployee(Employee employee);
	public Employee updateEmployee(Employee employee, int empId);
	public void deleteEmployee(int empId);
	public Employee viewEmployeeById(int empId);
	public List<Employee> viewAllEmployee();
	 public String Login( int empId,String empName);
}

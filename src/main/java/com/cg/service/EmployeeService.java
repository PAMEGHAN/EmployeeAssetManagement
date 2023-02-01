package com.cg.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.entity.Admin;
import com.cg.entity.Employee;
import com.cg.exception.AdminNotFoundException;
import com.cg.exception.EmployeeNotFoundException;
import com.cg.iservice.IEmployeeService;
import com.cg.repository.EmployeeRepository;

@Service
public class EmployeeService implements IEmployeeService {


	String message="Employee Not Found";
	
	@Autowired
	private EmployeeRepository emplRepository;
	
	public Employee addEmployee(Employee employee) {
		emplRepository.save(employee);
		return employee;
	}

	public Employee updateEmployee(Employee employee,int empId) {
		Optional<Employee> employeeDetails=emplRepository.findById(employee.getEmpId());
		 
		 employeeDetails.get().setEmpAddress(employee.getEmpAddress());
		 employeeDetails.get().setContactNo(employee.getContactNo());
		 return emplRepository.save(employeeDetails.get());

	}

	public void deleteEmployee(int empId){
		Optional<Employee> employee=emplRepository.findById(empId);
		if(employee.isEmpty())
			throw new EmployeeNotFoundException(message);
		emplRepository.deleteById(empId);
		}
	
	public Employee viewEmployeeById(int empId){
		Optional<Employee> employee = emplRepository.findById(empId);
		if(employee.isEmpty())
			throw new EmployeeNotFoundException(message);
		return employee.get();
		}

	 public List<Employee> viewAllEmployee(){
		 return emplRepository.findAll();
		 }
	 
	 public String Login( int empId,String empName) {
			Employee employee = emplRepository.findByEmpIdAndEmpName( empId,empName);
			if(emplRepository.findByEmpIdAndEmpName( empId,empName)!=null) {
				return employee.getRole();
			}
			throw new EmployeeNotFoundException("Employee Not Found");
		}

	
}

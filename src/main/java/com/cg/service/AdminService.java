package com.cg.service;

import java.util.ArrayList;
import java.util.List;

//import java.util.logging.Logger;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.entity.Admin;
//import com.cg.entity.Asset;
import com.cg.entity.Employee;
import com.cg.exception.AdminNotFoundException;
import com.cg.exception.EmployeeNotFoundException;
import com.cg.iservice.IAdminService;
import com.cg.repository.AdminRepository;
//import com.cg.repository.AssetRepository;
import com.cg.repository.EmployeeRepository;

@Service
public class AdminService implements IAdminService {
	
	//Logger logger = Logger.getLogger(AdminService.class.getName());
	
	@Autowired
	private AdminRepository adminRepository;
	
	@Autowired
	private EmployeeRepository emplRepository;
	
	List<Employee> empList = new ArrayList<>();

	
	public Employee updateEmpName(Employee employee,int empId) {
		 Employee employeeDetails=emplRepository.findById(employee.getEmpId()).get();
		 
		 employeeDetails.setEmpName(employee.getEmpName());
		 //employeeDetails.setEmpId(employee.getEmpId());
		 return emplRepository.save(employeeDetails);

	}


	


//	public Admin adminLogin(String adminName, String password) {
//		Admin admin = adminRepository.findByAdminNameAndPassword(adminName, password);
//		if(adminRepository.findByAdminNameAndPassword(adminName, password)!=null) {
//			return admin;
//		}
//		throw new AdminNotFoundException("Admin Not Found");
//	}

//  public Employee updateEmpName(int empId, String empName) {
//	  Employee employee = null;
//	  for(Employee emp:empList) {
//		  if(emp.getEmpId()==empId) {
//			  employee= emp;
//			  break;
//		  }
//	  }
//	  if(employee!=null) {
//		  employee.setEmpName(empName);
//		  int index=empList.indexOf(employee);
//		  empList.set(index, employee);
//	  }
//	  return employee;
//  }
//	
//	
	
}

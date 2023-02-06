package com.cg.testcases;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.cg.entity.Asset;
import com.cg.entity.Employee;
import com.cg.repository.EmployeeRepository;
import com.cg.service.EmployeeService;

@SpringBootTest
public class EmployeeTestCases {

	@Mock
	private EmployeeRepository emplRepository;

	@InjectMocks
	private EmployeeService emplService;

	@Test
	void addEmployee() {
		Employee employee = new Employee(1,"Meghana","Hyderabad",9876543210l,"Analyst");
		when(emplRepository.save(employee)).thenReturn(employee);
		Employee employeeDetails = emplService.addEmployee(employee);
		assertThat(employeeDetails.getEmpName().equals(employee.getEmpName()));

	}

	@Test
	void updateEmployee() {
		
		Employee employee = new Employee(1,"Meghana","Hyderabad",9876543210l,"Analyst");
		when(emplRepository.findById(employee.getEmpId())).thenReturn(Optional.of(employee));
		Employee employeeDetails = emplService.updateEmployee(employee,1);
		assertEquals("Hyderabad",employee.getEmpAddress());
		verify(emplRepository,times(1)).findById(employee.getEmpId());

	}

	@Test
	void deleteEmployee() {
		
		Employee employee = new Employee(1,"Meghana","Hyderabad",9876543210l,"Analyst");
		when(emplRepository.findById(employee.getEmpId())).thenReturn(Optional.of(employee));
		emplService.deleteEmployee(employee.getEmpId());
		verify(emplRepository,times(1)).deleteById(employee.getEmpId());
	}

	@Test
	void viewEmployeeById() {
		
		Employee employee = new Employee(1,"Meghana","Hyderabad",9876543210l,"Analyst");
		when(emplRepository.findById(employee.getEmpId())).thenReturn(Optional.of(employee));
		emplService.viewEmployeeById(employee.getEmpId());
	}

	@Test
	void viewAllEmployee() {
		List<Asset> asset1=new ArrayList<>();
		List<Employee> employee = new ArrayList<>();
		when(emplRepository.findAll()).thenReturn(employee);
		emplService.viewAllEmployee();

	}
}


package com.cg.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;

@Entity
public class Employee {
	    @Id
	    @GeneratedValue(strategy=GenerationType.AUTO)
	    private int empId;

       @Column
	   private String empName;

       @Column
       private String empAddress;

       @Column
	    private long contactNo;

       @Column
       private String role;

       
       public Employee() {}


	public Employee(int empId, String empName, String empAddress, long contactNo, String role) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.empAddress = empAddress;
		this.contactNo = contactNo;
		this.role = role;
	}


	public int getEmpId() {
		return empId;
	}


	public void setEmpId(int empId) {
		this.empId = empId;
	}


	public String getEmpName() {
		return empName;
	}


	public void setEmpName(String empName) {
		this.empName = empName;
	}


	public String getEmpAddress() {
		return empAddress;
	}


	public void setEmpAddress(String empAddress) {
		this.empAddress = empAddress;
	}


	public long getContactNo() {
		return contactNo;
	}


	public void setContactNo(long contactNo) {
		this.contactNo = contactNo;
	}


	public String getRole() {
		return role;
	}


	public void setRole(String role) {
		this.role = role;
	}


	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", empName=" + empName + ", empAddress=" + empAddress + ", contactNo="
				+ contactNo + ", role=" + role + "]";
	}

	


}

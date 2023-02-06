package com.cg.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.entity.Asset;
import com.cg.entity.Employee;
import com.cg.service.AdminService;
import com.cg.service.AssetService;
import com.cg.service.EmployeeService;

@RestController
@RequestMapping("/")
@CrossOrigin("*")
public class AdminController {

	//String message="Asset Not Found";

	@Autowired
	private AdminService adminService;

	@Autowired
	private EmployeeService emplService;

	@Autowired
	private AssetService assetService;


	@GetMapping("employee_login/{empId}/{empName}")
	public String Login( @PathVariable("empId") int empId,@PathVariable("empName") String empName) {
	   return emplService.Login( empId,empName);
	}


	@PostMapping("add_Employee")
	public Employee addEmployee(@RequestBody Employee employee) {
		return emplService.addEmployee(employee);
	}

	@GetMapping("view_employeeById/{empId}")
	public Employee viewEmployeeById(@PathVariable("empId")int empId) {
		return emplService.viewEmployeeById(empId);
   }

	@PutMapping("update_EmployeeAddressAndPhoneNo/{empId}")
	public Employee updateEmployee(@PathVariable("empId") int empId,@RequestBody Employee employee) {
		return emplService.updateEmployee(employee,empId);
	}

	@DeleteMapping("delete-Employee/{empId}")
	 public void deleteEmployee(@PathVariable("empId") int empId){
         emplService.deleteEmployee(empId);
      }

	 @GetMapping("view-allemployees")
	 public List<Employee> viewAllEmployees(){
		 return emplService.viewAllEmployee();
	 }


	@PostMapping("add_Asset")
	public Asset addAsset(@RequestBody Asset asset) {
		return assetService.addAsset(asset);
	}

	@PutMapping("update_AllAsset/{id}")
	public Asset updateAsset(@PathVariable("id") int id,@RequestBody Asset asset) {
		return assetService.updateAsset(id,asset);
	}

	@DeleteMapping("deleteAsset/{itemNum}")
	public void deleteAsset(@PathVariable("itemNum") int itemNum)  {
		assetService.deleteAsset(itemNum);
	}

	@GetMapping("retrive_AllAssets")
	public List<Asset> retriveAllAsset(){
		return assetService.retrieveAllAssets();
	}

	@PutMapping("updateEmpName/{empId}")
	public Employee updateEmpName(@PathVariable("empId") int empId, @RequestBody Employee employee) {
		return adminService.updateEmpName(employee,empId);
	}


	@GetMapping("/getAssetByEmpId/{empId}")
	public List<Asset> getAssetByEmpId(@PathVariable("empId") int empId) {
		return  assetService.getAssetByEmpId(empId);
	}
}

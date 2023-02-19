package com.jubayer.spring_boot_api.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jubayer.spring_boot_api.model.Employee;
import com.jubayer.spring_boot_api.service.EmployeeServices;


@RestController
public class EmployeeController {
	
	@Autowired
	private EmployeeServices eService;
	
	@GetMapping("/employees")
	public List<Employee> getAllEmployees() {
		return eService.getEmployees();
	}
	
	
	@GetMapping("/employee/{id}")
	public Employee getEmployee(@PathVariable Long id) {
		return eService.getSingleEmployee(id);
	}
	
	@DeleteMapping("/employee")
	public void deleteEmployee(@RequestParam Long id) {
		 eService.deleteEmployee(id);
	}
	
	@PostMapping("employees")
	public Employee saveEmployee(@RequestBody Employee employee ) {
	
		return eService.saveEmployee(employee);
	}
	
	@PutMapping("/employee/{id}")
	public Employee updateEmployee(@PathVariable Long id,@RequestBody Employee employee) {
		
		employee.setId(id);
		return eService.updateEmployee(employee);
	}
	

}

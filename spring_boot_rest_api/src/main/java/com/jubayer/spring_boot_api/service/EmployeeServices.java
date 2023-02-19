package com.jubayer.spring_boot_api.service;

import java.util.List;

import com.jubayer.spring_boot_api.model.Employee;

public interface EmployeeServices {
	
	List<Employee> getEmployees();
	
	Employee saveEmployee(Employee employee);
	
	Employee getSingleEmployee(Long id);
	
	void deleteEmployee(Long id);
	
	Employee updateEmployee(Employee employee);

}

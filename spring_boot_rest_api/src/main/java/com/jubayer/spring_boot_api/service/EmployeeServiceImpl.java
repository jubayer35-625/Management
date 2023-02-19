package com.jubayer.spring_boot_api.service;

import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.stereotype.Service;

import com.jubayer.spring_boot_api.model.Employee;
import com.jubayer.spring_boot_api.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeServices {
	
	@Autowired
	private EmployeeRepository eRepository;

	@Query("select * from tbl_employee")
	@Override
	public List<Employee> getEmployees() {
		
		return eRepository.findAll();
	}
	
	
	@Override
	public Employee saveEmployee(Employee employee) {
		
		Employee e = new Employee();
		e.setId(employee.getId());
		e.setAge(employee.getAge());
		e.setName(employee.getName());
		e.setEmail(employee.getEmail());
		e.setDepartment(employee.getDepartment());
		e.setLocation(employee.getLocation());
		return eRepository.save(e);
	}


	@Override
	public Employee getSingleEmployee(Long id) {
		Optional<Employee> employee = eRepository.findById(id);
		
		if(employee.isPresent()) {
			
			return employee.get();
		}
		throw new RuntimeException("Employee is not Aviable ID: "+id);
	
	}


	@Override
	public void deleteEmployee(Long id) {
		
		eRepository.deleteById(id);
	}


	@Override
	public Employee updateEmployee(Employee employee) {
		// TODO Auto-generated method stub
		
		return eRepository.save(employee);
		
	}
	
	
	
	
	
	

}

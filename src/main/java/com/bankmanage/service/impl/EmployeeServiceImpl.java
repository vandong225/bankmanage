package com.bankmanage.service.impl;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.bankmanage.exception.ResourceNotFoundException;
import com.bankmanage.model.Employee;
import com.bankmanage.repository.EmployeeRepository;
import com.bankmanage.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository repository;
	
//	@Autowired
//	private EmployeeModelAssembler assembler;
	
	@Override
	public Employee createEmployee(Employee newEmployee) {
		// TODO Auto-generated method stub
		Employee entityModel = repository.save(newEmployee);
		return entityModel;
	}

	@Override
	public Employee updateEmployee(Long id, Employee newEmployee) {
		// TODO Auto-generated method stub

		 Employee employeePut = repository.findById(id)
	      .map(employee -> {
	        employee.setFullName(newEmployee.getFullName());
	        employee.setAddress(newEmployee.getAddress());
	        employee.setIdCard(newEmployee.getIdCard());
	        employee.setDob(newEmployee.getDob());
	        employee.setLevel(newEmployee.getLevel());
	        employee.setYear(newEmployee.getYear());
	        employee.setPosition(newEmployee.getPosition());
	        return repository.save(employee);
	      })
	      .orElseThrow(() -> new ResourceNotFoundException("not found employee "+ id));
		 return employeePut;
	}

	@Override
	public String deleteEmployee(Long id) {
		// TODO Auto-generated method stub
		 repository.deleteById(id);
		 return "Delete employee";
	}


	@Override
	public List<Employee> getAllEmployee() {
		// TODO Auto-generated method stub
		List<Employee> employees = repository.findAll();
		 return employees;
	}

	@Override
	public Employee getEmployeeById(Long id) {
		// TODO Auto-generated method stub
		Employee employee = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("not found employee "+ id));
		return employee;
	}

}

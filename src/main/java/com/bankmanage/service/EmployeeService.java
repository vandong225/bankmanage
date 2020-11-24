package com.bankmanage.service;


import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.ResponseEntity;

import com.bankmanage.model.Employee;

public interface EmployeeService {
	 public abstract ResponseEntity<EntityModel<Employee>> createEmployee(Employee employee);
	   public abstract EntityModel<Employee> updateEmployee(Long id, Employee employee);
	   public abstract ResponseEntity<String> deleteEmployee(Long id);
	   public abstract CollectionModel<EntityModel<Employee>> getAllEmployee();
	   public abstract EntityModel<Employee> getEmployeeById(Long id);
}

package com.bankmanage.service;


import java.util.List;

import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.ResponseEntity;

import com.bankmanage.model.Employee;

public interface EmployeeService {
	 public abstract Employee createEmployee(Employee employee);
	   public abstract Employee updateEmployee(Long id, Employee employee);
	   public abstract String deleteEmployee(Long id);
	   public abstract List<Employee> getAllEmployee();
	   public abstract Employee getEmployeeById(Long id);
	   public abstract Boolean checkExistByIdCard(String idCard);
}

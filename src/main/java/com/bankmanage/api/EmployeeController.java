package com.bankmanage.api;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.bankmanage.model.Employee;
import com.bankmanage.service.EmployeeService;


@RestController
@RequestMapping(path = "/api/v1", produces = "application/json")
@CrossOrigin(origins = "*")
public class EmployeeController {
	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping("/employees")
	@ResponseStatus(code = HttpStatus.OK)
	public CollectionModel<EntityModel<Employee>> getAll() {
		return employeeService.getAllEmployee();
	}
	
	@GetMapping("/employee/{id}")
 	public EntityModel<Employee> getEmployee(@PathVariable long id) {
		return employeeService.getEmployeeById(id);
	}
	
	@PostMapping("/employee")
	public ResponseEntity<EntityModel<Employee>> newEmployee(@RequestBody Employee newEmployee) {
		return employeeService.createEmployee(newEmployee);
	  }
	
	 @PutMapping("/employee/{id}")
	 public EntityModel<Employee> replaceEmployee(@RequestBody Employee newEmployee, @PathVariable Long id) {
		return employeeService.updateEmployee(id, newEmployee);
	  }
	 
	 @DeleteMapping("/employee/{id}")
	 ResponseEntity<String> deleteEmployee(@PathVariable Long id) {
		 return employeeService.deleteEmployee(id);
	  }
}

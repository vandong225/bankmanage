package com.bankmanage.api;


import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.bankmanage.model.Employee;
import com.bankmanage.service.CreditAccountService;
import com.bankmanage.service.DebitAccountService;
import com.bankmanage.service.EmployeeService;


@RestController
@RequestMapping(path = "/api/v1", produces = "application/json")
@CrossOrigin(origins = "*")
public class EmployeeController {
	@Autowired
	private EmployeeService employeeService;
//	private DebitAccountService debitAccountService;
//	private CreditAccountService creditAccountService;
	
	@GetMapping("/employees")
	@ResponseStatus(code = HttpStatus.OK)
	public ResponseEntity<List<Employee>> getAll() {
		return ResponseEntity.ok(employeeService.getAllEmployee());
	}
	
	@GetMapping("/employee/{id}")
 	public ResponseEntity<Employee> getEmployee(@PathVariable long id) {
		return ResponseEntity.ok(employeeService.getEmployeeById(id));
	}
	
	@PostMapping("/employee")
	public ResponseEntity<Employee> newEmployee(@RequestBody Employee newEmployee) {
		boolean isExist = employeeService.checkExistByIdCard(newEmployee.getIdCard());
		System.out.println(isExist);
		if(!isExist)
		{
			return ResponseEntity.ok(employeeService.createEmployee(newEmployee));
		}
		return ResponseEntity.noContent().build();
	  }
	
	 @PutMapping("/employee/{id}")
	 public Employee replaceEmployee(@RequestBody Employee newEmployee, @PathVariable Long id) {
		return employeeService.updateEmployee(id, newEmployee);
	  }
	 
	 @DeleteMapping("/employee/{id}")
	 ResponseEntity<String> deleteEmployee(@PathVariable Long id) {
		 return ResponseEntity.ok(employeeService.deleteEmployee(id));
	 }
	 
	 @GetMapping("/employee/{id}/salery")
	 ResponseEntity<Float> salaryEmployee( @PathVariable Long id, @RequestParam("fromDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date fromDate, @RequestParam("toDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date toDate){
		 return ResponseEntity.ok(employeeService.salary(id, fromDate, toDate));
	 }
}

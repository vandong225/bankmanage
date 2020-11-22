package com.bankmanage.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.bankmanage.exception.NotFoundException;
import com.bankmanage.model.Employee;
import com.bankmanage.repository.AddressRepository;
import com.bankmanage.repository.EmployeeRepository;
import com.bankmanage.repository.FullNameRepository;

import lombok.NoArgsConstructor;


@RestController
@RequestMapping(path = "/api/v1", produces = "application/json")
public class EmployeeController {
	@Autowired
	private EmployeeRepository repository;
	
	@Autowired
	private AddressRepository addressRepo;
	
	@Autowired
	private FullNameRepository fullNameRepo;

	public EmployeeController(EmployeeRepository repository, AddressRepository addressRepo, FullNameRepository fullNameRepo) {
		this.repository = repository;
		this.addressRepo = addressRepo;
		this.fullNameRepo = fullNameRepo;
	}
	
	@GetMapping("/employees")
	@ResponseStatus(code = HttpStatus.OK)
	List<Employee> getAll() {
		return repository.findAll();
	}
	
	@GetMapping("/employee/{id}")
	Employee getEmployee(@PathVariable long id) throws NotFoundException {
		return repository.findById(id).orElseThrow(() -> new NotFoundException("khong tim thay employee "+id));
	}
	
	@PostMapping("/employee")
	Employee newEmployee(@RequestBody Employee newEmployee) {
	    return repository.save(newEmployee);
	  }
	
	 @PutMapping("/employees/{id}")
	  Employee replaceEmployee(@RequestBody Employee newEmployee, @PathVariable Long id) {

	    return repository.findById(id)
	      .map(employee -> {
	        employee.setFullName(newEmployee.getFullName());
//	        employee.setAddress(newEmployee.getAddress());
	        employee.setIdCard(newEmployee.getIdCard());
	        employee.setDob(newEmployee.getDob());
	        return repository.save(employee);
	      })
	      .orElseGet(() -> {
	        newEmployee.setId(id);
	        return repository.save(newEmployee);
	      });
	  }
	 
	 @DeleteMapping("/employees/{id}")
	  void deleteEmployee(@PathVariable Long id) {
	    repository.deleteById(id);
	  }
}

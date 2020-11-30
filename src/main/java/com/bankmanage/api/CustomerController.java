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

import com.bankmanage.model.Customer;
import com.bankmanage.service.CustomerService;


@RestController
@RequestMapping(path = "/api/v1", produces = "application/json")
@CrossOrigin(origins = "*")
public class CustomerController {
	@Autowired
	private CustomerService CustomerService;
	
	@GetMapping("/Customers")
	@ResponseStatus(code = HttpStatus.OK)
	public CollectionModel<EntityModel<Customer>> getAll() {
		return CustomerService.getAllCustomer();
	}
	
	@GetMapping("/Customer/{id}")
 	public EntityModel<Customer> getCustomer(@PathVariable long id) {
		return CustomerService.getCustomerById(id);
	}
	
	@PostMapping("/Customer")
	public ResponseEntity<EntityModel<Customer>> newCustomer(@RequestBody Customer newCustomer) {
		return CustomerService.createCustomer(newCustomer);
	  }
	
	 @PutMapping("/Customer/{id}")
	 public EntityModel<Customer> replaceCustomer(@RequestBody Customer newCustomer, @PathVariable Long id) {
		return CustomerService.updateCustomer(id, newCustomer);
	  }
	 
	 @DeleteMapping("/Customer/{id}")
	 ResponseEntity<String> deleteCustomer(@PathVariable Long id) {
		 return CustomerService.deleteCustomer(id);
	  }
}

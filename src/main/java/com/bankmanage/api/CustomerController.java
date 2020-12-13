package com.bankmanage.api;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
import com.bankmanger.dto.RequestPurchaseDTO;


@RestController
@RequestMapping(path = "/api/v1", produces = "application/json")
@CrossOrigin(origins = "*")
public class CustomerController {
	@Autowired
	private CustomerService CustomerService;
	
	@GetMapping("/customers")
	@ResponseStatus(code = HttpStatus.OK)
	public ResponseEntity<List<Customer>> getAll() {
		return ResponseEntity.ok(CustomerService.getAllCustomer());
	}
	@GetMapping("/top10")
	public ResponseEntity<List<Customer>> getTop10(){
		return ResponseEntity.ok(CustomerService.getTop10());
	}
	@GetMapping("/customer/{id}")
 	public ResponseEntity<Customer> getCustomer(@PathVariable long id) {
		return ResponseEntity.ok(CustomerService.getCustomerById(id));
	}
	
	@PostMapping("/customer")
	public ResponseEntity<Customer> newCustomer(@RequestBody Customer newCustomer) {
		System.out.println(newCustomer);
		if(!CustomerService.checkExistByIdCard(newCustomer.getIdCard())) {
		return ResponseEntity.ok(CustomerService.createCustomer(newCustomer));
		}
		return ResponseEntity.noContent().build();
	  }
	
	 @PutMapping("/customer/{id}")
	 public ResponseEntity<Customer> replaceCustomer(@RequestBody Customer newCustomer, @PathVariable Long id) {
		return ResponseEntity.ok(CustomerService.updateCustomer(id, newCustomer));
	  }
	 
	 @DeleteMapping("/customer/{id}")
	 ResponseEntity<String> deleteCustomer(@PathVariable Long id) {
		 return ResponseEntity.ok(CustomerService.deleteCustomer(id));
	  }
	 @PutMapping("/payment")
		public ResponseEntity<Customer> Payment(@RequestBody RequestPurchaseDTO requestObject){
			return ResponseEntity.ok(CustomerService.updatePayment( requestObject.getMoney(),requestObject.getIdCredit(),requestObject.getIdDebit()));
		}
}

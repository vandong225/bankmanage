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

import com.bankmanage.model.DebitAccount;
import com.bankmanage.model.Employee;
import com.bankmanage.service.DebitAccountService;
import com.bankmanage.service.EmployeeService;

@RestController
@RequestMapping(path = "/api/v1/debit", produces = "application/json")
@CrossOrigin(origins = "*")
public class DebitAccountController {
	@Autowired
	private DebitAccountService debitAccountService;
	
	@GetMapping("/accounts")
	@ResponseStatus(code = HttpStatus.OK)
	public CollectionModel<EntityModel<DebitAccount>> getAll() {
		return debitAccountService.getAllDebitAccount();
	}
	
	@GetMapping("/account/{id}")
 	public EntityModel<DebitAccount> getDebit(@PathVariable long id) {
		return debitAccountService.getDebitAccountById(id);
	}
	
	@PostMapping("/account")
	public ResponseEntity<EntityModel<DebitAccount>> newDebit(@RequestBody DebitAccount debitAccount) {
		return debitAccountService.createDebitAccount(debitAccount);
	  }
	
	 @PutMapping("/account/{id}")
	 public EntityModel<DebitAccount> replaceDebit(@RequestBody DebitAccount debitAccount, @PathVariable Long id) {
		return debitAccountService.updateDebitAccount(id, debitAccount);
	  }
	 
	 @DeleteMapping("/account/{id}")
	 ResponseEntity<String> deleteDebit(@PathVariable Long id) {
		 return debitAccountService.deleteDebitAccount(id);
	  }
}

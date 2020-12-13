package com.bankmanage.api;

import java.util.List;

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

import com.bankmanage.model.CreditAccount;
import com.bankmanage.model.DebitAccount;
import com.bankmanage.service.CreditAccountService;
import com.bankmanage.service.DebitAccountService;
import com.bankmanger.dto.RequestPurchaseDTO;

@RestController
@RequestMapping(path = "/api/v1/credit", produces = "application/json")
@CrossOrigin(origins = "*")
public class CreditAccountController {
	@Autowired
	private CreditAccountService creditAccountService;
	
	@GetMapping("/accounts")
	@ResponseStatus(code = HttpStatus.OK)
	public ResponseEntity<List<CreditAccount>> getAll() {
		return ResponseEntity.ok(creditAccountService.getAllCreditAccount());
	}
	
	@GetMapping("/account/{id}")
 	public ResponseEntity<CreditAccount> getCredit(@PathVariable long id) {
		return ResponseEntity.ok(creditAccountService.getCreditAccountById(id));
	}
//purchase-> id, body: money : -> update tien credit, tao history
	@PutMapping("/purchase")
	public ResponseEntity<CreditAccount> Purchase(@RequestBody RequestPurchaseDTO requestObject){
		return ResponseEntity.ok(creditAccountService.updatePurchase(requestObject.getIdCredit(), requestObject.getMoney()));
	}
//payment
	
	@PostMapping("/account")
	public ResponseEntity<CreditAccount> newCredit(@RequestBody CreditAccount creditAccount) {
		return ResponseEntity.ok(creditAccountService.createCreditAccount(creditAccount));
	  }
	
	 @PutMapping("/account/{id}")
	 public ResponseEntity<CreditAccount> replaceCredit(@RequestBody CreditAccount creditAccount, @PathVariable Long id) {
		return ResponseEntity.ok(creditAccountService.updateCreditAccount(id, creditAccount));
	  }
	 
	 @DeleteMapping("/account/{id}")
	 ResponseEntity<String> deleteCredit(@PathVariable Long id) {
		 return ResponseEntity.ok(creditAccountService.deleteCreditAccount(id));
	  }
	 
	 @GetMapping("/debt")
	 ResponseEntity<List<CreditAccount>> getAccountByDebt(){
		 return ResponseEntity.ok(creditAccountService.getAccountByDebt());
	 }

	 
}

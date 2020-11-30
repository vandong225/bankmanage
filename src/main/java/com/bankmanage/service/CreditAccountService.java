package com.bankmanage.service;

import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.ResponseEntity;

import com.bankmanage.model.CreditAccount;

public interface CreditAccountService {
	 public abstract ResponseEntity<EntityModel<CreditAccount>> createCreditAccount(CreditAccount creditAccount);
	   public abstract EntityModel<CreditAccount> updateCreditAccount(Long id, CreditAccount creditAccount);
	   public abstract ResponseEntity<String> deleteCreditAccount(Long id);
	   public abstract CollectionModel<EntityModel<CreditAccount>> getAllCreditAccount();
	   public abstract EntityModel<CreditAccount> getCreditAccountById(Long id);
}

package com.bankmanage.service;

import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.ResponseEntity;

import com.bankmanage.model.DebitAccount;

public interface DebitAccountService {
	 public abstract ResponseEntity<EntityModel<DebitAccount>> createDebitAccount(DebitAccount debitAccount);
	   public abstract EntityModel<DebitAccount> updateDebitAccount(Long id, DebitAccount debitAccount);
	   public abstract ResponseEntity<String> deleteDebitAccount(Long id);
	   public abstract CollectionModel<EntityModel<DebitAccount>> getAllDebitAccount();
	   public abstract EntityModel<DebitAccount> getDebitAccountById(Long id);
}

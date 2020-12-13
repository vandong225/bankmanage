package com.bankmanage.service;

import java.util.List;

import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.ResponseEntity;

import com.bankmanage.model.DebitAccount;

public interface DebitAccountService {
	 public abstract DebitAccount createDebitAccount(DebitAccount debitAccount);
	   public abstract DebitAccount updateDebitAccount(Long id, DebitAccount debitAccount);
	   public abstract String deleteDebitAccount(Long id);
	   public abstract List<DebitAccount> getAllDebitAccount();
	   public abstract DebitAccount getDebitAccountById(Long id);
	   public abstract List<DebitAccount> getDebitAccountByCusId(Long id); 
}

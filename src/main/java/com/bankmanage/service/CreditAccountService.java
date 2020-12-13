package com.bankmanage.service;

import java.util.List;

import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.ResponseEntity;

import com.bankmanage.model.CreditAccount;

public interface CreditAccountService {
	 public abstract CreditAccount createCreditAccount(CreditAccount creditAccount);
	   public abstract CreditAccount updateCreditAccount(Long id, CreditAccount creditAccount);
	   public abstract String deleteCreditAccount(Long id);
	   public abstract List<CreditAccount> getAllCreditAccount();
	   public abstract CreditAccount getCreditAccountById(Long id);
	   public abstract List<CreditAccount> getAccountByDebt();
	   public abstract CreditAccount updatePurchase(long id, float money);
	   public abstract CreditAccount updatePayment(long id, float money);
}

package com.bankmanage.service.impl;

import static java.util.stream.Collectors.toList;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.IanaLinkRelations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.bankmanage.api.CreditAccountController;
import com.bankmanage.api.DebitAccountController;
import com.bankmanage.exception.ResourceNotFoundException;
import com.bankmanage.model.CreditAccount;
import com.bankmanage.model.DebitAccount;
import com.bankmanage.repository.CreditAccountRepository;
import com.bankmanage.repository.DebitAccountRepository;
import com.bankmanage.service.CreditAccountService;

@Service
public class CreditAccountServiceImpl implements CreditAccountService {
	
	@Autowired
	private CreditAccountRepository repository;
	

	@Override
	public CreditAccount createCreditAccount(CreditAccount newCreditAccount) {
		// TODO Auto-generated method stub
		CreditAccount creditAccount = repository.save(newCreditAccount);
		return creditAccount;
	}

	@Override
	public CreditAccount updateCreditAccount(Long id, CreditAccount creditAccount) {
		// TODO Auto-generated method stub
		CreditAccount creditAccountPut = repository.findById(id)
			      .map(account -> {
			       account.setBalance(creditAccount.getBalance());
			       account.setDebt(creditAccount.getDebt());
			        return repository.save(account);
			      })
			      .orElseThrow(() -> new ResourceNotFoundException("not found credit account "+ id));
				 return creditAccountPut;
	}

	@Override
	public String deleteCreditAccount(Long id) {
		// TODO Auto-generated method stub
		repository.deleteById(id);
		 return "Delete credit account "+id;
	}

	@Override
	public List<CreditAccount> getAllCreditAccount() {
		// TODO Auto-generated method stub
		List<CreditAccount> listCreditAccount = repository.findAll();
		return listCreditAccount;
	}

	@Override
	public CreditAccount getCreditAccountById(Long id) {
		// TODO Auto-generated method stub
		CreditAccount creditAccount = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("khong tim thay account" + id));
		return creditAccount;
	}

}

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

import com.bankmanage.api.DebitAccountController;
import com.bankmanage.api.EmployeeController;
import com.bankmanage.exception.ResourceNotFoundException;
import com.bankmanage.model.DebitAccount;
import com.bankmanage.model.Employee;
import com.bankmanage.repository.DebitAccountRepository;
import com.bankmanage.repository.EmployeeRepository;
import com.bankmanage.service.DebitAccountService;

@Service
public class DebitAccountServiceImpl implements DebitAccountService {

	@Autowired
	private DebitAccountRepository repository;
	

	@Override
	public DebitAccount createDebitAccount(DebitAccount debitAccount) {
		// TODO Auto-generated method stub
		DebitAccount entityModel = repository.save(debitAccount);
		return entityModel;
	}

	@Override
	public DebitAccount updateDebitAccount(Long id, DebitAccount debitAccount) {
		// TODO Auto-generated method stub

		DebitAccount debitAccountPut = repository.findById(id)
	      .map(account -> {
	       account.setBalance(debitAccount.getBalance());
	       account.setMinBalance(debitAccount.getMinBalance());
	       account.setRate(debitAccount.getRate());
	        return repository.save(account);
	      })
	      .orElseThrow(() -> new ResourceNotFoundException("not found debit account "+ id));
		 return debitAccountPut;
	}

	@Override
	public String deleteDebitAccount(Long id) {
		// TODO Auto-generated method stub
		 repository.deleteById(id);
		 return "Delete debit account "+id;
	}

	@Override
	public List<DebitAccount> getAllDebitAccount() {
		// TODO Auto-generated method stub
		List<DebitAccount> listDebitAccount = repository.findAll();
		return listDebitAccount;
	}

	@Override
	public DebitAccount getDebitAccountById(Long id) {
		// TODO Auto-generated method stub
		DebitAccount debitAccount = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("khong tim thay account" + id));
		return debitAccount;
	}
	

}

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
import com.bankmanage.assembler.CreditAccountModelAssembler;
import com.bankmanage.assembler.DebitAccountModelAssembler;
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
	
	@Autowired
	private  CreditAccountModelAssembler assembler;

	@Override
	public ResponseEntity<EntityModel<CreditAccount>> createCreditAccount(CreditAccount newCreditAccount) {
		// TODO Auto-generated method stub
		EntityModel<CreditAccount> creditAccount = assembler.toModel(repository.save(newCreditAccount));
		return ResponseEntity.created(creditAccount.getRequiredLink(IanaLinkRelations.SELF).toUri()).body(creditAccount);
	}

	@Override
	public EntityModel<CreditAccount> updateCreditAccount(Long id, CreditAccount creditAccount) {
		// TODO Auto-generated method stub
		CreditAccount creditAccountPut = repository.findById(id)
			      .map(account -> {
			       account.setBalance(creditAccount.getBalance());
			       account.setDebt(creditAccount.getDebt());
			        return repository.save(account);
			      })
			      .orElseThrow(() -> new ResourceNotFoundException("not found credit account "+ id));
				 return assembler.toModel(creditAccountPut);
	}

	@Override
	public ResponseEntity<String> deleteCreditAccount(Long id) {
		// TODO Auto-generated method stub
		repository.deleteById(id);
		 return new ResponseEntity<String>("Delete credit account "+id, HttpStatus.OK);
	}

	@Override
	public CollectionModel<EntityModel<CreditAccount>> getAllCreditAccount() {
		// TODO Auto-generated method stub
		List<EntityModel<CreditAccount>> listCreditAccount = repository.findAll().stream()//
				.map(assembler::toModel).collect(toList());
		return CollectionModel.of(listCreditAccount,linkTo(methodOn(CreditAccountController.class).getAll()).withSelfRel());
	}

	@Override
	public EntityModel<CreditAccount> getCreditAccountById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

}

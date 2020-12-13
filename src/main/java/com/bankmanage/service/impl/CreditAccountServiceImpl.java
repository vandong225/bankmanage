package com.bankmanage.service.impl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bankmanage.exception.ResourceNotFoundException;
import com.bankmanage.model.CreditAccount;
import com.bankmanage.model.HistoryTranfer;
import com.bankmanage.repository.CreditAccountRepository;
import com.bankmanage.repository.HistoryTranferRepository;
import com.bankmanage.service.CreditAccountService;
import com.bankmanger.dto.InfoDebtDTO;


@Service
public class CreditAccountServiceImpl implements CreditAccountService {
	
	@Autowired
	private CreditAccountRepository repository;
	
	@Autowired
	private HistoryTranferRepository historyRepo;

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
	
	@Override
	public List<CreditAccount> getAccountByDebt() {
		List<CreditAccount> accounts = repository.findAllByOrderByDebtDesc();
		return accounts;
	}

    @Override
    public CreditAccount updatePurchase(long id, float money) {
    	CreditAccount creditAccountPut = repository.findById(id)
			      .map(account -> {
			       account.setDebt(account.getDebt()+money);
			        return repository.save(account);
			      })
			      .orElseThrow(() -> new ResourceNotFoundException("not found credit account "+ id));
    	HistoryTranfer newHistoryTranfer = new HistoryTranfer();
    	newHistoryTranfer.setCredit(creditAccountPut);
    	newHistoryTranfer.setMoney(money);
    	historyRepo.save(newHistoryTranfer);
				 return creditAccountPut;
    }
    @Override
    public CreditAccount updatePayment(long id, float money) {
    	
    	CreditAccount creditAccountPut = repository.findById(id)
			      .map(account -> {
			       account.setDebt(account.getDebt()-money);
			        return repository.save(account);
			      })
			      .orElseThrow(() -> new ResourceNotFoundException("not found credit account "+ id));
    	HistoryTranfer newHistoryTranfer = new HistoryTranfer();
    	newHistoryTranfer.setCredit(creditAccountPut);
    	newHistoryTranfer.setMoney(0-money);
    	historyRepo.save(newHistoryTranfer);
				 return creditAccountPut;
    }

	@Override
	public List<InfoDebtDTO> getAccountsByDebt() {
		List<InfoDebtDTO> accounts = repository.findDebtDesc();
		return accounts;
	}
}

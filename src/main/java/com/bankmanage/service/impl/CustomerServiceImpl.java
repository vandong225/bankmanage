package com.bankmanage.service.impl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bankmanage.exception.ResourceNotFoundException;
import com.bankmanage.model.CreditAccount;
import com.bankmanage.model.Customer;
import com.bankmanage.model.DebitAccount;
import com.bankmanage.model.HistoryTranfer;
import com.bankmanage.repository.CreditAccountRepository;
import com.bankmanage.repository.CustomerRepository;
import com.bankmanage.repository.DebitAccountRepository;
import com.bankmanage.repository.HistoryTranferRepository;
import com.bankmanage.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {
	@Autowired
	private CustomerRepository repository;
	@Autowired
	private DebitAccountRepository repositoryDebit;
	@Autowired
	private CreditAccountRepository reponsitoryCredit;
	@Autowired
	private HistoryTranferRepository historyRepo;


	@Override
	public Customer createCustomer(Customer customer) {
		// TODO Auto-generated method stub
		Customer entityModel = repository.save(customer);
		return entityModel;
	}

	@Override
	public Customer updateCustomer(Long id, Customer newCustomer) {
		// TODO Auto-generated method stub
		Customer customerPut = repository.findById(id)
			      .map(customer -> {
			    	  customer.setFullName(newCustomer.getFullName());
			    	  customer.setAddress(newCustomer.getAddress());
			    	  customer.setIdCard(newCustomer.getIdCard());
			    	  customer.setDob(newCustomer.getDob());
			        return repository.save(customer);
			      })
			      .orElseThrow(() -> new ResourceNotFoundException("not found customer "+ id));
				 return customerPut;
	}

	@Override
	public String deleteCustomer(Long id) {
		// TODO Auto-generated method stub
		 repository.deleteById(id);
		 return "Delete customer "+id;
	}

	@Override
	public List<Customer> getAllCustomer() {
		// TODO Auto-generated method stub
		List<Customer> customers = repository.findAll();
		return customers;
	}

	@Override
	public Customer getCustomerById(Long id) {
		// TODO Auto-generated method stub
		Customer customer = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("not found customer "+ id));
		return customer;
	}
	
	@Override
	public Boolean checkExistByIdCard(String idCard) {
		Customer customer = repository.findByIdCard(idCard);
		if(customer==null) 
			return false;
		int sizeCredit = customer.getCredits().size();
		int sizeDebit = customer.getDebits().size();
		if(sizeCredit>=2||sizeDebit>=3)
			return false;
		return true;
	}
	
	

	
    @Override
    public List<Customer> getTop10(){
        List<Customer> customers = repository.getTop10();
        int index = Math.min(customers.size(),9);
        return customers.subList(0, index);
    }
	@Override
	public Customer updatePayment(Float money, Long idCredit, Long idDebit) {
		DebitAccount debitAccount = repositoryDebit.findById(idDebit).orElseThrow(() -> new ResourceNotFoundException("not found debit "));
		System.out.println(debitAccount.getBalance()+ " "+money + " " +debitAccount.getMinBalance());
		if(debitAccount.getBalance()-money>debitAccount.getMinBalance()) {
			repositoryDebit.findById(idDebit).map(account -> {
			       account.setBalance(debitAccount.getBalance()-money);
			        return repositoryDebit.save(account);
			      })
			      .orElseThrow(() -> new ResourceNotFoundException("not found debit account "));
		CreditAccount creditAccount = reponsitoryCredit.findById(idCredit).map(account -> {
			float moneyPay = account.getDebt()-money >= 0 ? account.getDebt()-money : 0;
		       account.setDebt(moneyPay);
		       HistoryTranfer newHistoryTranfer = new HistoryTranfer();
		    	newHistoryTranfer.setCredit(account);
		    	newHistoryTranfer.setMoney(0-money);
		    	historyRepo.save(newHistoryTranfer);
		        return reponsitoryCredit.save(account);
		      })
		      .orElseThrow(() -> new ResourceNotFoundException("not found credit account "));
		}
		return null;
	}

}

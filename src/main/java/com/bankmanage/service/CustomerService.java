package com.bankmanage.service;

import java.util.List;

import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.ResponseEntity;


import com.bankmanage.model.Customer;

public interface CustomerService {
	public abstract Customer createCustomer(Customer customer);

	public abstract Customer updateCustomer(Long id, Customer customer);

	public abstract String deleteCustomer(Long id);

	public abstract List<Customer> getAllCustomer();

	public abstract Customer getCustomerById(Long id);
	
	public abstract Boolean checkExistByIdCard(String idCard);
	
	
	public abstract List<Customer> getTop10();
	
	public abstract Customer updatePayment(Float money, Long idCredit, Long idDebit);
}

package com.bankmanage.service;

import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.ResponseEntity;


import com.bankmanage.model.Customer;

public interface CustomerService {
	public abstract ResponseEntity<EntityModel<Customer>> createCustomer(Customer customer);

	public abstract EntityModel<Customer> updateCustomer(Long id, Customer customer);

	public abstract ResponseEntity<String> deleteCustomer(Long id);

	public abstract CollectionModel<EntityModel<Customer>> getAllCustomer();

	public abstract EntityModel<Customer> getCustomerById(Long id);
}

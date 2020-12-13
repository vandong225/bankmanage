package com.bankmanage.service.impl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bankmanage.exception.ResourceNotFoundException;
import com.bankmanage.model.Customer;
import com.bankmanage.repository.CustomerRepository;
import com.bankmanage.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {
	@Autowired
	private CustomerRepository repository;
	
	

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

	

}

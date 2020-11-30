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

import com.bankmanage.api.CustomerController;
import com.bankmanage.api.EmployeeController;
import com.bankmanage.assembler.CustomerModelAssembler;
import com.bankmanage.assembler.EmployeeModelAssembler;
import com.bankmanage.exception.ResourceNotFoundException;
import com.bankmanage.model.Customer;
import com.bankmanage.model.Employee;
import com.bankmanage.repository.CustomerRepository;
import com.bankmanage.repository.EmployeeRepository;
import com.bankmanage.service.CustomerService;
import com.bankmanage.service.EmployeeService;

@Service
public class CustomerServiceImpl implements CustomerService {
	@Autowired
	private CustomerRepository repository;
	
	@Autowired
	private CustomerModelAssembler assembler;
	

	@Override
	public ResponseEntity<EntityModel<Customer>> createCustomer(Customer customer) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EntityModel<Customer> updateCustomer(Long id, Customer customer) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<String> deleteCustomer(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CollectionModel<EntityModel<Customer>> getAllCustomer() {
		// TODO Auto-generated method stub
		List<EntityModel<Customer>> customers = repository.findAll().stream().map(assembler::toModel).collect(toList());
		return CollectionModel.of(customers, linkTo(methodOn(CustomerController.class).getAll()).withSelfRel());
	}

	@Override
	public EntityModel<Customer> getCustomerById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	

}

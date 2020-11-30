package com.bankmanage.assembler;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import com.bankmanage.api.CustomerController;
import com.bankmanage.model.Customer;

@Component
public class CustomerModelAssembler implements RepresentationModelAssembler<Customer, EntityModel<Customer>> {

	@Override
	public EntityModel<Customer> toModel(Customer customer)  {
		return EntityModel.of(customer,
		        linkTo(methodOn(CustomerController.class).getCustomer(customer.getId())).withSelfRel(),
		        linkTo(methodOn(CustomerController.class).getAll()).withRel("customers"));
	}
}

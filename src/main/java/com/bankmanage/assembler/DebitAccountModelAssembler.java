package com.bankmanage.assembler;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import com.bankmanage.api.DebitAccountController;
import com.bankmanage.api.EmployeeController;
import com.bankmanage.model.DebitAccount;
import com.bankmanage.model.Employee;

@Component
public class DebitAccountModelAssembler  implements RepresentationModelAssembler<DebitAccount, EntityModel<DebitAccount>> {

	@Override
	public EntityModel<DebitAccount> toModel(DebitAccount entity) {
		// TODO Auto-generated method stub
		return EntityModel.of(entity,
		        linkTo(methodOn(DebitAccountController.class).getDebit(entity.getId())).withSelfRel(),
		        linkTo(methodOn(DebitAccountController.class).getAll()).withRel("account/debit"));
	}
 
}

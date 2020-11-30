package com.bankmanage.assembler;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import com.bankmanage.api.CreditAccountController;
import com.bankmanage.api.DebitAccountController;
import com.bankmanage.model.CreditAccount;

@Component
public class CreditAccountModelAssembler  implements RepresentationModelAssembler<CreditAccount, EntityModel<CreditAccount>> {

	@Override
	public EntityModel<CreditAccount> toModel(CreditAccount entity) {
		// TODO Auto-generated method stub
		return EntityModel.of(entity,
		        linkTo(methodOn(CreditAccountController.class).getCredit(entity.getId())).withSelfRel(),
		        linkTo(methodOn(CreditAccountController.class).getAll()).withRel("credit/accounts"));
	}
 
}

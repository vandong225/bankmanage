package com.bankmanage.assembler;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import com.bankmanage.api.EmployeeController;
import com.bankmanage.model.Employee;

@Component
public class EmployeeModelAssembler implements RepresentationModelAssembler<Employee, EntityModel<Employee>> {

	@Override
	public EntityModel<Employee> toModel(Employee employee)  {
		return EntityModel.of(employee,
		        linkTo(methodOn(EmployeeController.class).getEmployee(employee.getId())).withSelfRel(),
		        linkTo(methodOn(EmployeeController.class).getAll()).withRel("employees"));
	}

}

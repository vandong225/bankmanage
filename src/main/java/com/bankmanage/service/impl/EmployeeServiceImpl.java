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

import com.bankmanage.api.EmployeeController;
import com.bankmanage.assembler.EmployeeModelAssembler;
import com.bankmanage.exception.ResourceNotFoundException;
import com.bankmanage.model.Employee;
import com.bankmanage.repository.EmployeeRepository;
import com.bankmanage.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository repository;
	
	@Autowired
	private EmployeeModelAssembler assembler;
	
	@Override
	public ResponseEntity<EntityModel<Employee>> createEmployee(Employee newEmployee) {
		// TODO Auto-generated method stub
		EntityModel<Employee> entityModel = assembler.toModel(repository.save(newEmployee));
		return ResponseEntity //
			      .created(entityModel.getRequiredLink(IanaLinkRelations.SELF).toUri()) //
			      .body(entityModel);
	}

	@Override
	public EntityModel<Employee> updateEmployee(Long id, Employee newEmployee) {
		// TODO Auto-generated method stub

		 Employee employeePut = repository.findById(id)
	      .map(employee -> {
	        employee.setFullName(newEmployee.getFullName());
	        employee.setAddress(newEmployee.getAddress());
	        employee.setIdCard(newEmployee.getIdCard());
	        employee.setDob(newEmployee.getDob());
	        employee.setLevel(newEmployee.getLevel());
	        employee.setYear(newEmployee.getYear());
	        employee.setPosition(newEmployee.getPosition());
	        return repository.save(employee);
	      })
	      .orElseThrow(() -> new ResourceNotFoundException("not found employee "+ id));
		 System.out.println(employeePut);
		 return assembler.toModel(employeePut);
	}

	@Override
	public ResponseEntity<String> deleteEmployee(Long id) {
		// TODO Auto-generated method stub
		 repository.deleteById(id);
		 return new ResponseEntity<String>("Delete employee "+id, HttpStatus.OK);
	}


	@Override
	public CollectionModel<EntityModel<Employee>> getAllEmployee() {
		// TODO Auto-generated method stub
		List<EntityModel<Employee>> employees = repository.findAll().stream() //
				.map(assembler::toModel)
				.collect(toList());
		 return CollectionModel.of(employees, linkTo(methodOn(EmployeeController.class).getAll()).withSelfRel());
	}

	@Override
	public EntityModel<Employee> getEmployeeById(Long id) {
		// TODO Auto-generated method stub
		Employee employee = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("not found employee "+ id));
		return assembler.toModel(employee);
	}

}

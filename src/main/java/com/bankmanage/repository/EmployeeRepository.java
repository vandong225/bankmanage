package com.bankmanage.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bankmanage.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
	public Employee findByIdCard(String idCard);
}

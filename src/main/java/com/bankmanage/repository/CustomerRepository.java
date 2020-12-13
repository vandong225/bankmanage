package com.bankmanage.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bankmanage.model.Customer;
@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
	public Customer findByIdCard(String idCard);
}







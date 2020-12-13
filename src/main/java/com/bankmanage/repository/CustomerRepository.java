package com.bankmanage.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.bankmanage.model.CreditAccount;
import com.bankmanage.model.Customer;
import com.bankmanage.model.DebitAccount;
@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
	public Customer findByIdCard(String idCard);
	public List<Customer> findTop10ByOrderByDebits_BalanceDesc(); // findTop10ByOrderBy<ProperyName>_<Propery of nested Object>Desc
	
	@Query("SELECT c FROM Customer c JOIN c.debits cr GROUP BY c ORDER BY SUM(cr.balance) DESC")
	public List<Customer> getTop10();
}







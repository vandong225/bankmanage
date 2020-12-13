package com.bankmanage.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.bankmanage.model.CreditAccount;

@Repository
public interface CreditAccountRepository extends JpaRepository<CreditAccount, Long> {
       public List<CreditAccount> findAllByOrderByDebtDesc();
       @Query("SELECT c FROM CreditAccount c WHERE c.employee.id = ?3 AND c.createdAt between ?1 and ?2")
   	public List<CreditAccount> findAllByEmployeeByDate(Date fromDate, Date toDate, long id);
       
}

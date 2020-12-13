package com.bankmanage.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import com.bankmanage.model.DebitAccount;

@Repository
public interface DebitAccountRepository extends JpaRepository<DebitAccount, Long> {
    @Query("SELECT c FROM DebitAccount c WHERE c.createdAt between ?1 and ?2 AND c.employee.id = ?3")
	public List<DebitAccount> findAllByEmployeeByDate(Date fromDate, Date toDate, long id);
}

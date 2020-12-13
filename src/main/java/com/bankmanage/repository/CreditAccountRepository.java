package com.bankmanage.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bankmanage.model.CreditAccount;

@Repository
public interface CreditAccountRepository extends JpaRepository<CreditAccount, Long> {
       public List<CreditAccount> findAllByOrderByDebtDesc();
       
}

package com.bankmanage.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bankmanage.model.CreditAccount;

public interface CreditAccountRepository extends JpaRepository<CreditAccount, Long> {

}

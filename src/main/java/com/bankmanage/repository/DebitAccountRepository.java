package com.bankmanage.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bankmanage.model.DebitAccount;

@Repository
public interface DebitAccountRepository extends JpaRepository<DebitAccount, Long> {

}

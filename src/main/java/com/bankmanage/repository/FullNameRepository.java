package com.bankmanage.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bankmanage.model.FullName;

@Repository
public interface FullNameRepository extends JpaRepository<FullName, Long> {

}

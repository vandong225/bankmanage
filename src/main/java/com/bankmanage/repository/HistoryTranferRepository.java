package com.bankmanage.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.bankmanage.model.HistoryTranfer;
import com.bankmanger.dto.HistoryDTO;

public interface HistoryTranferRepository extends JpaRepository<HistoryTranfer, Long> {
	@Query("SELECT new com.bankmanger.dto.HistoryDTO(h.credit.customer.fullName,h.money) FROM HistoryTranfer h JOIN h.credit.customer WHERE h.time between ?1 and ?2")
	public List<HistoryDTO> findAllHistoryByDate(Date fromDate, Date toDate);
}

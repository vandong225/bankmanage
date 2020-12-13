package com.bankmanage.service;

import java.util.Date;
import java.util.List;

import com.bankmanger.dto.HistoryDTO;

public interface HistoryTranferService {
	public abstract List<HistoryDTO> getAllHistoryByDate(Date fromDate, Date toDate);
}

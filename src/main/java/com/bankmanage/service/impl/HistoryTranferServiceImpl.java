package com.bankmanage.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bankmanage.repository.HistoryTranferRepository;
import com.bankmanage.service.HistoryTranferService;
import com.bankmanger.dto.HistoryDTO;

@Service
public class HistoryTranferServiceImpl implements HistoryTranferService {
	
	@Autowired
	private HistoryTranferRepository historyRepo;
	
	
	@Override
	public List<HistoryDTO> getAllHistoryByDate(Date fromDate, Date toDate) {
		// TODO Auto-generated method stub
		List<HistoryDTO> listHistory = historyRepo.findAllHistoryByDate(fromDate, toDate);
		return listHistory;
	}

}

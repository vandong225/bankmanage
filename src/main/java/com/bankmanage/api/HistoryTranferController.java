package com.bankmanage.api;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.bankmanage.model.CreditAccount;
import com.bankmanage.service.CreditAccountService;
import com.bankmanage.service.HistoryTranferService;
import com.bankmanger.dto.HistoryDTO;

@RestController
@RequestMapping(path = "/api/v1/history", produces = "application/json")
@CrossOrigin(origins = "*")
public class HistoryTranferController {
	@Autowired
	private HistoryTranferService historyTranferService;
	
	@RequestMapping("/credit")
	@ResponseStatus(code = HttpStatus.OK)
 	public ResponseEntity<List<HistoryDTO>> getCredit(@RequestParam("fromDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date fromDate, @RequestParam("toDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date toDate) {
		return ResponseEntity.ok(historyTranferService.getAllHistoryByDate(fromDate, toDate));
	}
}

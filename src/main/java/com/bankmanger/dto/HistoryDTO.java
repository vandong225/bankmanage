package com.bankmanger.dto;

import com.bankmanage.model.FullName;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class HistoryDTO {
	private FullName fullName;
	private float moneyTranfer;
	
	
}

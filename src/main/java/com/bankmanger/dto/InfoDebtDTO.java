package com.bankmanger.dto;

import java.util.List;

import com.bankmanage.model.CreditAccount;
import com.bankmanage.model.Customer;
import com.bankmanage.model.FullName;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
public class InfoDebtDTO {
	CreditAccount credit;
	FullName customerName;
	Long customerId;
}

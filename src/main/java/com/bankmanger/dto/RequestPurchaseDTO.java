package com.bankmanger.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
public class RequestPurchaseDTO {
	private float money;
	private long idCredit;
	private long idDebit;
}

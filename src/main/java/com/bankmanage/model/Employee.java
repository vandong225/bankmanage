package com.bankmanage.model;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class Employee extends Person{
	private int level;
	private int year;
	private String position;
}

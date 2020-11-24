package com.bankmanage.model;

import javax.persistence.Column;
import javax.persistence.Entity;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
@Entity(name = "employee")
public class Employee extends Person{
	@Column
	private int level;
	@Column
	private int year;
	@Column
	private String position;
	
}

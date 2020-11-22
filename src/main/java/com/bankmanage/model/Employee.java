package com.bankmanage.model;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.PrePersist;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
@Entity(name = "employee")
@DiscriminatorValue("Employee")
public class Employee extends Person{
	@Column
	private int level;
	@Column
	private int year;
	@Column
	private String position;
	
}

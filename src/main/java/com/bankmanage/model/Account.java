package com.bankmanage.model;
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@NoArgsConstructor(force=true)
@MappedSuperclass
public abstract class Account extends Timestamp implements Serializable {
	@Id
    @GeneratedValue()
    @Column(name = "id", updatable = false, nullable = false)
	private Long id;
	private float startBalance;
   private float balance;
   @Enumerated(EnumType.STRING)
	private final TypeAccount type;
	public static enum TypeAccount {
		CREDIT, DEBIT
	}
	
	 @ManyToOne
	 @JsonBackReference
	 @JoinColumn(name="customer_id")
	 private Customer customer;
	 
	 @ManyToOne
	 @JsonBackReference
	 @JoinColumn(name="employee_id")
	 private Employee employee;

}

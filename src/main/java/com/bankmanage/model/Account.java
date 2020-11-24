package com.bankmanage.model;
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

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
	private Long idAcc;
   private float balance;
   @Enumerated(EnumType.STRING)
	private final TypeAccount type;
	public static enum TypeAccount {
		CREDIT, DEBIT
	}

}

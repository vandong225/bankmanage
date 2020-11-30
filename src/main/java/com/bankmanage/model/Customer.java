package com.bankmanage.model;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import lombok.*;

@Data
@NoArgsConstructor
@Entity

public class Customer extends Person{
	
	@OneToOne(targetEntity = CreditAccount.class, cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "id", referencedColumnName = "id" )
	protected CreditAccount credit;
	
	@OneToOne(targetEntity = DebitAccount.class, cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "id", referencedColumnName = "id" )
	protected CreditAccount debit;
}

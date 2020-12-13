package com.bankmanage.model;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.*;

@Data
@NoArgsConstructor
@Entity

public class Customer extends Person{
	
	@OneToMany(mappedBy="customer", cascade = CascadeType.ALL, targetEntity = CreditAccount.class)
	 @JsonManagedReference
	@EqualsAndHashCode.Exclude // không sử dụng trường này trong equals và hashcode
	@ToString.Exclude // Khoonhg sử dụng trong toString()
	protected Collection<CreditAccount> credits;
	
	@OneToMany(mappedBy="customer", cascade = CascadeType.ALL, targetEntity = DebitAccount.class)
	 @JsonManagedReference
	@EqualsAndHashCode.Exclude // không sử dụng trường này trong equals và hashcode
	@ToString.Exclude // Khoonhg sử dụng trong toString()
	protected Collection<DebitAccount> debits;
}

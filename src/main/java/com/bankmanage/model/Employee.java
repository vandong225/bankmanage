package com.bankmanage.model;

import java.util.Collection;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

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
	
//	@OneToMany(mappedBy="employee", cascade = CascadeType.ALL,  targetEntity = CreditAccount.class)
//	 @JsonManagedReference
//	@EqualsAndHashCode.Exclude // không sử dụng trường này trong equals và hashcode
//	@ToString.Exclude // Khoonhg sử dụng trong toString()
//	protected Collection<CreditAccount> credits;
//	
//	@OneToMany(mappedBy="employee", cascade = CascadeType.ALL, targetEntity = DebitAccount.class)
//	 @JsonManagedReference
//	@EqualsAndHashCode.Exclude // không sử dụng trường này trong equals và hashcode
//	@ToString.Exclude // Khoonhg sử dụng trong toString()
//	protected Collection<DebitAccount> debits;
}

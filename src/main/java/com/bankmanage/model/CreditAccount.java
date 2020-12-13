package com.bankmanage.model;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Data
@RequiredArgsConstructor
@Entity
public class CreditAccount extends Account{
   private float debt;
   
   @OneToMany(mappedBy="credit", cascade = CascadeType.ALL, targetEntity = HistoryTranfer.class)
	 @JsonManagedReference
	@EqualsAndHashCode.Exclude // không sử dụng trường này trong equals và hashcode
	@ToString.Exclude // Khoonhg sử dụng trong toString()
	protected Collection<HistoryTranfer> historyTranfers ;
//   @JoinColumn(name="customer_id")
//   private Customer customer;
}

package com.bankmanage.model;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@Entity
public class CreditAccount extends Account{
   private float debt;
  
//   @ManyToOne
//   @JoinColumn(name="customer_id")
//   private Customer customer;
}

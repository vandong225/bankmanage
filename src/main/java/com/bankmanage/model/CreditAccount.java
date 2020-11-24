package com.bankmanage.model;
import javax.persistence.Entity;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@Entity
public class CreditAccount extends Account{
   private float debt;
  
}

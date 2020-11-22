package com.bankmanage.model;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class Credit extends Account{
   private float debit;
  
}

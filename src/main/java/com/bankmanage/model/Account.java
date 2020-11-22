package com.bankmanage.model;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class Account {
   private int idAcc;
   private String type;
   private float balance;
}

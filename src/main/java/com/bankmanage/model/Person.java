package com.bankmanage.model;
import java.util.Date;
import lombok.Data;
import lombok.RequiredArgsConstructor;
@Data
@RequiredArgsConstructor
public class Person {
   private int id;
   private String idCard;
   private FullName fullName;
   private Date dob;
   private Address address;
}

package com.bankmanage.model;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class Address {
     private String no;
     private String district;
     private String city;
     private String street;
     private String country;
}

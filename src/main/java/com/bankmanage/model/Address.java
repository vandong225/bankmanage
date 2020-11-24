package com.bankmanage.model;
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@Entity(name = "address")
public class Address implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false)
	private long id;
     private String des;
     private String district;
     private String city;
     private String street;
     private String country;
//     
//     @OneToOne(mappedBy = "address", cascade = CascadeType.ALL)
//     @JsonManagedReference
//     private Employee employee;
}

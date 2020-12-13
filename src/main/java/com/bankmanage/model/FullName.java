package com.bankmanage.model;
import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
@Data
@RequiredArgsConstructor
@Entity(name = "fullname")
public class FullName implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
    private String firstName;
    private String midName;
    private String lastName;
//    
//    @OneToOne(mappedBy = "fullName", cascade = CascadeType.ALL)
//    @JsonManagedReference
//    private Employee employee;
    public String ToString() {
    	return firstName + " " +midName + " "+ lastName;
    }
}

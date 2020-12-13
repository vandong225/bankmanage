package com.bankmanage.model;
import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
@Data
@RequiredArgsConstructor
@Entity(name = "fullname")
@JsonInclude(value = Include.NON_DEFAULT)
@JsonIgnoreProperties(ignoreUnknown = true)
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

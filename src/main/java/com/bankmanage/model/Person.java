package com.bankmanage.model;
import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
//@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@MappedSuperclass
//@Entity
public abstract class Person extends Timestamp implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", updatable = false, nullable = false)
   protected long id;
	
	@Column
	protected String idCard;

	@Column
	@Temporal(TemporalType.DATE)
	protected Date dob;

	@OneToOne(targetEntity = FullName.class, cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "fullName_id", referencedColumnName = "id" )
	protected FullName fullName;
	
   @OneToOne(targetEntity = Address.class, cascade = CascadeType.ALL, orphanRemoval = true)
   @JoinColumn(name = "address_id", referencedColumnName = "id")
   protected Address address;
   
}

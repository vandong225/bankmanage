package com.bankmanage.model;
import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Person implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", updatable = false, nullable = false)
   private long id;
	@Column
   private String idCard;
	@JsonManagedReference
	@OneToOne(targetEntity = FullName.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "fullName_id", referencedColumnName = "id")
   private FullName fullName;
   @Column
   @Temporal(TemporalType.DATE)
   private Date dob;

   @JsonManagedReference
   @OneToOne(targetEntity = Address.class, cascade = CascadeType.ALL)
   @JoinColumn(name = "address_id", referencedColumnName = "id")
   private Address address;
   @Column
	private Date createdAt;
   @Column
   private Date updatedAt;
	@PrePersist
	   void createdAt() {
		   this.createdAt = new Date();
		} 
	@PreUpdate
	void updatedAt() {
		   this.updatedAt = new Date();
	} 
}

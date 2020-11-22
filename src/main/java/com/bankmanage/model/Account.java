package com.bankmanage.model;
import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class Account implements Serializable {
   private int idAcc;
   private String type;
   private float balance;
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

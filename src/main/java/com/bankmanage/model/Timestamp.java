package com.bankmanage.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class Timestamp {
	
	 @Column(nullable = false)
	   @CreationTimestamp
	   @Temporal(TemporalType.TIMESTAMP)
		protected Date createdAt;
	 
	   @Column(nullable = false)
	   @UpdateTimestamp
	   @Temporal(TemporalType.TIMESTAMP)
	   protected Date updatedAt;
//	   
//	   @PrePersist
//	   protected void onCreate() {
//		   this.createdAt = new Date();
//		   this.updatedAt = new Date();
//	   }
//	   
//	   @PreUpdate
//	   protected void onUpdate() {
//		   this.updatedAt = new Date();
//	   }
}

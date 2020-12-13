package com.bankmanage.model;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.*;

@Data
@RequiredArgsConstructor
@Entity
public class DebitAccount extends Account {
   private float rate;
   private float minBalance;
   private float startBalance;
//   @ManyToOne
//   @JoinColumn(name="customer_id")
//   private Customer customer;
}

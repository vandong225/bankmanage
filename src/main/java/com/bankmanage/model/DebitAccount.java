package com.bankmanage.model;
import javax.persistence.Entity;

import lombok.*;

@Data
@RequiredArgsConstructor
@Entity
public class DebitAccount extends Account {
   private float rate;
   private float minBalance;
   
}

package com.reward.RewardBackEnd.model;

import java.time.LocalDateTime;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name="Transaction")
public class Transaction {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int trId;
    private LocalDateTime trTime;
    @OneToOne
    private Reward reward;
    private int amount;
	@ManyToOne
    @JoinColumn(name = "relationId")
    private StoreCustomerRelation storeCustomerRelation;
    @ManyToOne
    @JoinColumn(name = "merchantId")
    private Merchant merchant;
}

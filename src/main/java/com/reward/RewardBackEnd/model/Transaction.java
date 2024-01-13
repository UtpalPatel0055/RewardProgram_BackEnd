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
@Table(name="transaction")
public class Transaction {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tr_id")
	private int trId;

    @Column(name = "tr_time")
    private LocalDateTime trTime;

    @OneToOne
    private Reward reward;

    @Column(name = "amount")
    private int amount;

	@ManyToOne
    @JoinColumn(name = "relationId")
    private StoreCustomerRelation storeCustomerRelation;

    @ManyToOne
    @JoinColumn(name = "merchantId")
    private Merchant merchant;
}

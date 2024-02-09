package com.reward.RewardBackEnd.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor

@Entity
@Table(name="transaction")
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
    @JoinColumn(name = "userId")
    private User user;
}

package com.reward.RewardBackEnd.model;

import java.time.LocalDateTime;

import jakarta.persistence.*;
import lombok.*;

@Data
@NoArgsConstructor

@Entity
@Table(name="transaction")
public class Transaction {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer trId;

    private LocalDateTime trTime;

    @OneToOne
    private Reward reward;

    private Integer amount;

	@ManyToOne
    @JoinColumn(name = "relationId")
    private StoreCustomerRelation storeCustomerRelation;

    @ManyToOne
    @JoinColumn(name = "merchantId")
    private Merchant merchant;
}

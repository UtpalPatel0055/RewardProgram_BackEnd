package com.reward.RewardBackEnd.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Data
@NoArgsConstructor

@Entity
@Table(name="rewards")
public class Reward {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int rewardId;

    private String rewardName;

    private String rewardType;

    private int rewardTarget;

    @ManyToOne
    @JoinColumn(name = "storeId")
    private Store store;

    @ManyToOne
    @JoinColumn(name = "merchantId")
    private Merchant merchant;

    @Column(name = "created_on")
    private LocalDate createdOn;

}

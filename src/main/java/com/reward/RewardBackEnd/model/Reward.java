package com.reward.RewardBackEnd.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name="Rewards")
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

    private LocalDate createdOn;

}

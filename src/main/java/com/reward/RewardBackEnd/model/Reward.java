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
@Table(name="rewards")
public class Reward {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "reward_id")
	private int rewardId;

    @Column(name = "reward_name")
    private String rewardName;

    @Column(name = "reward_type")
    private String rewardType;

    @Column(name = "reward_target")
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

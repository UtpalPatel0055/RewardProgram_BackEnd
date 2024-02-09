package com.reward.RewardBackEnd.model;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.persistence.Table;

@Data
@NoArgsConstructor
@Entity
@Table(name = "merchant")
public class Merchant extends User{

	private String jobTitle;

	@ManyToOne
	@JoinColumn(name = "storeId")
	private Store store;

}

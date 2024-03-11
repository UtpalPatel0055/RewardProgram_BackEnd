package com.reward.RewardBackEnd.model;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
@Table(name="customer")
public class Customer extends User {

	private int currPoints;		//This is for Current points
	private String custBroadCastChoice;
	private int totalSpent;
	private LocalDateTime lastPurchase;
	private String status;
	@OneToMany(mappedBy = "user")
	private List<StoreCustomerRelation> storeCustomerRelation;


}

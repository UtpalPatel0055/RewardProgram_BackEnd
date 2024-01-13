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
@Table(name="StoreCustomerRelation")
public class StoreCustomerRelation {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int relationId;

	@ManyToOne
	@JoinColumn(name = "storeId")
	private Store store;

	@ManyToOne
	@JoinColumn(name = "customerId")
	private Customer customer;
	
	private LocalDate joinDate;
}

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
@Table(name="store_customer_relation")
public class StoreCustomerRelation {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "relation_id")
	private int relationId;

	@ManyToOne
	@JoinColumn(name = "storeId")
	private Store store;

	@ManyToOne
	@JoinColumn(name = "custId")
	private Customer customer;

	@Column(name = "join_date")
	private LocalDate joinDate;
}

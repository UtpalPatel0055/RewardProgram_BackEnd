package com.reward.RewardBackEnd.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@Entity
@Table(name="store_customer_relation")
public class StoreCustomerRelation {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int relationId;

	@ManyToOne
	@JoinColumn(name = "storeId")
	private Store store;

	@ManyToOne
	@JoinColumn(name = "userId")
	private User user;

	@Column(name = "join_date")
	private LocalDate joinDate;
}

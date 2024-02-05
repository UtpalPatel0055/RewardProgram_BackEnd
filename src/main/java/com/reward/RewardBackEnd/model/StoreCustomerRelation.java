package com.reward.RewardBackEnd.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor

@Entity
@Table(name="store_customer_relation")
public class StoreCustomerRelation {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer relationId;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "storeId")
	private Store store;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "customerId")
	private Customer customer;

	@Column(name = "join_date")
	private LocalDateTime joinDate;
}

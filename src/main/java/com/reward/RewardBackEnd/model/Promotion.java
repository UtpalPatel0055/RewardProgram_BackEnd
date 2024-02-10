package com.reward.RewardBackEnd.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@Entity
@Table(name="promotion")
public class Promotion {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int promoId;

	private String promoName;

	private String promoDescription;

	private LocalDate createdOn;

	private LocalDate expiresOn;


	@ManyToOne
	@JoinColumn(name = "storeId")
	private Store store;
	
	@ManyToOne
	@JoinColumn(name = "userId")
	private User user;
}

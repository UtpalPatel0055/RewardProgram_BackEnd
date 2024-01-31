package com.reward.RewardBackEnd.model;

import java.time.LocalDate;
import java.util.Date;

import jakarta.persistence.*;
import lombok.*;

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
	@JoinColumn(name = "merchantId")
	private Merchant merchant;
}

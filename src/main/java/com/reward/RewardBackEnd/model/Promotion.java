package com.reward.RewardBackEnd.model;

import java.time.LocalDate;
import java.util.Date;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name="promotion")
public class Promotion {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "promo_id")
	private int promoId;

	@Column(name = "promo_name")
	private String promoName;

	@Column(name = "promo_description")
	private String promoDescription;

	@Column(name = "create_on")
	private LocalDate createdOn;

	@Column(name = "expires_on")
	private LocalDate expiresOn;


	@ManyToOne
	@JoinColumn(name = "storeId")
	private Store store;
	
	@ManyToOne
	@JoinColumn(name = "merchantId")
	private Merchant merchant;
}

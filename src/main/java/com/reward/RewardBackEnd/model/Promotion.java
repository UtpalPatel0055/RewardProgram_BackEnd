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
@Table(name="Promotion")
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

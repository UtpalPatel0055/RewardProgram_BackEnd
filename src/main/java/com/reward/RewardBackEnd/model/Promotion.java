package com.reward.RewardBackEnd.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
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
	private Integer promoId;

	private String promoName;

	private String promoDescription;

	private LocalDateTime createdOn;

	private LocalDateTime expiresOn;

	@ManyToOne
	@JoinColumn(name = "storeId")
	private Store store;
	
	@ManyToOne
	@JoinColumn(name = "merchantId")
	private Merchant merchant;
}

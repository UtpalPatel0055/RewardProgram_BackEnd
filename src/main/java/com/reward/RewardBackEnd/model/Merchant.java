package com.reward.RewardBackEnd.model;

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
@Table(name="merchant")
public class Merchant {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "merchant_id")
	private int merchantId;

	@Column(name = "first_name")
	private String firstName;

	@Column(name = "last_name")
	private String lastName;

	
	@Column(name = "merchant_phone", unique = true)
    private String merchantPhone;
	
	@Column(name = "merchant_email", unique = true)
    private String merchantEmail;
    
    @Column(name = "username", unique = true)
    private String username;

	@Column(name = "password")
    private String password;

	@Column(name = "job_title")
	private String jobTitle;

	@ManyToOne
	@JoinColumn(name = "storeId")
	private Store store;

	
}

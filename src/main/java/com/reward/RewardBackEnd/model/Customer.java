package com.reward.RewardBackEnd.model;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor

@Entity
public class Customer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int custId;
	private String custFirstName;
	private String custLastName;
	
	@Column(unique = true)
	private String custEmail;
	
	@Column(unique = true)
	private String custPhone;
	
	private int points;
	private String custBroadCastChoice;
	private int totalSpent;
	private Date joinDate;
	private Date lastPurchase;
	private String status;
	
	@Column(unique = true)
	private String username;
    private String password;
	
	
}

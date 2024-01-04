package com.reward.RewardBackEnd.model;

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
public class Merchant {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int merchantId;
	private String firstName;
	private String lastName;
	
	@Column(unique = true)
    private String merchantPhone;
	
	@Column(unique = true)
    private String merchantEmail;
    
    @Column(unique = true)
    private String username;
    private String password;
    private int storeId;

	
}

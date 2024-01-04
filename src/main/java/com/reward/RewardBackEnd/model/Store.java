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
public class Store {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int storeId;
	private String busName;
	private String busType;
	
	@Column(unique = true)
	private String busEmail;
	
	@Column(unique = true)
	private String busPhone;
	private String website;
	private String address1;
	private String address2;
	private int postcode;
	private String city;
	private String state;
	private String country;
	private Date joinDate;
	
	
}

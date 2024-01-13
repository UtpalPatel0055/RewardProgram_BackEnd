package com.reward.RewardBackEnd.model;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

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
@Table(name="Customer")
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
	@Column(name="points")
	private int currPoints;		//This is for Current points
	private String custBroadCastChoice;
	private int totalSpent;
	private LocalDate joinDate;
	private LocalDate lastPurchase;
	private String status;
	@Column(unique = true)
	private String username;
    private String password;
	@OneToMany(mappedBy = "Customer")
	private List<StoreCustomerRelation> storeCustomerRelation;
	
}

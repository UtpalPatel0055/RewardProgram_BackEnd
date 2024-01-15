package com.reward.RewardBackEnd.model;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import jakarta.persistence.*;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name="customer")
public class Customer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cust_id")
	private int custId;

	@Column(name = "cust_first_name")
	private String custFirstName;

	@Column(name = "cust_last_name")
	private String custLastName;

	@Column(name = "cust_email", unique = true)
	private String custEmail;

	@Column(name = "cust_phone", unique = true)
	private String custPhone;

	@Column(name="points")
	private int currPoints;		//This is for Current points

	@Column(name = "cust_broad_cast_choice")
	private String custBroadCastChoice;

	@Column(name = "total_spent")
	private int totalSpent;

	@Column(name = "join_date")
	private LocalDate joinDate;

	@Column(name = "last_purchase")
	private LocalDate lastPurchase;

	@Column(name = "status")
	private String status;

	@Column(name = "username", unique = true)
	private String username;

	@Column(name = "password")
    private String password;

	@OneToMany(mappedBy = "customer")
	private List<StoreCustomerRelation> storeCustomerRelation;

}

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
@Table(name="Merchant")
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

	private String jobTitle;
	@ManyToOne
	@JoinColumn(name = "storeId")
	private Store store;

	
}

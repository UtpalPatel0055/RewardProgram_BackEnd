package com.reward.RewardBackEnd.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
@Table(name="store")
public class Store {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int storeId;

	private String busName;

	private String busType;

	private String busEmail;

	private String busPhone;

	private String website;

	private String address1;

	private String address2;

	private int postcode;

	private String city;

	private String state;

	private String country;

	private LocalDateTime joinDate;

	@OneToMany(mappedBy = "store")
	private List<StoreCustomerRelation> storeCustomerRelation;
	
}
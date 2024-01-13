package com.reward.RewardBackEnd.model;

import java.time.LocalDate;
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
@Table(name="store")
public class Store {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "store_id")
	private int storeId;

	@Column(name = "bus_name")
	private String busName;

	@Column(name = "bus_type")
	private String busType;
	
	@Column(name = "bus_email", unique = true)
	private String busEmail;
	
	@Column(name = "bus_phone", unique = true)
	private String busPhone;

	@Column(name = "website")
	private String website;

	@Column(name = "address1")
	private String address1;

	@Column(name = "address2")
	private String address2;

	@Column(name = "postcode")
	private int postcode;

	@Column(name = "city")
	private String city;

	@Column(name = "state")
	private String state;

	@Column(name = "country")
	private String country;

	@Column(name = "join_date")
	private LocalDate joinDate;

	@OneToMany(mappedBy = "store")
	private List<StoreCustomerRelation> storeCustomerRelation;
	
}
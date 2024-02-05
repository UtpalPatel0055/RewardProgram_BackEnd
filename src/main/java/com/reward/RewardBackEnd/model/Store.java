package com.reward.RewardBackEnd.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.*;
import lombok.*;

@Data
@NoArgsConstructor

@Entity
@Table(name="store")
public class Store {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer storeId;

	private String busName;

	private String busType;

	private String busEmail;

	private String busPhone;

	private String website;

	private String address1;

	private String address2;

	private Integer postcode;

	private String city;

	private String state;

	private String country;

	private LocalDateTime joinDate;

	@OneToMany(mappedBy = "store", fetch = FetchType.EAGER)
	private List<StoreCustomerRelation> storeCustomerRelation;
	
}
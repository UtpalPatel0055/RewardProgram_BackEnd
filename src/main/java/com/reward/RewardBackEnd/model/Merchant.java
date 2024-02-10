package com.reward.RewardBackEnd.model;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "Merchant")
public class Merchant implements UserDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer merchantId;

	private String merchantFirstName;

	private String merchantLastName;

	private String merchantEmail;

	private String password;

	private String merchantPhone;

	private LocalDateTime joinDate;

	@Enumerated(EnumType.STRING)
	private Role role;

	private String jobTitle;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "storeId")
	private Store store;

	public Merchant() {

	}

	public Merchant(Merchant merchant) {
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return List.of(new SimpleGrantedAuthority(role.name()));
	}


	@Override
	public String getUsername() {
		return this.merchantEmail;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

	//Getter and Setter
	public Integer getMerchantId() {
		return merchantId;
	}
//	public void setMerchantId(Integer merchantId) {
//		this.merchantId = merchantId;
//	}

	public String getMerchantFirstName() {
		return merchantFirstName;
	}
	public void setMerchantFirstName(String merchantFirstName) {
		this.merchantFirstName = merchantFirstName;
	}

	public String getMerchantLastName() {
		return merchantLastName;
	}
	public void setMerchantLastName(String merchantLastName) {
		this.merchantLastName = merchantLastName;
	}

	public String getMerchantEmail() {
		return merchantEmail;
	}
	public void setMerchantEmail(String merchantEmail) {
		this.merchantEmail = merchantEmail;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String getPassword() {
		return this.password;
	}

	public String getMerchantPhone() {
		return merchantPhone;
	}
	public void setMerchantPhone(String merchantPhone) {
		this.merchantPhone = merchantPhone;
	}

	public LocalDateTime getJoinDate() {
		return joinDate;
	}
	public void setJoinDate(LocalDateTime joinDate) {
		this.joinDate = joinDate;
	}

	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}

	public String getJobTitle() {
		return jobTitle;
	}
	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}

	public Store getStore() {
		return store;
	}
	public void setStore(Store store) {
		this.store = store;
	}
}

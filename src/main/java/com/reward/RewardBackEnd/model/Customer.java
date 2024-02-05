package com.reward.RewardBackEnd.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "Customer")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Customer implements UserDetails{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer custId;

	private String custFirstName;

	private String custLastName;

	private String custEmail;

	private String password;

	private String custPhone;

	private LocalDateTime joinDate;

	@Enumerated(EnumType.STRING)
	private Role role;

	private Integer currPoints;		//This is for Current points

	private String custBroadCastChoice;

	private Integer totalSpent;

	private LocalDateTime lastPurchase;

	private String status;

	@OneToMany(mappedBy = "customer", fetch = FetchType.EAGER)
	private List<StoreCustomerRelation> storeCustomerRelation;

	public Customer(Customer customer) {
	}


	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return List.of(new SimpleGrantedAuthority(role.name()));
	}

	@Override
	public String getPassword() {
		return this.password;
	}

	@Override
	public String getUsername() {
		return this.custEmail;
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
}

package com.reward.RewardBackEnd.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;

@Data
@NoArgsConstructor

@Entity
@Table(name="customer")
public class Customer implements UserDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int custId;
	private String custFirstName;
	private String custLastName;
	private String custEmail;
	private String custPhone;
	private int currPoints;		//This is for Current points
	private String custBroadCastChoice;
	private int totalSpent;
	private LocalDateTime joinDate;
	private LocalDateTime lastPurchase;
	private String status;
    private String password;
	@OneToMany(mappedBy = "customer")
	private List<StoreCustomerRelation> storeCustomerRelation;
	@Enumerated(EnumType.STRING)
	private Role role;

	// METHODS FOR PROVIDING SECURITY
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return List.of(new SimpleGrantedAuthority(role.name()));
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
	//END OF SECURITY METHODS

}

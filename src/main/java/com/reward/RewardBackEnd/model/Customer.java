package com.reward.RewardBackEnd.model;

import java.time.LocalDate;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

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

	private LocalDate joinDate;

	private LocalDate lastPurchase;

	private String status;

//	private String username;

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

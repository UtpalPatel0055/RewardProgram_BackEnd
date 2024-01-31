package com.reward.RewardBackEnd.model;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Data
@NoArgsConstructor

@Entity
@Table(name="merchant")
public class Merchant implements UserDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int merchantId;

	private String firstName;

	private String lastName;

    private String merchantPhone;

    private String merchantEmail;

    private String password;

	private String jobTitle;

	@ManyToOne
	@JoinColumn(name = "storeId")
	private Store store;

	@Enumerated(EnumType.STRING)
	private Role role;

	// METHODS FOR PROVIDING SECURITY
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
	//END OF SECURITY METHODS
}

package com.reward.RewardBackEnd.model;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
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

	public Merchant(Merchant merchant) {
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
}

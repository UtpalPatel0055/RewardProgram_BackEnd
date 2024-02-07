package com.reward.RewardBackEnd.service;

import com.reward.RewardBackEnd.model.AuthenticationResponse;
import com.reward.RewardBackEnd.model.Customer;
import com.reward.RewardBackEnd.model.Merchant;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.Optional;

public interface MerchantService extends UserDetailsService {

    Optional<Merchant> findByUserId(int id);

    AuthenticationResponse register(Merchant merchant);

    AuthenticationResponse authenticate(Merchant merchant);

    public UserDetails loadUserByUsername(String username);
}

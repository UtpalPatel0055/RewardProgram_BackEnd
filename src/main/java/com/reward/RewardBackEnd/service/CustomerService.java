package com.reward.RewardBackEnd.service;

import com.reward.RewardBackEnd.model.AuthenticationResponse;
import com.reward.RewardBackEnd.model.Customer;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.Optional;

public interface CustomerService extends UserDetailsService {

    Optional<Customer> findByUserId(int id);

    AuthenticationResponse register(Customer c);

    AuthenticationResponse authenticate(Customer c);

    public UserDetails loadUserByUsername(String username);
}

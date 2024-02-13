package com.reward.RewardBackEnd.service.impl;

import com.reward.RewardBackEnd.model.Customer;
import com.reward.RewardBackEnd.model.Role;
import com.reward.RewardBackEnd.repository.CustomerRepository;
import com.reward.RewardBackEnd.service.CustomerService;
import com.reward.RewardBackEnd.service.securityServices.TokenService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private final TokenService tokenService;

    private final CustomerRepository customerRepository;

    private final PasswordEncoder passwordEncoder;

    @Override
    public Customer saveCustomer(Customer customer) {
        customer.setPassword(passwordEncoder.encode(customer.getPassword()));
        customer.setRole(Role.ROLE_CUSTOMER);
        customer.setJoinDate(LocalDateTime.now());

        customerRepository.save(customer);
        return null;
    }
}

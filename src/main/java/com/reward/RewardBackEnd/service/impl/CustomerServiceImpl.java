package com.reward.RewardBackEnd.service.impl;

import com.reward.RewardBackEnd.controller.AuthController;
import com.reward.RewardBackEnd.model.Customer;
import com.reward.RewardBackEnd.model.Role;
import com.reward.RewardBackEnd.repository.CustomerRepository;
import com.reward.RewardBackEnd.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository repository;

    private final PasswordEncoder encoder;

    private static final Logger LOG = LoggerFactory.getLogger(AuthController.class);

    @Override
    public Optional<Customer> findByUserId(int id) {
        Optional<Customer> customer = repository.findById(id);
        return customer;
    }

    @Override
    public Customer register(Customer customer) {
        LOG.info(" === Inside Customer Service === ");
        LOG.info(" === Customer : === " + customer.getCustEmail() + " and " + customer.getPassword());
        LOG.info(" === ======================= === ");
        customer.setPassword(encoder.encode(customer.getPassword()));
//        c.setRole(Role.ROLE_CUSTOMER);
        return repository.save(customer);
    }
}

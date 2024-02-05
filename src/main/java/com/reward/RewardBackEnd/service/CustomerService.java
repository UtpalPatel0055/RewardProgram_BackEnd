package com.reward.RewardBackEnd.service;

import com.reward.RewardBackEnd.model.Customer;

import java.util.Optional;

public interface CustomerService {

    Optional<Customer> findByUserId(int id);

    Customer register(Customer c);
}

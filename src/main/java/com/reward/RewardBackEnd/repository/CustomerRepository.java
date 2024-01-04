package com.reward.RewardBackEnd.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.reward.RewardBackEnd.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {

}

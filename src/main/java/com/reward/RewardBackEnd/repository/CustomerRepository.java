package com.reward.RewardBackEnd.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.reward.RewardBackEnd.model.Customer;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {

}

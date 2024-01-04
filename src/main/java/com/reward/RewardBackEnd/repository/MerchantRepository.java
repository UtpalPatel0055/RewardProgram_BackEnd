package com.reward.RewardBackEnd.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.reward.RewardBackEnd.model.Merchant;

public interface MerchantRepository extends JpaRepository<Merchant, Integer> {

}

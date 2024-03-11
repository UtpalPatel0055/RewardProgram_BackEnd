package com.reward.RewardBackEnd.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.reward.RewardBackEnd.model.Merchant;
import org.springframework.stereotype.Repository;

@Repository
public interface MerchantRepository extends JpaRepository<Merchant, Integer> {

}

package com.reward.RewardBackEnd.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

import com.reward.RewardBackEnd.model.Merchant;

public interface MerchantRepository extends JpaRepository<Merchant, Integer> {

    Optional<Merchant> findByMerchantEmail(String username);
}

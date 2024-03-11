package com.reward.RewardBackEnd.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.reward.RewardBackEnd.model.Promotion;
import org.springframework.stereotype.Repository;

@Repository
public interface PromotionRepository extends JpaRepository<Promotion, Integer> {

}

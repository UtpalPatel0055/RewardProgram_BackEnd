package com.reward.RewardBackEnd.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.reward.RewardBackEnd.model.Reward;

public interface RewardRepository extends JpaRepository<Reward, Integer> {

}

package com.reward.RewardBackEnd.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.reward.RewardBackEnd.model.Reward;
import org.springframework.stereotype.Repository;

@Repository
public interface RewardRepository extends JpaRepository<Reward, Integer> {

}

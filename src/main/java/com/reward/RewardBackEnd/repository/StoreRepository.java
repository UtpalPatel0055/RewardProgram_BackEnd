package com.reward.RewardBackEnd.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.reward.RewardBackEnd.model.Store;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StoreRepository extends JpaRepository<Store, Integer> {

    Optional<Store> findByBusEmail(String email);

    Optional<Store> findByBusPhone(String phone);
}

package com.reward.RewardBackEnd.repository;

import com.reward.RewardBackEnd.model.StoreCustomerRelation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StoreCustomerRelationRepository
        extends JpaRepository<StoreCustomerRelation, Integer> {

}

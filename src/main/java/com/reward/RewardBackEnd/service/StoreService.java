package com.reward.RewardBackEnd.service;

import com.reward.RewardBackEnd.model.Store;
import org.springframework.stereotype.Service;

import java.util.Optional;

public interface StoreService {

    Store saveStore(Store store);

    Optional<Store> findByStoreId(int storeId);
}

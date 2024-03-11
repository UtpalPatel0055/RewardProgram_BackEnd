package com.reward.RewardBackEnd.service.impl;

import com.reward.RewardBackEnd.exception.DuplicateRecordFoundException;
import com.reward.RewardBackEnd.model.Store;
import com.reward.RewardBackEnd.repository.StoreRepository;
import com.reward.RewardBackEnd.service.StoreService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class StoreServiceImpl implements StoreService {

    private final Logger LOG = LoggerFactory.getLogger(StoreServiceImpl.class);

    @Autowired
    private StoreRepository storeRepository;

    @Override
    public Optional<Store> findByStoreId(int storeId) {
        return storeRepository.findById(storeId);
    }

    @Override
    public Store saveStore(Store store) {
        boolean flag = validateStoreBeforeSaving(store.getBusEmail(), store.getBusPhone());
        LOG.info("=== Inside Store Service ===");
        LOG.info("Flag: " + flag);
        LOG.info("Store details : " + store.toString());
        if(flag) {
            store.setJoinDate(LocalDateTime.now());
            store = storeRepository.save(store);
        } else {
            LOG.info("StoreService EXCEPTION:::");
            throw new DuplicateRecordFoundException("The store already exists.");
        }
        return store;
    }

    public boolean validateStoreBeforeSaving(String email, String phone) {
        Optional<Store> store1 = storeRepository.findByBusEmail(email);
        Optional<Store> store2 = storeRepository.findByBusPhone(phone);

        if(store1.isPresent() || store2.isPresent())
            return false;
        return true;
    }
}

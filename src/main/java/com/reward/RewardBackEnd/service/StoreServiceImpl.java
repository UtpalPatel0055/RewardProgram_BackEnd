package com.reward.RewardBackEnd.service;

import com.reward.RewardBackEnd.model.Store;
import com.reward.RewardBackEnd.exception.save.DuplicateStoreException;
import com.reward.RewardBackEnd.repository.StoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StoreServiceImpl implements StoreService {

    @Autowired
    private StoreRepository storeRepository;

    @Override
    public Store saveStore(Store store) {
        boolean flag = validateStoreBeforeSaving(store.getBusEmail(), store.getBusPhone());
        if(flag) {
            storeRepository.save(store);
        } else {
            throw new DuplicateStoreException("The store already exists.");
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

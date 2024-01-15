package com.reward.RewardBackEnd.controller;

import com.reward.RewardBackEnd.exception.APIErrorDetail;
import com.reward.RewardBackEnd.exception.APIExceptionHandler;
import com.reward.RewardBackEnd.exception.save.DuplicateRecordFoundException;
import com.reward.RewardBackEnd.model.Store;
import com.reward.RewardBackEnd.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/api/v1/")
public class StoreController {

    @Autowired
    private StoreService storeService;

    @PostMapping("/create-store-profile")
	public ResponseEntity<Store> createNewStore(@RequestBody Store store) {
        try {
            Store createdStore = storeService.saveStore(store);
            return new ResponseEntity<Store>(createdStore, HttpStatus.CREATED);
        } catch {
            
        }


    }
}

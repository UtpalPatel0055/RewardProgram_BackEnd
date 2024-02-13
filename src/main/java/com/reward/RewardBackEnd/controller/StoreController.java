package com.reward.RewardBackEnd.controller;

import com.reward.RewardBackEnd.model.Store;
import com.reward.RewardBackEnd.service.StoreService;
import com.reward.RewardBackEnd.service.impl.StoreServiceImpl;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/auth/stores")
@CrossOrigin(origins = "http://localhost:5173")
@RequiredArgsConstructor
public class StoreController {

    private final StoreService storeService;

    private final Logger LOG = LoggerFactory.getLogger(StoreController.class);



}
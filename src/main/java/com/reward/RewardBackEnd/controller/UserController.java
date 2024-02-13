package com.reward.RewardBackEnd.controller;

import com.reward.RewardBackEnd.model.*;
import com.reward.RewardBackEnd.service.CustomerService;
import com.reward.RewardBackEnd.service.MerchantService;
import com.reward.RewardBackEnd.service.StoreService;
import com.reward.RewardBackEnd.service.securityServices.TokenService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserController {

    private static final Logger LOG = LoggerFactory.getLogger(UserController.class);

    private final TokenService tokenService;

    private final CustomerService customerService;

    private final MerchantService merchantService;

    private final StoreService storeService;

    private final AuthenticationManager authenticationManager;

    @GetMapping("/")
    public String home() {
        return "Hello, Papa";
    }

    @PostMapping("/token")
    public String login(@RequestBody User user) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        user.getEmail(), user.getPassword()
                )
        );
        LOG.info("ROLE: " + authentication.getAuthorities());
        String token = tokenService.generateToken(authentication);
        LOG.info("Token Generated " + token);
        return token;
    }

    // Customer
    @PostMapping("/api/v1/customer/sign-up")
    public ResponseEntity<AuthenticationResponse> custSignUp(@RequestBody Customer customer) {
        return null;
    }

    @PostMapping("/api/v1/customer/login")
    public ResponseEntity<AuthenticationResponse> custLogin(@RequestBody Object obj) {
        return null;
    }


    // Merchant
    @PostMapping("/api/v1/merchants/sign-up")
    public ResponseEntity<AuthenticationResponse> signUp(@RequestBody Merchant merchant) {
        //merchantService.saveMerchant(merchant);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/api/v1/merchants/login")
    public ResponseEntity login(@RequestBody Object obj) {
        return null;
    }

    // Store
    @PostMapping("/api/v1/stores/create-store-profile")
    public ResponseEntity<Integer> createNewStore(@RequestBody Store store) {
        try {
            Store createdStore = storeService.saveStore(store);
            LOG.info("=== Inside Store Controller ===");
            LOG.info("Store profile: " + store.toString());
            LOG.info("Database store profile: " + createdStore.toString());
            return new ResponseEntity<Integer>(createdStore.getStoreId(), HttpStatus.CREATED);
        } catch (Exception e) {
            throw e;
        }
    }

}

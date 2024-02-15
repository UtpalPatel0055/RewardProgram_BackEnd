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
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
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

    // LOGIN: For both; Merchant & Customer
    @PostMapping("/users/login")
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

    // Customer Sign-Up
    @PostMapping("/customer/sign-up")
    public ResponseEntity<AuthenticationResponse> custSignUp(@RequestBody Customer customer) {
        try {
            LOG.info("=== Inside Customer Controller ===");
            LOG.info("Merchant profile: " + customer.toString());
            LOG.info("Database Merchant profile");
            customerService.saveCustomer(customer);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch(Exception e) {
            throw e;
        }
    }

    // Merchant Sign-Up
    @PostMapping("/merchants/sign-up")
    public ResponseEntity<AuthenticationResponse> signUp(@RequestBody Merchant merchant) {
          try {
              LOG.info("=== Inside Merchant Controller ===");
              LOG.info("Merchant profile: " + merchant.toString());
              LOG.info("Database Merchant profile");
              merchantService.saveMerchant(merchant);
              return new ResponseEntity<>(HttpStatus.OK);
          } catch(Exception e) {
              throw e;
          }
    }

    // Store Sign-Up
    @PostMapping("/stores/create-store-profile")
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
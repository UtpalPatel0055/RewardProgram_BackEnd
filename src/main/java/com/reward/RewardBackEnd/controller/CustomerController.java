package com.reward.RewardBackEnd.controller;

import com.reward.RewardBackEnd.model.Customer;
import com.reward.RewardBackEnd.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/auth/customers")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;

    @PostMapping("/sign-up")
    public ResponseEntity signUp(@RequestBody Customer customer) {
        return null;
    }

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody Object obj) {
        return null;
    }

    @GetMapping("/dashboard")
    public String dashboard() {
        return "Customer Dashboard";
    }
}

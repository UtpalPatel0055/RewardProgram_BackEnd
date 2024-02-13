package com.reward.RewardBackEnd.controller;

import com.reward.RewardBackEnd.model.AuthenticationResponse;
import com.reward.RewardBackEnd.model.Customer;
import com.reward.RewardBackEnd.service.CustomerService;
import com.reward.RewardBackEnd.service.securityServices.TokenService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/auth/customers")
@RequiredArgsConstructor
public class CustomerController {

    private final TokenService tokenService;

    private final CustomerService customerService;


    @PreAuthorize("hasRole('CUSTOMER')")
    @GetMapping("/dashboard")
    public String dashboard() {
        return "Customer Dashboard";
    }

    @GetMapping("/dashboard1")
    public String dashboard1() {
        return "Customer Dashboard1";
    }

    @PreAuthorize("hasRole('CUSTOMER')")
    @GetMapping("/dashboard2")
    public String dashboard2() {
        return "Customer Dashboard2";
    }
}

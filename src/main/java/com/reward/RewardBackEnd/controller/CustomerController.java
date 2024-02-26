package com.reward.RewardBackEnd.controller;

import com.reward.RewardBackEnd.service.CustomerService;
import com.reward.RewardBackEnd.service.securityServices.TokenService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth/customers")
@RequiredArgsConstructor
public class CustomerController {

    private final TokenService tokenService;

    private final CustomerService customerService;

    @GetMapping("/dashboard1")
    public String dashboard1() {
        return "Customer Dashboard1";
    }


}

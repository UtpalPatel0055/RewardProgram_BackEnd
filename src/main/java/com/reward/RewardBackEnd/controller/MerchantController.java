package com.reward.RewardBackEnd.controller;

import com.reward.RewardBackEnd.model.AuthenticationResponse;
import com.reward.RewardBackEnd.model.Merchant;
import com.reward.RewardBackEnd.service.MerchantService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/auth/merchants")
@RequiredArgsConstructor
public class MerchantController {

    private final MerchantService merchantService;


    @GetMapping("/dashboard")
    public String dashboard() {
        return "Merchant Dashboard";
    }



}

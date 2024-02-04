package com.reward.RewardBackEnd.controller;

import com.reward.RewardBackEnd.model.Merchant;
import com.reward.RewardBackEnd.service.MerchantService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/auth/merchants")
@RequiredArgsConstructor
public class MerchantController {

    private final MerchantService merchantService;

    @PostMapping("/sign-up")
	public ResponseEntity signUp(@RequestBody Merchant merchant) {
        return null;
    }

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody Object obj) {
        return null;
    }

    @GetMapping("/dashboard")
    public String dashboard() {
        return "Merchant Dashboard";
    }


}

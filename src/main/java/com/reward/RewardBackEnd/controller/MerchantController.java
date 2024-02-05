package com.reward.RewardBackEnd.controller;

import com.reward.RewardBackEnd.model.Customer;
import com.reward.RewardBackEnd.model.Merchant;
import com.reward.RewardBackEnd.service.MerchantService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController

@RequestMapping("/api/v1/auth/merchants")
@RequiredArgsConstructor
public class MerchantController {

    private final MerchantService merchantService;

    @PostMapping("/sign-up")
    public ResponseEntity signUp(@RequestBody Merchant merchant) {
        return new ResponseEntity("Merchant Sign-up ok", HttpStatus.OK);
    }

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody Object obj) {
        return new ResponseEntity("Merchant Login ok", HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ROLE_MERCHANT')")
    @GetMapping("/dashboard")
    public String dashboard() {
        return "Merchant Dashboard";
    }

    @PreAuthorize("hasRole('ROLE_MERCHANT')")
    @GetMapping("/{id}")
    public ResponseEntity findById(@PathVariable("id") int id) {
        Optional<Merchant> m = merchantService.findByUserId(id);
        if(m.isPresent())
            return new ResponseEntity(m.get(), HttpStatus.OK);
        return new ResponseEntity("Merchant not found", HttpStatus.NOT_FOUND);
    }
}

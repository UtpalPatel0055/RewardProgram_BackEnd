package com.reward.RewardBackEnd.controller;

import com.reward.RewardBackEnd.model.Customer;
import com.reward.RewardBackEnd.model.Merchant;
import com.reward.RewardBackEnd.service.securityServices.TokenService;
import lombok.RequiredArgsConstructor;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AuthController {

    private final TokenService tokenService;

    private final AuthenticationManager authenticationManager;

    @GetMapping("/")
    public String home() {
        return "Hello, Papa";
    }

    @PostMapping("/customers/token")
    public String tokenCustomer(Customer customer) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        customer.getCustEmail(), customer.getPassword()
                )
        );
        String token = tokenService.generateToken(customer);
        return token;
    }

    @PostMapping("/merchants/token")
    public String tokenMerchant(Merchant merchant) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        merchant.getMerchantEmail(), merchant.getPassword()
                )
        );
        String token = tokenService.generateToken(merchant);
        return token;
    }
}

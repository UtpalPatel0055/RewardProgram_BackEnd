package com.reward.RewardBackEnd.controller;

import com.reward.RewardBackEnd.model.Customer;
import com.reward.RewardBackEnd.model.Merchant;
import com.reward.RewardBackEnd.service.securityServices.TokenService;
import lombok.RequiredArgsConstructor;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AuthController {

    private static final Logger LOG = LoggerFactory.getLogger(AuthController.class);

    private final TokenService tokenService;

    @GetMapping("/")
    public String home() {
        return "Hello, Papa";
    }

    @PostMapping("/customers/token")
    public String tokenCustomer(Customer customer) {
        LOG.debug("Token requested for user: ", customer.getCustEmail());
        String token = tokenService.generateToken(customer);
        LOG.debug("Token granted: " + token);
        return token;
    }

    @PostMapping("/merchants/token")
    public String tokenMerchant(Merchant merchant) {
        LOG.debug("Token requested for user: ", merchant.getMerchantEmail());
        String token = tokenService.generateToken(merchant);
        LOG.debug("Token granted: " + token);
        return token;
    }
}

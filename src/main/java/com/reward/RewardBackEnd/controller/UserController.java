package com.reward.RewardBackEnd.controller;

import com.reward.RewardBackEnd.model.User;
import com.reward.RewardBackEnd.service.securityServices.TokenService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
        String token = tokenService.generateToken(authentication);
        LOG.info("Token Generated " + token);
        return token;
    }

    @GetMapping("/merchant")
    public String getMerchant() {
        return "Merchant";
    }

    @GetMapping("/customer")
    public String getCustomer() {
        return "Customer";
    }


}

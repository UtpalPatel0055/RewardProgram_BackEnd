package com.reward.RewardBackEnd.controller;

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

//    private final TokenService tokenService;

    @GetMapping("/")
    public String home() {
        return "Hello, Papa";
    }

    @PostMapping("/token")
    public String token(Authentication authentication) {
//        LOG.debug("Token requested for user: " + authentication.getName());
//        String token = tokenService.generateToken(authentication);
//        LOG.debug("Token granted: " + token);
        return "Token has been generated";
    }
}

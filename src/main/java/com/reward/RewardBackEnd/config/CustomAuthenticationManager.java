package com.reward.RewardBackEnd.config;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;

import java.util.List;

public class CustomAuthenticationManager
//        implements AuthenticationManager
{
    private final List<AuthenticationProvider> authenticationProviders;

    public CustomAuthenticationManager(List<AuthenticationProvider> authenticationProviders) {
        this.authenticationProviders = authenticationProviders;
    }

//    @Override
//    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
//        AuthenticationException lastException = null;
//        for (AuthenticationProvider provider : authenticationProviders) {
//            try {
//                Authentication auth = provider.authenticate(authentication);
//                if (auth != null && auth.isAuthenticated()) {
//                    return auth;
//                }
//            } catch (AuthenticationException e) {
//                // Store the last exception in case no provider can authenticate the request
//                lastException = e;
//            }
//        }
//        // If none of the providers were able to authenticate the request, throw the last exception
//        throw lastException;
//    }
}

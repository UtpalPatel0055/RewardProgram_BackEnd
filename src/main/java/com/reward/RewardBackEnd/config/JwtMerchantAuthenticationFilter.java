package com.reward.RewardBackEnd.config;

import com.reward.RewardBackEnd.controller.MerchantController;
import com.reward.RewardBackEnd.service.MerchantService;
import com.reward.RewardBackEnd.service.securityServices.JwtService;
import com.sun.istack.NotNull;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.Getter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
@Getter
public class JwtMerchantAuthenticationFilter extends OncePerRequestFilter
{

    private final JwtService jwtService;

    private final MerchantService merchantService;

    public JwtMerchantAuthenticationFilter(JwtService jwtService, @Lazy MerchantService merchantService) {
        this.jwtService = jwtService;
        this.merchantService = merchantService;
    }

    private static final Logger LOG = LoggerFactory.getLogger(JwtMerchantAuthenticationFilter.class);

    @Override
    protected void doFilterInternal(@NotNull HttpServletRequest request,
                                    @NotNull HttpServletResponse response,
                                    @NotNull FilterChain filterChain)
            throws ServletException, IOException {

        String authHeader = request.getHeader("Authorization");

        if(authHeader == null || !authHeader.startsWith("Bearer")) {
            filterChain.doFilter(request, response);
            return;
        }

        String token = authHeader.substring(7);
        String merchant_username = jwtService.extractUsername(token);

        LOG.info("===== Inside Jwt-Merchant-Authentication-Filter ====" + merchant_username);

        if(merchant_username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
            UserDetails merchantUserDetails = merchantService.loadUserByUsername(merchant_username);
            if(jwtService.isValid(token, merchantUserDetails)) {
                UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(merchantUserDetails, null, merchantUserDetails.getAuthorities());
                authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                SecurityContextHolder.getContext().setAuthentication(authToken);
            }
        }
        filterChain.doFilter(request, response);
    }
}

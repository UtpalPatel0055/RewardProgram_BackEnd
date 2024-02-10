package com.reward.RewardBackEnd.config;

import com.reward.RewardBackEnd.service.CustomerService;
import com.reward.RewardBackEnd.service.securityServices.JwtService;
import com.sun.istack.NotNull;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
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
public class JwtCustomerAuthenticationFilter
                                extends OncePerRequestFilter
{

    private final JwtService jwtService;

    private final CustomerService customerService;

    public JwtCustomerAuthenticationFilter(JwtService jwtService, @Lazy CustomerService customerService) {
        this.jwtService = jwtService;
        this.customerService = customerService;
    }

    private static final Logger LOG = LoggerFactory.getLogger(JwtCustomerAuthenticationFilter.class);

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
        String cust_username = jwtService.extractUsername(token);

        LOG.info("===== Inside Jwt-Customer-Authentication-Filter ====" + cust_username);

        if(cust_username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
            UserDetails customerUserDetails = customerService.loadUserByUsername(cust_username);
            if(jwtService.isValid(token, customerUserDetails)) {
                UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(
                        customerUserDetails, null, customerUserDetails.getAuthorities()
                );
                authToken.setDetails(
                        new WebAuthenticationDetailsSource().buildDetails(request)
                );
                SecurityContextHolder.getContext().setAuthentication(authToken);
            }
        }
        filterChain.doFilter(request, response);
    }
}

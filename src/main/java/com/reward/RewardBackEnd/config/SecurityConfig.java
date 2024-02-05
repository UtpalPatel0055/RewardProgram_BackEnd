package com.reward.RewardBackEnd.config;

import com.reward.RewardBackEnd.service.securityServices.JpaCustomerUserDetailsService;
import com.reward.RewardBackEnd.service.securityServices.JpaMerchantUserDetailsService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
@RequiredArgsConstructor
public class SecurityConfig {

//    private final RsaKeyProperties rsaKeys;

    private final JpaCustomerUserDetailsService jpaCustomerUserDetailsService;

    private final JpaMerchantUserDetailsService jpaMerchantUserDetailsService;

    @Bean
    @Order(2)
    public SecurityFilterChain customerSecurityFilterChain(HttpSecurity http) throws Exception {
        return http
                .securityMatcher("/api/v1/auth/customers/**")
                .formLogin(withDefaults())
                .csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/api/v1/auth/customers/login", "/api/v1/auth/customers/sign-up").permitAll()
                        .anyRequest().authenticated()
                )
                .userDetailsService(jpaCustomerUserDetailsService)
//                .oauth2ResourceServer(oauth -> oauth.jwt(withDefaults()))
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .build();
    }

    @Bean
    @Order(1)
    public SecurityFilterChain merchantSecurityFilterChain(HttpSecurity http) throws Exception {
        return http
                .securityMatcher("/api/v1/auth/merchants/**")
                .formLogin(withDefaults())
                .csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/api/v1/auth/merchants/login", "/api/v1/auth/merchants/sign-up").permitAll()
                        .anyRequest().authenticated()
                )
                .userDetailsService(jpaMerchantUserDetailsService)
//                .oauth2ResourceServer(oauth -> oauth.jwt(withDefaults()))
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .build();
    }

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

//    @Bean
//    public InMemoryUserDetailsManager user() {
//        return new InMemoryUserDetailsManager(
//                User.withUsername("pdpatel")
//                        .password("{noop}password")
//                        .authorities("read")
//                        .build()
//        );
//    }

//    @Bean
//    JwtDecoder jwtDecoder() {
//        return NimbusJwtDecoder.withPublicKey(rsaKeys.publicKey()).build();
//    }
//
//    @Bean
//    JwtEncoder jwtEncoder() {
//        JWK jwk = new RSAKey.Builder(rsaKeys.publicKey()).privateKey(rsaKeys.privateKey()).build();
//        JWKSource<SecurityContext> jwks = new ImmutableJWKSet<>(new JWKSet(jwk));
//        return new NimbusJwtEncoder(jwks);
//    }
}

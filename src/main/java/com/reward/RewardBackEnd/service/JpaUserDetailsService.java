package com.reward.RewardBackEnd.service;

import com.reward.RewardBackEnd.model.SecurityUser;
import com.reward.RewardBackEnd.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class JpaUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    public JpaUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String userEmail) throws UsernameNotFoundException {
        return userRepository
                .findByEmail(userEmail)
                .map(SecurityUser::new)
                .orElseThrow(() -> new UsernameNotFoundException("No User has been found!"));
    }
}

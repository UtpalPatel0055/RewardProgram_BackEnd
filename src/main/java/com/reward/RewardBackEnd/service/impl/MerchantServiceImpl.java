package com.reward.RewardBackEnd.service.impl;

import com.reward.RewardBackEnd.model.Merchant;
import com.reward.RewardBackEnd.model.Role;
import com.reward.RewardBackEnd.repository.MerchantRepository;
import com.reward.RewardBackEnd.service.MerchantService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class MerchantServiceImpl implements MerchantService {

    private final PasswordEncoder passwordEncoder;

    private final MerchantRepository merchantRepository;

    @Override
    public Merchant saveMerchant(Merchant merchant) {
        // First name, Last name, email, password, phone, Role is done
        merchant.setPassword(passwordEncoder.encode(merchant.getPassword()));
        merchant.setRole(Role.ROLE_MERCHANT);
        merchant.setJoinDate(LocalDateTime.now());
        merchantRepository.save(merchant);
        return null;
    }
}

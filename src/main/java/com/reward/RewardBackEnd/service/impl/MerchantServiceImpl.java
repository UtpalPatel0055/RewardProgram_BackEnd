package com.reward.RewardBackEnd.service.impl;

import com.reward.RewardBackEnd.controller.AuthController;
import com.reward.RewardBackEnd.model.Merchant;
import com.reward.RewardBackEnd.repository.CustomerRepository;
import com.reward.RewardBackEnd.repository.MerchantRepository;
import com.reward.RewardBackEnd.service.MerchantService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MerchantServiceImpl implements MerchantService {

    private final MerchantRepository repository;

    private final PasswordEncoder encoder;

    private static final Logger LOG = LoggerFactory.getLogger(MerchantServiceImpl.class);


    @Override
    public Optional<Merchant> findByUserId(int id) {
        Optional<Merchant> merchant = repository.findById(id);
        return merchant;
    }

    @Override
    public Merchant register(Merchant merchant) {
        LOG.info(" === Inside Customer Service === ");
        LOG.info(" === Customer : === " + merchant.getMerchantEmail() + " and " + merchant.getPassword());
        LOG.info(" === ======================= === ");
        merchant.setPassword(encoder.encode(merchant.getPassword()));
//        c.setRole(Role.ROLE_CUSTOMER);
        return repository.save(merchant);
    }
}

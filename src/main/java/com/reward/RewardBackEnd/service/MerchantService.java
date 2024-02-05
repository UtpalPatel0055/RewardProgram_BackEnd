package com.reward.RewardBackEnd.service;

import com.reward.RewardBackEnd.model.Customer;
import com.reward.RewardBackEnd.model.Merchant;

import java.util.Optional;

public interface MerchantService {
    Optional<Merchant> findByUserId(int id);

    Merchant register(Merchant merchant);
}

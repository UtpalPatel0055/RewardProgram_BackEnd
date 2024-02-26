package com.reward.RewardBackEnd.model.custom;

import lombok.Getter;

@Getter
public class MerchantLoginRequest {

    private String email;

    private String phone;

    private String password;
}

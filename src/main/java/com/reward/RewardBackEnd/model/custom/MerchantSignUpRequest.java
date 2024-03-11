package com.reward.RewardBackEnd.model.custom;

import lombok.Getter;

@Getter
public class MerchantSignUpRequest {

    private String email;
    private String password;
    private String phone;
    private String firstName;
    private String lastName;
    private String role;
    private int storeId = 0;

}

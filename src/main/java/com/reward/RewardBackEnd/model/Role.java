package com.reward.RewardBackEnd.model;

import jakarta.persistence.Enumerated;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

public enum Role {
    ROLE_MERCHANT,
    ROLE_CUSTOMER
}

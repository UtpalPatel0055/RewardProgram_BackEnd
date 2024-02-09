package com.reward.RewardBackEnd.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;


@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Data
@NoArgsConstructor
@Entity
public class User  {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Integer userId;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private String password;
    private LocalDateTime joinDate;

    @Enumerated(EnumType.STRING)
    private Role role;





}

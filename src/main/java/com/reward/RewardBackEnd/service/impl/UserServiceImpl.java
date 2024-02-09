package com.reward.RewardBackEnd.service.impl;

import com.reward.RewardBackEnd.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

//    private final UserRepository userRepository;

//    private final JwtService jwtService;

//    private final PasswordEncoder passwordEncoder;

//    private final AuthenticationManager authenticationManager;


//    @Override
//    public AuthenticationResponse register(User user) {
//        User user1 = new User();
//        user1.setFirstName(user.getFirstName());
//        user1.setLastName(user.getLastName());
//        user1.setEmail(user.getEmail());
//        user1.setPassword(passwordEncoder.encode(user.getPassword()));
//        user1.setJoinDate(Instant.now());
//        user1.setRole(user.getRole());
//
//        userRepository.save(user1);
//        String token = jwtService.generateToken(user1);
//
//        return new AuthenticationResponse("token");
//    }
//
//    @Override
//    public AuthenticationResponse authenticate(User user) {
//        authenticationManager.authenticate(
//                new UsernamePasswordAuthenticationToken(
//                        user.getEmail(),
//                        user.getPassword()
//                )
//        );
//        User user1 = userRepository.findByEmail(user.getEmail()).orElseThrow();
//        String token = jwtService.generateToken(user1);
//
//        return new AuthenticationResponse("token");
//    }

}

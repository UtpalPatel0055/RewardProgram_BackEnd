package com.reward.RewardBackEnd.service.impl;

import com.reward.RewardBackEnd.model.AuthenticationResponse;
import com.reward.RewardBackEnd.model.Merchant;
import com.reward.RewardBackEnd.repository.MerchantRepository;
import com.reward.RewardBackEnd.service.MerchantService;
import com.reward.RewardBackEnd.service.securityServices.JwtService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MerchantServiceImpl implements MerchantService {

    private final MerchantRepository merchantRepository;

    private final PasswordEncoder encoder;

    private final JwtService jwtService;

    private final AuthenticationManager authenticationManager;

    private static final Logger LOG = LoggerFactory.getLogger(MerchantServiceImpl.class);


    @Override
    public Optional<Merchant> findByUserId(int id) {
        Optional<Merchant> merchant = merchantRepository.findById(id);
        return merchant;
    }

    @Override
    public AuthenticationResponse register(Merchant m) {
        LOG.info(" === Inside Merchant Service === ");
        LOG.info(" === Merchant : === " + m.getMerchantEmail() + " and " + m.getPassword());
        LOG.info(" === ======================= === ");

        Merchant merchant = new Merchant();
        merchant.setPassword(encoder.encode(m.getPassword()));
        merchant.setRole(m.getRole());
        merchant.setMerchantEmail(m.getMerchantEmail());
        merchant.setMerchantPhone(m.getMerchantPhone());
        merchant.setMerchantFirstName(m.getMerchantFirstName());
        merchant.setMerchantLastName(m.getMerchantLastName());
        merchant.setJobTitle(m.getJobTitle());
//        merchant.setJoinDate();


        merchantRepository.save(merchant);
        String token = jwtService.generateToken(merchant);

        return new AuthenticationResponse(token);
    }

    @Override
    public AuthenticationResponse authenticate(Merchant merchant) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        merchant.getMerchantEmail(),
                        merchant.getPassword()
                )
        );
        Merchant merchant1 = merchantRepository.findByMerchantEmail(merchant.getUsername()).orElseThrow();
        String token = jwtService.generateToken(merchant1);

        return new AuthenticationResponse(token);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        LOG.info("==== Inside JPA-Customer-User-Details ====" + username);
        LOG.info(" user details Email: " + merchantRepository.findByMerchantEmail(username));
        LOG.info(" user details Password: " + merchantRepository.findByMerchantEmail(username).get().getPassword());
        LOG.info("==========================================");
        return merchantRepository
                .findByMerchantEmail(username)
                .map(Merchant::new)
                .orElseThrow(() -> new UsernameNotFoundException("Merchant not found through repo" + username));
    }
}

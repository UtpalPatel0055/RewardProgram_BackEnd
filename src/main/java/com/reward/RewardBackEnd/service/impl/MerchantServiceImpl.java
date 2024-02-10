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
import org.springframework.security.core.AuthenticationException;
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
        LOG.info(" === Inside Merchant Service to register === ");
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
        LOG.info(" === Inside Merchant Service Impl to AUTHENTICATE === ");
        LOG.info(" === Merchant Email: === " + merchant.getMerchantEmail() + " and Password: " + merchant.getPassword());
        LOG.info(" === ======================= === ");
        try{
            UsernamePasswordAuthenticationToken userToken = new UsernamePasswordAuthenticationToken(merchant.getUsername(), merchant.getPassword());
            LOG.info("+++ UsernamePasswordAuthenticationToken passed +++");
            authenticationManager.authenticate(userToken);
            LOG.info("+++ Authentication Manager passed +++");
        } catch (AuthenticationException e) {
            LOG.info(" +++ EXCEPTION +++ " + e.getMessage());
            LOG.error(" +++ EXCEPTION +++ " + e.getMessage());
            throw new RuntimeException("Authentication failed", e);
        }
        LOG.info(" === AUTHENTICATION MANAGER HAS BEEN PASSED === ");
        LOG.info(" === Now, trying to log-in === ");
//        Merchant merchant1 = merchantRepository.findByMerchantEmail(merchant.getUsername()).orElseThrow();
        Optional<Merchant> merchant1 = merchantRepository.findByMerchantEmail(merchant.getUsername());
        if(merchant1.isPresent()) {
            LOG.info(" === SUCCESSFULLY FOUND Merchant TO LOGIN === " + merchant1.get().getMerchantEmail() + " and " + merchant1.get().getPassword());
            String token = jwtService.generateToken(merchant1.get());
            return new AuthenticationResponse(token);
        }
        LOG.info("========== No MERCHANT is found for LOGGING IN ==========");
        throw new UsernameNotFoundException("No MERCHANT is found for LOGGING IN");
    }

    @Override
    public UserDetails loadUserByUsername(String userEmail) throws UsernameNotFoundException {
        LOG.info("==== Inside JPA-Customer-User-Details ====" + userEmail);
        LOG.info(" Merchant details Email: " + merchantRepository.findByMerchantEmail(userEmail));
        LOG.info(" Merchant details Password: " + merchantRepository.findByMerchantEmail(userEmail).get().getPassword());
        LOG.info("==========================================");
        return merchantRepository
                .findByMerchantEmail(userEmail)
                .map(Merchant::new)
                .orElseThrow(() -> new UsernameNotFoundException("Merchant not found through repo" + userEmail));
    }
}

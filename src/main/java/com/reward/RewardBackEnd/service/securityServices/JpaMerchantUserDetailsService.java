package com.reward.RewardBackEnd.service.securityServices;

import com.reward.RewardBackEnd.model.Customer;
import com.reward.RewardBackEnd.model.Merchant;
import com.reward.RewardBackEnd.repository.MerchantRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class JpaMerchantUserDetailsService implements UserDetailsService {

    private final MerchantRepository merchantRepository;

    private static final Logger LOG = LoggerFactory.getLogger(JpaCustomerUserDetailsService.class);

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

package com.reward.RewardBackEnd.service.securityServices;

import com.reward.RewardBackEnd.model.Customer;
import com.reward.RewardBackEnd.repository.CustomerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class JpaCustomerUserDetailsService implements UserDetailsService {

    private final CustomerRepository customerRepository;

    private static final Logger LOG = LoggerFactory.getLogger(JpaCustomerUserDetailsService.class);

    public JpaCustomerUserDetailsService(CustomerRepository userRepository) {
        this.customerRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        LOG.info("==== Inside JPA-Customer-User-Details ====" + username);
        LOG.info(" user details Email: " + customerRepository.findByCustEmail(username));
        LOG.info(" user details Password: " + customerRepository.findByCustEmail(username).get().getPassword());
        LOG.info("==========================================");
        return customerRepository
                .findByCustEmail(username)
                .map(Customer::new)
                .orElseThrow(() -> new UsernameNotFoundException("Customer not found through repo" + username));
    }
}

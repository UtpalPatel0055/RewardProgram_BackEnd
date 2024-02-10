package com.reward.RewardBackEnd.service.impl;

import com.reward.RewardBackEnd.model.AuthenticationResponse;
import com.reward.RewardBackEnd.model.Customer;
import com.reward.RewardBackEnd.repository.CustomerRepository;
import com.reward.RewardBackEnd.service.CustomerService;
import com.reward.RewardBackEnd.service.securityServices.JwtService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;

    private final PasswordEncoder encoder;

    private final JwtService jwtService;

    private final AuthenticationManager authenticationManager;

    private static final Logger LOG = LoggerFactory.getLogger(CustomerServiceImpl.class);

    @Override
    public Optional<Customer> findByUserId(int id) {
        Optional<Customer> customer = customerRepository.findById(id);
        return customer;
    }

    @Override
    public AuthenticationResponse register(Customer customer) {
        LOG.info(" === Inside Customer Service === ");
        LOG.info(" === Customer : === " + customer.getCustEmail() + " and " + customer.getPassword());
        LOG.info(" === ======================= === ");
        Customer cust = new Customer();
        cust.setCustFirstName(customer.getCustFirstName());
        cust.setCustLastName(customer.getCustLastName());
        cust.setCustEmail(customer.getCustEmail());
        cust.setPassword(encoder.encode(customer.getPassword()));
        cust.setRole(customer.getRole());
        cust.setStatus("OK");
        cust.setCurrPoints(0);
        cust.setTotalSpent(0);
//        cust.setJoinDate();
//        cust.setLastPurchase();

        customerRepository.save(cust);
        String token = jwtService.generateToken(customer);
        return new AuthenticationResponse(token);
    }

    @Override
    public AuthenticationResponse authenticate(Customer c) {
        LOG.info(" === Inside CUSTOMER Service Impl to AUTHENTICATE === ");
        LOG.info(" === Merchant Email: === " + c.getCustEmail() + " and Password: " + c.getPassword());
        LOG.info(" === ======================= === ");
        try {
            UsernamePasswordAuthenticationToken customerToken = new UsernamePasswordAuthenticationToken(c.getUsername(), c.getPassword());
            LOG.info("+++ UsernamePasswordAuthenticationToken passed +++");
            authenticationManager.authenticate(customerToken);
            LOG.info("+++ Authentication Manager passed +++");
        } catch (AuthenticationException e) {
            LOG.info(" +++ EXCEPTION +++ " + e.getMessage());
            LOG.error(" +++ EXCEPTION +++ " + e.getMessage());
            throw new RuntimeException("Authentication failed", e);
        }
        LOG.info(" === AUTHENTICATION MANAGER HAS BEEN PASSED === ");
        LOG.info(" === Now, trying to log-in === ");
        Optional<Customer> cust = customerRepository.findByCustEmail(c.getUsername());
        if(cust.isPresent()) {
            LOG.info(" === SUCCESSFULLY FOUND CUSTOMER TO LOGIN === " + cust.get().getCustEmail() + " and " + cust.get().getPassword());
            String token = jwtService.generateToken(cust.get());
            return new AuthenticationResponse(token);
        }
        LOG.info("========== No CUSTOMER is found for LOGGING IN ==========");
        throw new UsernameNotFoundException("No CUSTOMER is found for LOGGING IN");
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

package com.reward.RewardBackEnd.controller;

import com.reward.RewardBackEnd.model.Customer;
import com.reward.RewardBackEnd.model.Merchant;
import com.reward.RewardBackEnd.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController

@RequestMapping("/api/v1/auth/customers")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;

    @PostMapping("/sign-up")
    public ResponseEntity signUp(@RequestBody Customer customer) {
        return new ResponseEntity("Customer Sign-up ok", HttpStatus.OK);
    }

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody Object obj) {
        return new ResponseEntity("Customer Login ok", HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ROLE_CUSTOMER')")
    @GetMapping("/dashboard")
    public String dashboard() {
        return "Customer Dashboard";
    }

    @PreAuthorize("hasRole('ROLE_CUSTOMER')")
    @GetMapping("/{id}")
    public ResponseEntity findById(@PathVariable("id") int id) {
        Optional<Customer> c = customerService.findByUserId(id);
        if(c.isPresent())
            return new ResponseEntity(c.get(), HttpStatus.OK);
        return new ResponseEntity("Merchant not found", HttpStatus.NOT_FOUND);
    }


}

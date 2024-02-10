package com.reward.RewardBackEnd.controller;

import com.reward.RewardBackEnd.model.AuthenticationResponse;
import com.reward.RewardBackEnd.model.Customer;
import com.reward.RewardBackEnd.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/v1/auth/customers")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;

    @PostMapping("/sign-up")
    public ResponseEntity<AuthenticationResponse> signUp(@RequestBody Customer customer) {
        return ResponseEntity.ok(customerService.register(customer));
    }

    @PostMapping("/login")
    public ResponseEntity<AuthenticationResponse> login(@RequestBody Customer customer) {
        return ResponseEntity.ok(customerService.authenticate(customer));
    }

    @PreAuthorize("hasRole('ROLE_CUSTOMER')")
    @GetMapping("/dashboard")
    public String dashboard() {
        return "Customer Dashboard";
    }

//    @PreAuthorize("hasRole('ROLE_CUSTOMER')")
//    @GetMapping("/{id}")
//    public ResponseEntity findById(@PathVariable("id") int id) {
//        Optional<Customer> c = customerService.findByUserId(id);
//        if(c.isPresent())
//            return new ResponseEntity(c.get(), HttpStatus.OK);
//        return new ResponseEntity("Merchant not found", HttpStatus.NOT_FOUND);
//    }


}

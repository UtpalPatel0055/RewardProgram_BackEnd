package com.reward.RewardBackEnd.controller;

import java.util.Optional;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.reward.RewardBackEnd.model.Customer;

@RestController
public class StoreController {

	@GetMapping("/store/Customers/{storeId}")
	public Optional<Customer> getCustomerByStoreId(@PathVariable int storeId) {
		return Optional.empty();
	}
	
	
}

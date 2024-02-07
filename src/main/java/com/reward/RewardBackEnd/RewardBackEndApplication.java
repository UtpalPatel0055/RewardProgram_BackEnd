package com.reward.RewardBackEnd;

import com.reward.RewardBackEnd.config.RsaKeyProperties;
import com.reward.RewardBackEnd.model.Customer;
import com.reward.RewardBackEnd.model.Merchant;
import com.reward.RewardBackEnd.model.Role;
import com.reward.RewardBackEnd.service.CustomerService;
import com.reward.RewardBackEnd.service.MerchantService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableConfigurationProperties(RsaKeyProperties.class)
public class RewardBackEndApplication {

	public static void main(String[] args) {
		SpringApplication.run(RewardBackEndApplication.class, args);
	}

//	@Bean
//	CommandLineRunner commandLineRunner(CustomerService customerService, MerchantService merchantService) {
//		return args -> {
//			Customer user = new Customer();
//			user.setRole(Role.ROLE_CUSTOMER);
//			user.setCustEmail("Dharti");
//			user.setPassword("password");
//			user.setCustFirstName("dharti");
//			user.setCustLastName("patel");
//			user.setCurrPoints(0);
//			user.setTotalSpent(0);
//			customerService.register(user);
//
//			Merchant user1 = new Merchant();
//			user1.setRole(Role.ROLE_MERCHANT);
//			user1.setMerchantEmail("Utpal");
//			user1.setPassword("password");
//			user1.setMerchantFirstName("utpal");
//			user1.setMerchantLastName("patel");
//			merchantService.register(user1);
//		};
//	}
}
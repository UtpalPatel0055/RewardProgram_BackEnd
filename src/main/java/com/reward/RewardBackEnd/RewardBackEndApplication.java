package com.reward.RewardBackEnd;

import com.reward.RewardBackEnd.config.RsaKeyProperties;
import com.reward.RewardBackEnd.model.Customer;
import com.reward.RewardBackEnd.model.Merchant;
import com.reward.RewardBackEnd.repository.CustomerRepository;
import com.reward.RewardBackEnd.repository.MerchantRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
@EnableConfigurationProperties(RsaKeyProperties.class)
public class RewardBackEndApplication {

	public static void main(String[] args) {
		SpringApplication.run(RewardBackEndApplication.class, args);
	}

//	@Bean
//	CommandLineRunner commandLineRunner(MerchantRepository merchantRepository, CustomerRepository customerRepository, PasswordEncoder passwordEncoder) {
//		return args -> {
//			Merchant merchant = new Merchant();
//			merchant.setRole(Role.ROLE_MERCHANT);
//			merchant.setPhone("987");
//			merchant.setLastName("Patel");
//			merchant.setFirstName("Utpal");
//			merchant.setEmail("utpal");
//			merchant.setPassword(passwordEncoder.encode("password"));
//			merchantRepository.save(merchant);
//
//			Customer cust = new Customer();
//			cust.setFirstName("Dharti");
//			cust.setLastName("Patel");
//			cust.setEmail("dharti");
//			cust.setPassword(passwordEncoder.encode("password"));
//			cust.setPhone("781");
//			cust.setRole(Role.ROLE_CUSTOMER);
//			customerRepository.save(cust);
//		};
//	}

}
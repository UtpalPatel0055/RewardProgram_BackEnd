package com.reward.RewardBackEnd;

import com.reward.RewardBackEnd.config.RsaKeyProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(RsaKeyProperties.class)
public class RewardBackEndApplication {

	public static void main(String[] args) {
		SpringApplication.run(RewardBackEndApplication.class, args);
	}
}
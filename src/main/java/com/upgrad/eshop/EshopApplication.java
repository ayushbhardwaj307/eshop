package com.upgrad.eshop;

import com.upgrad.eshop.services.InitService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class EshopApplication {
	public static void main(String[] args) {
		SpringApplication.run(EshopApplication.class, args);
	}
	@Bean
	CommandLineRunner init(InitService initService) {
		return args -> {
			initService.init();
		};
	}
}

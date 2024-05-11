package com.shop;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.shop.services.StorageService;

@SpringBootApplication
public class ProjectSaleApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjectSaleApplication.class, args);
	}
	@Bean
	CommandLineRunner init(StorageService storageService) {
		return (args) -> {
			
			storageService.init();
		};
	}

}

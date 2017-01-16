package com.atos.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class AtosApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(AtosApplication.class, args);
	}
}

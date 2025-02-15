package com.example.CoffeMachine;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class CoffeMachineApplication {

	public static void main(String[] args) {
		SpringApplication.run(CoffeMachineApplication.class, args);
	}

}

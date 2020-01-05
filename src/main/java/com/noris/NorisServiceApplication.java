package com.noris;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class NorisServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(NorisServiceApplication.class, args);
	}
}

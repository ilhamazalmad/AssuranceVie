package com.example.AssuranceVie;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AssuranceVieApplication {

	public static void main(String[] args) {
		SpringApplication.run(AssuranceVieApplication.class, args);
	}
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(AssuranceVieApplication.class);
	}
}

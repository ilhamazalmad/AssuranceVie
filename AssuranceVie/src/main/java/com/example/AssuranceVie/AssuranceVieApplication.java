package com.example.AssuranceVie;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories(basePackages = {"com.example.AssuranceVie"})
@SpringBootApplication
public class AssuranceVieApplication {

	public static void main(String[] args) {
		SpringApplication.run(AssuranceVieApplication.class, args);
	}


	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(AssuranceVieApplication.class);
	}
}

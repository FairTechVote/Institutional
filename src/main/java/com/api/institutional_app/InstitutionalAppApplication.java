package com.api.institutional_app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.github.cdimascio.dotenv.Dotenv;

@SpringBootApplication
public class InstitutionalAppApplication {

	public static void main(String[] args) {
		Dotenv dotenv = Dotenv.load();

		System.setProperty("DATABASE_URL", dotenv.get("DATABASE_URL"));
		System.setProperty("DATABASE_USERNAME", dotenv.get("DATABASE_USERNAME"));
		System.setProperty("DATABASE_PASSWORD", dotenv.get("DATABASE_PASSWORD"));

		System.setProperty("jwt.secret", dotenv.get("JWT_SECRET"));
    	System.setProperty("jwt.expiration", dotenv.get("JWT_EXPIRATION"));

		SpringApplication.run(InstitutionalAppApplication.class, args);
	}

}

package com.api.institutional_app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.github.cdimascio.dotenv.Dotenv;

@SpringBootApplication
public class InstitutionalAppApplication {

	public static void main(String[] args) {
		loadEnviromentVariables();
		SpringApplication.run(InstitutionalAppApplication.class, args);
	}

	private static void setPropertyWithFallback(String key, Dotenv dotenv) {

		String value = System.getenv(key);

		if (value == null) {
			value = dotenv.get(key);
		}
		if (value != null) {
			System.setProperty(key, value);
		}

	}

	private static void loadEnviromentVariables() {
		Dotenv dotenv = Dotenv.load();
		setPropertyWithFallback("DATABASE_URL", dotenv);
		setPropertyWithFallback("DATABASE_USERNAME", dotenv);
		setPropertyWithFallback("DATABASE_PASSWORD", dotenv);
		setPropertyWithFallback("JWT_SECRET", dotenv);
		setPropertyWithFallback("JWT_EXPIRATION", dotenv);
	}

}

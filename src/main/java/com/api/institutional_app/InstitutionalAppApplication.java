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
		try {
			Dotenv dotenv = Dotenv.configure()
					.ignoreIfMissing()
					.load();

			setPropertyWithFallback("DATABASE_URL", dotenv);
			setPropertyWithFallback("DATABASE_USERNAME", dotenv);
			setPropertyWithFallback("DATABASE_PASSWORD", dotenv);
			setPropertyWithFallback("JWT_SECRET", dotenv);
			setPropertyWithFallback("JWT_EXPIRATION", dotenv);

			System.out.println("Enviroment variables loaded from .env file.");
		} catch (Exception e) {
			System.out.println("File .env not found. Using system variables.");
		}
	}

}

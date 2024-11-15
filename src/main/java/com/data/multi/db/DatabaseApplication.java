package com.data.multi.db;

import jakarta.annotation.PostConstruct;
import org.flywaydb.core.Flyway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DatabaseApplication {

	@Autowired
	private Flyway userFlyway;

	@Autowired
	private Flyway productFlyway;

	public static void main(String[] args) {
		SpringApplication.run(DatabaseApplication.class, args);
	}

	@PostConstruct
	public void migrate() {
		userFlyway.migrate();
		productFlyway.migrate();
	}
}

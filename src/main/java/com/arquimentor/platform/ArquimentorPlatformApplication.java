package com.arquimentor.platform;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class ArquimentorPlatformApplication {

	public static void main(String[] args) {
		SpringApplication.run(ArquimentorPlatformApplication.class, args);
	}

}

package com.tarun.invoizer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication
@EnableJpaRepositories("com.tarun.invoizer.repositories")
public class InvoizerApplication {

	public static void main(String[] args) {
		SpringApplication.run(InvoizerApplication.class, args);
	}

}

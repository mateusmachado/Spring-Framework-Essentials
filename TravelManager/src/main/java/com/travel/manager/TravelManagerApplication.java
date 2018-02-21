package com.travel.manager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.jpa.JpaRepositoriesAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
@Configuration
@EnableAutoConfiguration(exclude = { HibernateJpaAutoConfiguration.class, JpaRepositoriesAutoConfiguration.class })
public class TravelManagerApplication {

	public static void main(String[] args) {
		SpringApplication.run(TravelManagerApplication.class, args);
	}
}

package com.HallBooking.updateService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
//@EnableJpaAuditing
@EnableAutoConfiguration(exclude=HibernateJpaAutoConfiguration.class)
@ComponentScan(basePackages="com.HallBooking")
public class UpdateServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(UpdateServiceApplication.class, args);
	}

	public RestTemplate getRestTenplRestTemplate() {
		return new RestTemplate();
	}
	
}

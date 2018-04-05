package com.ridecrew.springbootridecrew;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@EntityScan(
        basePackageClasses = {SpringBootRidecrewApplication.class, Jsr310JpaConverters.class}
) 
@SpringBootApplication
public class SpringBootRidecrewApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootRidecrewApplication.class, args);
	}
}

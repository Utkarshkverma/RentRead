package com.vermau2k01.RentRead;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class RentReadApplication {

	public static void main(String[] args) {
		SpringApplication.run(RentReadApplication.class, args);
	}

}

package com.irrigation.system;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class AutomaticIrrigationSystem1Application {

	public static void main(String[] args) {
		SpringApplication.run(AutomaticIrrigationSystem1Application.class, args);
	}

}

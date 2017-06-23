package com.smarthome;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@ImportResource(locations = {"classpath:spring/applicationContext-*.xml"})
@SpringBootApplication
public class SmarthomeApplication {

	public static void main(String[] args) {
		SpringApplication.run(SmarthomeApplication.class, args);
	}
}

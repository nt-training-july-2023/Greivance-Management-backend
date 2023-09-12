package com.grievance.Grievance;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class GrievanceApplication {

	public static void main(String[] args) {
		SpringApplication.run(GrievanceApplication.class, args);
	}
	@Bean
	public ModelMapper modelmapper() {
		return new ModelMapper();
	}
	}	
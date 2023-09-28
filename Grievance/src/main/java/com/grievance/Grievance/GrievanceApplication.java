package com.grievance.Grievance;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/**
 * The main class for starting the Grievance Application.
 */
@SpringBootApplication
public class GrievanceApplication {
	/**
	 * The main method to start the Spring Boot application.
	 *
	 * @param args The command line arguments.
	 */
	public static void main(String[] args) {
		SpringApplication.run(GrievanceApplication.class, args);
	}
	/**
	 * ModelMapper bean.
	 *
	 * @return A ModelMapper instance for mapping objects.
	 */
	@Bean
	public ModelMapper modelmapper() {
		return new ModelMapper();
	}
}
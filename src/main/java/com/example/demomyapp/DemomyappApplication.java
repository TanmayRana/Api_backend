
// package com.example.demomyapp;

// import org.springframework.boot.SpringApplication;
// import org.springframework.boot.autoconfigure.SpringBootApplication;
// import org.springframework.context.annotation.Bean;
// import org.springframework.web.client.RestTemplate;

// @SpringBootApplication
// public class DemomyappApplication {

// 	public static void main(String[] args) {
// 		SpringApplication.run(DemomyappApplication.class, args);
// 	}

// 	// Register RestTemplate as a bean to inject anywhere in the app
// 	@Bean
// 	public RestTemplate restTemplate() {
// 		return new RestTemplate();
// 	}

// }

// package com.example.demomyapp;

// import java.time.LocalDate;

// import org.springframework.boot.SpringApplication;
// import org.springframework.boot.autoconfigure.SpringBootApplication;
// import org.springframework.context.annotation.Bean;
// import org.springframework.web.client.RestTemplate;

// import com.fasterxml.jackson.databind.ObjectMapper;
// import com.fasterxml.jackson.databind.SerializationFeature;
// import com.fasterxml.jackson.databind.module.SimpleModule;
// import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

// @SpringBootApplication
// public class DemomyappApplication {

// 	public static void main(String[] args) {
// 		SpringApplication.run(DemomyappApplication.class, args);
// 	}

// 	// This bean makes RestTemplate available for @Autowired
// 	@Bean
// 	public RestTemplate restTemplate() {
// 		return new RestTemplate();
// 	}

// 	@Bean
// 	public ObjectMapper objectMapper() {
// 		ObjectMapper mapper = new ObjectMapper();
// 		mapper.enable(SerializationFeature.INDENT_OUTPUT); // Pretty printing
// 		mapper.registerModule(new JavaTimeModule()); // Support for Java 8 Date/Time API
// 		mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS); // Write dates as ISO-8601 strings

// 		return mapper;
// 	}

// }

package com.example.demomyapp;

// import java.time.LocalDate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

@SpringBootApplication
public class DemomyappApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemomyappApplication.class, args);
	}

	// This bean makes RestTemplate available for @Autowired
	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

	@Bean
	public ObjectMapper objectMapper() {
		// Configure ObjectMapper for pretty printing and Java 8 Date/Time API support
		ObjectMapper mapper = new ObjectMapper();
		mapper.enable(SerializationFeature.INDENT_OUTPUT);
		mapper.registerModule(new JavaTimeModule());
		mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);

		return mapper;
	}
}
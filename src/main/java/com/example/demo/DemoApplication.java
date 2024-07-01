package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;

@SpringBootApplication
@OpenAPIDefinition(
	info = @Info(
		title = "Hello World Project",
		version = "1.0.0",
		description = "This project is a demo",
		termsOfService = "runcodenow",
		contact = @Contact(
			name = "mr Lorusso",
			email = "vincenzo.lorusso@esterni.ovs.it"
		),
		license = @License(
			name = "licence",
			url = "runcodenow"
		)

	)
)
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

}

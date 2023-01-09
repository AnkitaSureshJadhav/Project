package com.example.APIDemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com")
@EntityScan("com")
public class ApiDemoApplication {

	public static  void main(String[] args) {
		SpringApplication.run(ApiDemoApplication.class, args);
	}

}

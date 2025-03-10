package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class ThirdWebAppApplication {
	@GetMapping("/omkar")
	public String getMessage() {
		return "<h1>Hello Everyone</h1>";
	}
	public static void main(String[] args) {
		SpringApplication.run(ThirdWebAppApplication.class, args);
	}

}

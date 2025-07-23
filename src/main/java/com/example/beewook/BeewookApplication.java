package com.example.beewook;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class BeewookApplication {

	public static void main(String[] args) {
		SpringApplication.run(BeewookApplication.class, args);
	}

	@GetMapping("/")
	public String index() {
		return "Backend is started, lmao";
	}

}

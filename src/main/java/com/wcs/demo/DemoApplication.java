package com.wcs.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class DemoApplication {
	
	@GetMapping("/welcome")
	public String welcome(){
		return "Welcome to WCS Spring APP";
	}
	

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

}

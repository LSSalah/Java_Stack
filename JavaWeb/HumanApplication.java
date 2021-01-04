package com.hello.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController

public class HumanApplication {

	public static void main(String[] args) {
		SpringApplication.run(HumanApplication.class, args);
	}
	 @RequestMapping("")
	    // 3. Method that maps to the request route above
	    public String human(@RequestParam(value="name", required=false) String n) { // 3
	            if (n == null) {
	            	return "<h1>Hello Human</h1> <p>Welcome to Spring Boot </p>";
	            }
	            else {
	            	return "<h1>Hello " + n + "</h1> <p>Welcome to Spring Boot </p>";
	            }
	    }
	
    
}

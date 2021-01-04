package com.example.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
// 2. Importing dependencies
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@SpringBootApplication
// 1. Annotation
@RestController
@RequestMapping("/coding")
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
	
	 // 1. Annotation
    @RequestMapping("")
    // 3. Method that maps to the request route above
    public String hello() { // 3
            return "Hello Coding Dojo!";
    }
    
    @RequestMapping("/python")
    // 3. Method that maps to the request route above
    public String awesome() { // 3
            return "Python/Django was awesome!";
    }
    
    @RequestMapping("/java")
    // 3. Method that maps to the request route above
    public String suck() { // 3
            return "Java/Spring is better!";
    }
}

    
    
   



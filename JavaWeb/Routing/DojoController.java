package com.example.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DojoController {

	public static void main(String[] args) {
		SpringApplication.run(DojoController.class, args);
	}
	@RequestMapping("/{name}")
    public String dojo(@PathVariable("name") String searchQuery) {
    	if ( searchQuery.equals("dojo") ) {
    		return "The " + searchQuery + " is awesome!";
    		
    		}
    	else if (searchQuery.equals("burbank-dojo") ) {
    		return searchQuery + " is located in Southern California";
    	}
    	else if (searchQuery.equals("san-jose") ) {
    		return "'SJ dojo is the headquarters" ;
    	}
    	else {
    		return "You Searched for " + searchQuery ;
    	}
    }
}
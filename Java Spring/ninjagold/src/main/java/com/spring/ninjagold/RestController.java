package com.spring.ninjagold;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RestController {
	@RequestMapping("/reset")
	public String reset(HttpSession session) {
		ArrayList <String> activites = new ArrayList <String> () ;
		session.setAttribute("gold", 0);
		session.setAttribute("activities" , activites);
			
		

	return "redirect:/";
	}
}

package com.spring.ninjagold;


import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("")
public class HomeController {
	@RequestMapping("/")
	public String index(HttpSession session) {
		ArrayList <String> activites = new ArrayList <String> () ;
		if (session.isNew()) {
			session.setAttribute("gold", 0);
			session.setAttribute("activities" , activites);
			
		}

			return "index.jsp";
		}
}
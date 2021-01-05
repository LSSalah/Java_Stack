package com.spring.counter;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/counter")
public class CountController {
	@RequestMapping("")
	public String counter(HttpSession session) {
		if (session.isNew()) {
			session.setAttribute("count", 0);
		}
        Integer count = (Integer) session.getAttribute("count");
        count += 1;
        session.setAttribute("count", count);
		
		return "counter.jsp";
		}

}

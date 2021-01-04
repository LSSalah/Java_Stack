package com.spring.display;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TimeController {
	@RequestMapping("/time")
	public String displayTime(Model model) {
		DateFormat timeFormat = new SimpleDateFormat("HH:mm a");
		Date date = new Date();
		model.addAttribute("time", timeFormat.format(date));
		return "time.jsp";
	}

}

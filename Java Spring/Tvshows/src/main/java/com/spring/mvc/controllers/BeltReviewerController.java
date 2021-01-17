package com.spring.mvc.controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.spring.mvc.models.Rating;
import com.spring.mvc.models.Show;
import com.spring.mvc.models.User;
import com.spring.mvc.services.BeltReviewerService;
import com.spring.mvc.validators.UserValidator;

@Controller
public class BeltReviewerController {
	private final BeltReviewerService beltReviewerService;
	private final UserValidator userValidator;

	public BeltReviewerController(BeltReviewerService beltReviewerService, UserValidator userValidator) {
		this.beltReviewerService = beltReviewerService;
		this.userValidator = userValidator;
	}
	
	ArrayList<String> states = new ArrayList<String>(Arrays.asList("PS", "AK", "AZ", "AR", "CA", "CO", "CT",
			"DE", "FL", "GA", "HI", "ID", "IL", "MS", "MO", "MT", "NE", "NV", "NH", "NJ", "NM", "NY", "NC"));
	
	//Index
	@RequestMapping("")
	public String index(@ModelAttribute("userObj") User user, Model model) {
//		model.addAttribute("states", states);
		return "index.jsp";
	}
	
	@RequestMapping(value="/register", method=RequestMethod.POST)
	public String register(@Valid @ModelAttribute("userObj") User user, BindingResult result, Model model, HttpSession session) {
		userValidator.validate(user, result);
		if(result.hasErrors()) {
//			model.addAttribute("states", states);
			return "index.jsp";
		}
		boolean isDuplicate = beltReviewerService.duplicateUser(user.getEmail());
		if(isDuplicate) {
			model.addAttribute("errore", "Email already in use! Please try again with a different email address!");
			return "index.jsp";
		}
		User u = beltReviewerService.registerUser(user);
		session.setAttribute("userId", u.getId());
		return "redirect:/shows";
	}
	
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String signIn(@Valid @ModelAttribute("userObj") User user, BindingResult result,@RequestParam("email") String email, @RequestParam("password") String password, Model model, HttpSession session) {
		boolean isAuthenticated = beltReviewerService.authenticateUser(email, password);
		if(isAuthenticated) {
			User u = beltReviewerService.findByEmail(email);
			session.setAttribute("userId", u.getId());
			return "redirect:/shows";
		}
		else {
			model.addAttribute("error", "Invalid Credentials! Please try again with the correct user information!");
			return "index.jsp";	
		}
	}
		
	@RequestMapping("/logout")
		public String logout(HttpSession session) {
			session.invalidate();
			return "redirect:/";
	}
	
	//Dashboard
		@RequestMapping("/shows")
		public String dashboard(@Valid @ModelAttribute("showObj") Show show, BindingResult result, HttpSession session, Model model) {
			if(session.getAttribute("userId") == null) {
				return "redirect:/";
			}
			User user = beltReviewerService.findUserById((Long) session.getAttribute("userId"));
			model.addAttribute("user", user);
	        List<Show> shows = beltReviewerService.allShows();
	        model.addAttribute("shows", shows);
//	        List<Rating> instate = new ArrayList<Rating>();
//	        for(Show origin: shows) {
//	        	if(origin.getShow().equals(user.getRatings())) {
//	        		instate.add(origin);
//	        	}
//	        	
//	        }
//	        model.addAttribute("instate", instate);
			return "dashboard.jsp";
		}
		
		@RequestMapping("/shows/add")
		public String newshow(@Valid @ModelAttribute("showObj") Show show, BindingResult result, HttpSession session, Model model) {
			if(session.getAttribute("userId") == null) {
				return "redirect:/";
			}
			User user = beltReviewerService.findUserById((Long) session.getAttribute("userId"));
			model.addAttribute("user", user);
			List<Show> shows = beltReviewerService.allShows();
	        model.addAttribute("shows", shows);
			return "newshow.jsp";

		}
		
		@GetMapping("/shows/{id}")
		public String viewShow(@PathVariable("id") Long id, @Valid @ModelAttribute("ratingObj") Rating rating, BindingResult result, Model model, HttpSession session) {
			if(session.getAttribute("userId") == null) {
				return "redirect:/";
			}
			
			User user = beltReviewerService.findUserById((Long) session.getAttribute("userId"));
			Show show = beltReviewerService.findShowById(id);
			List<Rating> ratings = show.getRatings();
			Collections.reverse(ratings);
			model.addAttribute("show", show);
			model.addAttribute("user", user);
			model.addAttribute("attendees", show.getJoinedUsers());
			model.addAttribute("ratings", ratings);
			return "details.jsp";
		}

		@GetMapping("/shows/{id}/edit")
		public String editPage(@PathVariable("id") Long id, @ModelAttribute("show") Show show, Model model, HttpSession session) {
			if(session.getAttribute("userId") == null) {
				return "redirect:/";
			}
			User user = beltReviewerService.findUserById((Long)session.getAttribute("userId"));
			if(beltReviewerService.findShowById(id).getUser().getId() == user.getId()) {
				model.addAttribute("show", beltReviewerService.findShowById(id));
				return "edit.jsp";
			}
			else {
				return "redirect:/";
			}
		}
		
		@PostMapping("/addshow")
		public String addShow(@Valid @ModelAttribute("showObj") Show show, BindingResult result, HttpSession session) {
			if(result.hasErrors()) {
				return "newshow.jsp";
			}
			else {
				beltReviewerService.addShow(show);
				return "redirect:/shows";	
			}	
		}
		
		@PutMapping("/shows/{id}/edit")
		public String editShow(@Valid @PathVariable("id") Long id, @ModelAttribute("show") Show show, BindingResult result, Model model, HttpSession session) {
			User user = beltReviewerService.findUserById((Long)session.getAttribute("userId"));
			if(beltReviewerService.findShowById(id).getUser().getId() == user.getId()) {
				if(result.hasErrors()) {
					model.addAttribute("show", beltReviewerService.findShowById(id));
					return "edit.jsp";
				}
				else {
					Show showEdit = beltReviewerService.findShowById(id);
					model.addAttribute("show", showEdit);
					model.addAttribute("user", user);
					show.setUser(user);
					show.setJoinedUsers(show.getJoinedUsers());
					beltReviewerService.updateShow(show);
					return "redirect:/shows";
				}
			}
			else {
				return "redirect:/";
			}
		}
		
		@RequestMapping("/shows/{id}/rate")
		public String rateShow(@PathVariable("id") Long id, HttpSession session) {
			User user = beltReviewerService.findUserById((Long) session.getAttribute("userId"));
			Show show = beltReviewerService.findShowById(id);
			List<User> attendees = show.getJoinedUsers();
			attendees.add(user);
			show.setJoinedUsers(attendees);
			beltReviewerService.updateUser(user);	
			return "redirect:/shows/{id}";
		}
		
	    @RequestMapping("/shows/{id}/cancel")
	    public String cancelShow(@PathVariable("id") Long id, HttpSession session) {
	    	User user = beltReviewerService.findUserById((Long) session.getAttribute("userId"));
			Show show = beltReviewerService.findShowById(id);
	    	List<User> attendees = show.getJoinedUsers();
	        for(int i=0; i<attendees.size(); i++) {
	            if(attendees.get(i).getId() == user.getId()) {
	            	attendees.remove(i);
	            }
	        }
	        show.setJoinedUsers(attendees);
	        beltReviewerService.updateUser(user);
	    	return "redirect:/shows";
	    }
	    
	    @RequestMapping("/shows/{id}/delete")
	    public String delete(@PathVariable("id") Long id) {
	    	Show show = beltReviewerService.findShowById(id);
	    	for(User user: show.getJoinedUsers()) {
	    		List<Show> myshows = user.getJoinedshows();
	    		myshows.remove(show);
	    		user.setJoinedshows(myshows);;
	    		beltReviewerService.updateUser(user);
	    	}

	    	beltReviewerService.deleteEvent(id);
	    	return "redirect:/shows";
	    }
		
		@PostMapping("shows/addrating")
		public String addRating(@ModelAttribute("ratingObj") Rating rating, Model model, HttpSession session) {
			User user = beltReviewerService.findUserById((Long) session.getAttribute("userId"));
			model.addAttribute("user", user);
			beltReviewerService.newRating(rating);
			return "redirect:/shows";
			
		}
		
	
}
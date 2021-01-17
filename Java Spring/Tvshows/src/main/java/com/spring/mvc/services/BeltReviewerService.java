package com.spring.mvc.services;

import java.util.List;
import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;

import com.spring.mvc.models.Show;
import com.spring.mvc.models.Rating;
import com.spring.mvc.models.User;
import com.spring.mvc.repositories.ShowRepo;
import com.spring.mvc.repositories.RatingRepo;
import com.spring.mvc.repositories.UserShowRepo;
import com.spring.mvc.repositories.UserRepo;

@Service
public class BeltReviewerService {
	private final UserRepo userRepo;
	private final ShowRepo showRepo;
	private final UserShowRepo userShowRepo;
	private final RatingRepo ratingRepo;
	
	public BeltReviewerService(UserRepo userRepo, ShowRepo showRepo, UserShowRepo userShowRepo, RatingRepo ratingRepo) {
		this.userRepo = userRepo;
		this.showRepo = showRepo;
		this.userShowRepo = userShowRepo;
		this.ratingRepo = ratingRepo;
	}
	
	public void deleteEvent(Long id) {
		showRepo.deleteById(id);
	}
	
    public List<Show> allShows() {
    	return (List<Show>) showRepo.findAll();
    }
	
	public Show addShow(Show show) {
		return showRepo.save(show);
	}
	
	public Rating addRating(Rating rating) {
		return ratingRepo.save(rating);
	}
	
    public User registerUser(User user) {
        String hashed = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt());
        user.setPassword(hashed);
        return userRepo.save(user);
    }
    
    public User findByEmail(String email) {
        return userRepo.findByEmail(email);
    }
    
    public User findUserById(Long id) {
    	Optional<User> u = userRepo.findById(id);
    	if(u.isPresent()) {
            return u.get();
    	}
    	else {
    	    return null;
    	}
    }
    
    public Show findShowById(Long id) {
    	Optional<Show> e = showRepo.findById(id);
    	if(e.isPresent()) {
            return e.get();
    	}
    	else {
    	    return null;
    	}
    }
    
    public void updateShow(Show show) {
    	showRepo.save(show);
    }
    
    public void updateUser(User user) {
        userRepo.save(user);
    }
    
    public void updateRating(Rating rating) {
    	ratingRepo.save(rating);
    }
    
    public void newRating(Rating rating) {
        ratingRepo.save(rating);
    }
    
    //Authentication
    public boolean authenticateUser(String email, String password) {
        User user = userRepo.findByEmail(email);
        if(user == null) {
            return false;
        }
        else {
            if(BCrypt.checkpw(password, user.getPassword())) {
                return true;
            }
            else {
                return false;
            }
        }
    }
    
    public boolean duplicateUser(String email) {
        User user = userRepo.findByEmail(email);
        if(user == null) {
            return false;
        }
        else {
        	return true;
        }
    }
    
    public boolean unique(String title) {
        Show show = showRepo.findByTitle(title);
        if(show == null) {
            return false;
        }
        else {
        	return true;
        }
    }
}
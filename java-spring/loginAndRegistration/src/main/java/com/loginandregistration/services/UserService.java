package com.loginandregistration.services;

import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.loginandregistration.models.LoginUser;
import com.loginandregistration.models.User;
import com.loginandregistration.repositories.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepo;
	
	
	public User register(User newUser, BindingResult result) {
    	// TO-DO - Reject values or register if no errors:
        
        // Reject if email is taken (present in database)
		Optional<User> optionalUser = userRepo.findByEmail(newUser.getEmail());
		
		if(optionalUser.isPresent()) {
			result.rejectValue("email", "unique", "This email is already taken" );
		}
        // Reject if password doesn't match confirmation
        if(!newUser.getPassword().equals(newUser.getConfirm())) {
        	result.rejectValue("confirm", "Matches", "The Confirm Password must match Password!");
        }
        // Return null if result has errors
        if(result.hasErrors()) {
        	return null;
        }
        // Hash and set password, save user to database
        String hashed = BCrypt.hashpw(newUser.getPassword(), BCrypt.gensalt());
        newUser.setPassword(hashed);
        return userRepo.save(newUser);
        
	 }
	
    public User login(LoginUser newLoginObject, BindingResult result) {
	    // TO-DO - Reject values:
	    
		// Find user in the DB by email
    	Optional<User> potentialUser = userRepo.findByEmail(newLoginObject.getEmail());
    	// Reject if NOT present
    	if(!potentialUser.isPresent()) {
    		result.rejectValue("email", "unique", "This email is not registered" );
    		return null;
    	}
	    // Reject if BCrypt password match fails
    	User user = potentialUser.get();
    	if(!BCrypt.checkpw(newLoginObject.getPassword(), user.getPassword())) {
    		result.rejectValue("password", "Matches", "Invalid password" );
    	}
	    // Return null if result has errors
	    if(result.hasErrors()) {
	    	return null;
	    }
    	// Otherwise, return the user object
    	return user;
    }
	
}

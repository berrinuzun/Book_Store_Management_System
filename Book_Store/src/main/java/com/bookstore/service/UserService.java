package com.bookstore.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookstore.entity.Book;
import com.bookstore.entity.User;
import com.bookstore.repository.UserRepository;

@Service
public class UserService {

	@Autowired
    private UserRepository userRepository;

    public boolean authenticate(String username, String password) {
        
    	Optional<User> userOptional = userRepository.findByUsername(username);
        
    	if (userOptional.isPresent()) {
            
    		User user = userOptional.get();
            return user.getPassword().equals(password);
            
        }
    	
        return false;
    }
    
    public User getUserByUsername(String username) {
    	
    	return userRepository.findByUsername(username).get();
    	
    }
    
	
}

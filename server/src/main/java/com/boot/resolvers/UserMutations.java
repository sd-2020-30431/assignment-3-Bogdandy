package com.boot.resolvers;

import java.util.List;

import org.springframework.stereotype.Component;

import com.boot.entities.*;
import com.boot.repositories.*;
import com.coxautodev.graphql.tools.GraphQLMutationResolver;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class UserMutations implements GraphQLMutationResolver {
    private final UserRepository userRepository;
    
    public User newUser(String username, String password, String email, String phoneNumber) {
    	final User user = new User();
    	
    	user.setUsername(username);
    	user.setPassword(password);
    	user.setEmail(email);
    	user.setPhone(phoneNumber);
    	try {
    		userRepository.save(user);
    	}catch(Exception ex) {
    		return null;
    	}
        return user;
    }
    
    public Long deleteUser(String username) {
    	final List<User> users= (List<User>) userRepository.findAll();
    	
    	for (User user : users) {
            if (user.getUsername().equals(username)) {
            	userRepository.delete(user);
            	return user.getId();
            }
        }
    	
    	return null;
    }
}
package com.boot.resolvers;

import com.boot.entities.User;
import com.boot.repositories.UserRepository;

import java.util.List;

import lombok.RequiredArgsConstructor;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserQuery implements GraphQLQueryResolver {

    private final UserRepository UserRepository;
    
    public Iterable<User> users() {
        return UserRepository.findAll();
    }
    
    public User findUser(String username, String password) {
    	final List<User> users = (List<User>) UserRepository.findAll();
    	
    	User user = users.stream()
        	      .filter(e -> e.getUsername().contentEquals(username) && e.getPassword().contentEquals(password) )
        	      .findAny().orElse(null);
    	
    	return user;
    }
}
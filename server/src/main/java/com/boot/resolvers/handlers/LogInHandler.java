package com.boot.resolvers.handlers;


import java.util.List;

import org.springframework.stereotype.Component;

import com.boot.entities.User;
import com.boot.repositories.UserRepository;
import com.boot.resolvers.requests.LogInQuery;
import com.boot.resolvers.responses.LogInResponse;

import lombok.RequiredArgsConstructor;


@Component
@RequiredArgsConstructor
public class LogInHandler  implements IHandler<LogInQuery, LogInResponse>{
    private final UserRepository userRepository;
    
	@Override
	public LogInResponse Handle(LogInQuery q) {
		final List<User> users = (List<User>) userRepository.findAll();
    	
    	User user = users.stream()
        	      .filter(e -> e.getUsername().contentEquals(q.getUsername()) && e.getPassword().contentEquals(q.getPassword()) )
        	      .findAny().orElse(null);
    	
		return new LogInResponse(user);
	}
}


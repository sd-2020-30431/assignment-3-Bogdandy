package com.boot.resolvers.handlers;

import org.springframework.stereotype.Component;

import com.boot.entities.User;
import com.boot.repositories.UserRepository;
import com.boot.resolvers.requests.NewUserRequest;
import com.boot.resolvers.responses.NewUserResponse;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class NewUserHandler implements IHandler<NewUserRequest, NewUserResponse>{
    private final UserRepository userRepository;
    
	@SuppressWarnings("finally")
	@Override
	public NewUserResponse Handle(NewUserRequest q) {
		User user = new User();
    	
    	user.setUsername(q.getUsername());
    	user.setPassword(q.getPassword());
    	user.setEmail(q.getEmail());
    	user.setPhone(q.getPassword());
    	
    	try {
    		userRepository.save(user);
    	}catch(Exception ex) {
    		user =  null;
    	}
    	finally {
    		return new NewUserResponse(user);
    	}
	}

}

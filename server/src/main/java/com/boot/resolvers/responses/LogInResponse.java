package com.boot.resolvers.responses;

import com.boot.entities.User;

public class LogInResponse implements IResponse{
	private User user;
	
	public LogInResponse(User user) {
		this.user = user;
	}
	
	public User getUser() {
		return user;
	}
}

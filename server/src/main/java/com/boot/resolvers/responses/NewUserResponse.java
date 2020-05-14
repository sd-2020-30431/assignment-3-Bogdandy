package com.boot.resolvers.responses;

import com.boot.entities.User;

public class NewUserResponse implements IResponse{
	private User user;
	
	public NewUserResponse(User user) {
		this.user = user;
	}
	
	public User getUser() {
		return user;
	}
}

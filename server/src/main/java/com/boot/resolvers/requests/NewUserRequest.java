package com.boot.resolvers.requests;

import lombok.Data;

@Data
public class NewUserRequest implements IRequest{
	private String username;
	private String password;
	private String email;
	private String phoneNumber;
	
	public NewUserRequest(String username, String password, String email, String phoneNumber) {
		this.username = username;
		this.password = password;
		this.email = email;
		this.phoneNumber = phoneNumber;
	}
}

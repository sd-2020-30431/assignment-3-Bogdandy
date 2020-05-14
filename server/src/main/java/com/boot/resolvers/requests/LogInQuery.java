package com.boot.resolvers.requests;

import lombok.Data;

@Data
public class LogInQuery implements IRequest{
	private String username;
	private String password;
	
	public LogInQuery(String username, String password) {
		this.username = username;
		this.password = password;
	}
}

package com.boot.resolvers.requests;

import lombok.Data;

@Data
public class DeleteItemMutation implements IRequest{
	private Long id;

	public DeleteItemMutation(Long id) {
		this.id = id;
	}
}

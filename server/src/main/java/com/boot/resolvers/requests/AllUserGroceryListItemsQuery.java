package com.boot.resolvers.requests;

import lombok.Data;

@Data
public class AllUserGroceryListItemsQuery implements IRequest{
	private Long idUserList;
	
	public AllUserGroceryListItemsQuery(Long idUserList) {
		this.idUserList = idUserList;
	}
}

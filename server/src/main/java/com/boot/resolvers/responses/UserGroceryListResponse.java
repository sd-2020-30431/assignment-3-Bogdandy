package com.boot.resolvers.responses;

import com.boot.entities.GroceryItem;

public class UserGroceryListResponse implements IResponse{
	private Iterable<GroceryItem> userGroceryList;
	
	public UserGroceryListResponse(Iterable<GroceryItem> userGroceryList) {
		this.userGroceryList = userGroceryList;
	}
	
	public Iterable<GroceryItem> getUserGroceryList() {
		return userGroceryList;
	}
}

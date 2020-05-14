package com.boot.resolvers.responses;

import com.boot.entities.GroceryItem;

public class AllUserGroceryListItemsResponse implements IResponse{
	private Iterable<GroceryItem> userGroceryListItems;
	
	public AllUserGroceryListItemsResponse(Iterable<GroceryItem> userGroceryListItems) {
		this.userGroceryListItems = userGroceryListItems;
	}
	
	public Iterable<GroceryItem> getAllUserGroceryListItems() {
		return userGroceryListItems;
	}
}

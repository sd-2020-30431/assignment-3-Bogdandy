package com.boot.resolvers.responses;

import com.boot.entities.GroceryItem;

public class NewGroceryItemResponse implements IResponse{
	private GroceryItem groceryItem;

	public NewGroceryItemResponse(GroceryItem groceryItem) {
		this.groceryItem = groceryItem;
	}
	
	public GroceryItem getNewGroceryItem() {
		return groceryItem;
	}
}

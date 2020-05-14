package com.boot.resolvers.responses;

import com.boot.entities.GroceryItem;

public class ModifyGroceryItemResponse implements IResponse{
	private GroceryItem groceryItem;

	public ModifyGroceryItemResponse(GroceryItem groceryItem) {
		this.groceryItem = groceryItem;
	}
	
	public GroceryItem getModifiedGroceryItem() {
		return groceryItem;
	}
}

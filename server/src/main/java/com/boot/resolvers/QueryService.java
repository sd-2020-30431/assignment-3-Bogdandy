package com.boot.resolvers;

import com.boot.entities.GroceryItem;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;

public interface QueryService extends GraphQLQueryResolver {
	Iterable<GroceryItem> userItems(Long idUserList, int listNo);
	Iterable<GroceryItem> userAllItems(Long idUserList);
	boolean searchItem(Long idUserList, int listNo, String itemName);
}

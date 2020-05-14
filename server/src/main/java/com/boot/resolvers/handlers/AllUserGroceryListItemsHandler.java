package com.boot.resolvers.handlers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.boot.entities.GroceryItem;
import com.boot.repositories.GroceryItemRepository;
import com.boot.resolvers.requests.AllUserGroceryListItemsQuery;
import com.boot.resolvers.responses.AllUserGroceryListItemsResponse;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class AllUserGroceryListItemsHandler implements IHandler<AllUserGroceryListItemsQuery, AllUserGroceryListItemsResponse>{
    private final GroceryItemRepository groceryItemRepository;

	@Override
	public AllUserGroceryListItemsResponse Handle(AllUserGroceryListItemsQuery q) {
		List<GroceryItem> groceryItems =  (List<GroceryItem>) groceryItemRepository.findAll();
		
		groceryItems = groceryItems.stream()
	        	      .filter(e -> e.getIdUserList() == q.getIdUserList())
	        	      .collect(Collectors.toList());
		
		return new AllUserGroceryListItemsResponse(groceryItems);
	}

}

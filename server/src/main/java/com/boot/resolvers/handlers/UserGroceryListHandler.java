package com.boot.resolvers.handlers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.boot.entities.GroceryItem;
import com.boot.repositories.GroceryItemRepository;
import com.boot.resolvers.requests.UserGroceryListQuery;
import com.boot.resolvers.responses.UserGroceryListResponse;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class UserGroceryListHandler implements IHandler<UserGroceryListQuery, UserGroceryListResponse>{
    private final GroceryItemRepository groceryItemRepository;
    
	@Override
	public UserGroceryListResponse Handle(UserGroceryListQuery q) {
		List<GroceryItem> groceryItems =  (List<GroceryItem>) groceryItemRepository.findAll();
        
        groceryItems = groceryItems.stream()
        	      .filter(e -> e.getIdUserList() == q.getIdUserList() && e.getListNo() == q.getListNo())
        	      .collect(Collectors.toList());
        
		return new UserGroceryListResponse(groceryItems);
	}

}

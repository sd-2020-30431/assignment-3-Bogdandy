package com.boot.resolvers.handlers;

import java.util.List;

import org.springframework.stereotype.Component;

import com.boot.entities.GroceryItem;
import com.boot.repositories.GroceryItemRepository;
import com.boot.resolvers.requests.SearchItemQuery;
import com.boot.resolvers.responses.SearchItemResponse;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class SearchItemHandler implements IHandler<SearchItemQuery, SearchItemResponse>{
    private final GroceryItemRepository groceryItemRepository;

	@Override
	public SearchItemResponse Handle(SearchItemQuery q) {
		final List<GroceryItem> groceryItems = (List<GroceryItem>) groceryItemRepository.findAll();
    	boolean successful = false;
		
    	GroceryItem groceryItem = groceryItems.stream()
        	      .filter(e -> e.getIdUserList() == q.getIdUserList() && e.getListNo() == q.getListNo() && e.getItemName().contentEquals(q.getItemName()) )
        	      .findAny().orElse(null);
    	
    	if(groceryItem != null) {
    		successful = true;
    	}
    	
    	return new SearchItemResponse(successful);
	}

}

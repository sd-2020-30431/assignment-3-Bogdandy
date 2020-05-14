package com.boot.resolvers.handlers;

import java.util.List;

import org.springframework.stereotype.Component;

import com.boot.entities.GroceryItem;
import com.boot.repositories.GroceryItemRepository;
import com.boot.resolvers.requests.ClearListMutation;
import com.boot.resolvers.responses.ClearListResponse;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class ClearListHandler implements IHandler<ClearListMutation, ClearListResponse>{
	private final GroceryItemRepository groceryItemRepository;
	
	@Override
	public ClearListResponse Handle(ClearListMutation q) {
		final List<GroceryItem> groceryItems= (List<GroceryItem>) groceryItemRepository.findAll();
    	boolean successful = false;
    	
    	for (GroceryItem groceryItem : groceryItems) {
            if (groceryItem.getIdUserList().equals(q.getIdUserL())
            		&& groceryItem.getListNo() == q.getListNo()) {
            	groceryItemRepository.delete(groceryItem);
            	successful = true;
            }
        }
    	
		return new ClearListResponse(successful);
	}

}

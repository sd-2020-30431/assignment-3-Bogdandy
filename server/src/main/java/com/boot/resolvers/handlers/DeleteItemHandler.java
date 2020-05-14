package com.boot.resolvers.handlers;

import org.springframework.stereotype.Component;

import com.boot.entities.GroceryItem;
import com.boot.repositories.GroceryItemRepository;
import com.boot.resolvers.requests.DeleteItemMutation;
import com.boot.resolvers.responses.DeleteItemResponse;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class DeleteItemHandler implements IHandler<DeleteItemMutation, DeleteItemResponse>{
	private final GroceryItemRepository groceryItemRepository;
	
	@Override
	public DeleteItemResponse Handle(DeleteItemMutation q) {
		final GroceryItem groceryItem= groceryItemRepository.findById(q.getId()).orElse(null);
		boolean successful = false;
    	
    	if(groceryItem != null) {
    		groceryItemRepository.delete(groceryItem);
    		successful = true;
    	}
		return new DeleteItemResponse(successful);
	}
	
}

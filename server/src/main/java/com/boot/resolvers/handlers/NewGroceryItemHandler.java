package com.boot.resolvers.handlers;

import org.springframework.stereotype.Component;

import com.boot.entities.GroceryItem;
import com.boot.repositories.GroceryItemRepository;
import com.boot.resolvers.requests.NewGroceryItemMutation;
import com.boot.resolvers.responses.NewGroceryItemResponse;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class NewGroceryItemHandler implements IHandler<NewGroceryItemMutation, NewGroceryItemResponse> {
	private final GroceryItemRepository groceryItemRepository;

	@SuppressWarnings("finally")
	@Override
	public NewGroceryItemResponse Handle(NewGroceryItemMutation q) {
		GroceryItem groceryItem = new GroceryItem();
    	
    	groceryItem.setIdUserList(q.getIdUserList());
    	groceryItem.setListNo(q.getListNo());
    	groceryItem.setItemName(q.getItemName());
    	groceryItem.setQuantity(q.getQuantity());
    	groceryItem.setCaloricValue(q.getCaloricValue());
    	groceryItem.setPurchaseDate(q.getPurchaseDate());
    	groceryItem.setConsumptionDate(q.getConsumptionDate());
    	groceryItem.setExpirationDate(q.getExpirationDate());
    	
    	try {
    		groceryItemRepository.save(groceryItem);
    	}catch(Exception ex) {
    		groceryItem =  null;
    	}
    	finally {
            return new NewGroceryItemResponse(groceryItem);
    	}
	}

}

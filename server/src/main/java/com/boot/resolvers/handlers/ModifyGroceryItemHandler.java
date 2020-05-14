package com.boot.resolvers.handlers;

import org.springframework.stereotype.Component;

import com.boot.entities.GroceryItem;
import com.boot.repositories.GroceryItemRepository;
import com.boot.resolvers.requests.ModifyGroceryItemMutation;
import com.boot.resolvers.responses.ModifyGroceryItemResponse;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class ModifyGroceryItemHandler implements IHandler<ModifyGroceryItemMutation, ModifyGroceryItemResponse>{
	private final GroceryItemRepository groceryItemRepository;

	@Override
	public ModifyGroceryItemResponse Handle(ModifyGroceryItemMutation q) {
		GroceryItem groceryItem = groceryItemRepository.findById(q.getId()).orElse(null);
    	
    	if(groceryItem!=null) {
    		groceryItem.setItemName(q.getItemName());
    		groceryItem.setQuantity(q.getQuantity());
    		groceryItem.setCaloricValue(q.getCaloricValue());
    		groceryItem.setPurchaseDate(q.getPurchaseDate());
    		groceryItem.setConsumptionDate(q.getConsumptionDate());
    		groceryItem.setExpirationDate(q.getExpirationDate());
    		groceryItemRepository.save(groceryItem);
    	}
    	
		return new ModifyGroceryItemResponse(groceryItem);
	}

}

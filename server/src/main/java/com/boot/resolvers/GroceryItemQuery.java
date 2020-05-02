package com.boot.resolvers;

import com.boot.entities.GroceryItem;
import com.boot.repositories.GroceryItemRepository;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Component;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class GroceryItemQuery implements QueryService{
	
	private final GroceryItemRepository GroceryItemRepository;
    
    public Iterable<GroceryItem> items() {
        return GroceryItemRepository.findAll();
    }
    
    public Iterable<GroceryItem> userItems(Long idUserList, int listNo) {
        List<GroceryItem> groceryItems =  (List<GroceryItem>) GroceryItemRepository.findAll();
        
        groceryItems = groceryItems.stream()
        	      .filter(e -> e.getIdUserList() == idUserList && e.getListNo() == listNo)
        	      .collect(Collectors.toList());
        
		return groceryItems;
    }
    
    public Iterable<GroceryItem> userAllItems(Long idUserList) {
        List<GroceryItem> groceryItems =  (List<GroceryItem>) GroceryItemRepository.findAll();
        
        groceryItems = groceryItems.stream()
        	      .filter(e -> e.getIdUserList() == idUserList)
        	      .collect(Collectors.toList());
        
		return groceryItems;
    }
    
    public boolean searchItem(Long idUserList, int listNo, String itemName) {
    	final List<GroceryItem> groceryItems = (List<GroceryItem>) GroceryItemRepository.findAll();
    	
    	GroceryItem groceryItem = groceryItems.stream()
        	      .filter(e -> e.getIdUserList() == idUserList && e.getListNo() == listNo && e.getItemName().contentEquals(itemName) )
        	      .findAny().orElse(null);
    	
    	if(groceryItem != null) {
    		return true;
    	}else { 
    		return false;
    	}
    }
    
    
}

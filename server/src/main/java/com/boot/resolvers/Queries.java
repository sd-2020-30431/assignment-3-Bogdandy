package com.boot.resolvers;

import com.boot.entities.GroceryItem;
import com.boot.entities.User;
import com.boot.resolvers.handlers.*;
import com.boot.resolvers.requests.*;
import com.boot.resolvers.responses.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class Queries implements QueryService {
    private final Mediator mediator;
    
    public User findUser(String username, String password) {
    	LogInQuery command = new LogInQuery(username, password);
    	LogInHandler handler = (LogInHandler) mediator.<LogInQuery, LogInResponse>handle(command);
    	return handler.Handle(command).getUser();
    }
    
    public Iterable<GroceryItem> userItems(Long idUserList, int listNo) {
    	UserGroceryListQuery command = new UserGroceryListQuery(idUserList, listNo);
    	UserGroceryListHandler handler = (UserGroceryListHandler) mediator.<UserGroceryListQuery, UserGroceryListResponse>handle(command);
    	
		return handler.Handle(command).getUserGroceryList();
    }
    
    public Iterable<GroceryItem> userAllItems(Long idUserList) {
    	AllUserGroceryListItemsQuery command = new AllUserGroceryListItemsQuery(idUserList);
    	AllUserGroceryListItemsHandler handler = (AllUserGroceryListItemsHandler) mediator.<AllUserGroceryListItemsQuery, AllUserGroceryListItemsResponse>handle(command);
    	
		return handler.Handle(command).getAllUserGroceryListItems();
    }
    
    public boolean searchItem(Long idUserList, int listNo, String itemName) {
    	SearchItemQuery command = new SearchItemQuery(idUserList, listNo, itemName);
    	SearchItemHandler handler = (SearchItemHandler) mediator.<SearchItemQuery, SearchItemResponse>handle(command);
    	
		return handler.Handle(command).doesItemExist();
    }
}
package com.boot.resolvers;

import org.springframework.stereotype.Component;

import com.boot.entities.*;
import com.boot.resolvers.handlers.*;
import com.boot.resolvers.requests.*;
import com.boot.resolvers.responses.*;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class Mutations implements MutationService {
    private final Mediator mediator;
    
    public User newUser(String username, String password, String email, String phoneNumber) {
    	NewUserRequest command = new NewUserRequest(username, password, email, phoneNumber);
    	NewUserHandler handler = (NewUserHandler) mediator.<NewUserRequest, NewUserResponse>handle(command);
    	return handler.Handle(command).getUser();
    }

    public GroceryItem newGroceryItem(int listNo, Long idUserList, String itemName, int quantity, int caloricValue, String purchaseDate, String expirationDate, String consumptionDate) {
    	NewGroceryItemMutation command = new NewGroceryItemMutation(listNo, idUserList, itemName, quantity, caloricValue, purchaseDate, expirationDate, consumptionDate);
    	NewGroceryItemHandler handler = (NewGroceryItemHandler) mediator.<NewGroceryItemMutation, NewGroceryItemResponse>handle(command);
    	return handler.Handle(command).getNewGroceryItem();
    }
    
    public boolean deleteGroceryItem(Long id) {
    	DeleteItemMutation command = new DeleteItemMutation(id);
    	DeleteItemHandler handler = (DeleteItemHandler) mediator.<DeleteItemMutation, DeleteItemResponse>handle(command);
    	return handler.Handle(command).isDeletionSuccessful();
    }
    
    public GroceryItem modifyGroceryItem(Long id, String itemName, int quantity, int caloricValue, String purchaseDate, String expirationDate, String consumptionDate) {
    	ModifyGroceryItemMutation command = new ModifyGroceryItemMutation(id, itemName, quantity, caloricValue, purchaseDate, expirationDate, consumptionDate);
    	ModifyGroceryItemHandler handler = (ModifyGroceryItemHandler) mediator.<ModifyGroceryItemMutation, ModifyGroceryItemResponse>handle(command);
    	return handler.Handle(command).getModifiedGroceryItem();
    }
    
    public boolean clearList(Long idUserL, int listNo) {
    	ClearListMutation command = new ClearListMutation(idUserL, listNo);
    	ClearListHandler handler = (ClearListHandler) mediator.<ClearListMutation, ClearListResponse>handle(command);
    	return handler.Handle(command).isClearSuccessful();
    }
}
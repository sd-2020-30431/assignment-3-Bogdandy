package com.boot.resolvers;

import java.io.IOException;

import com.boot.entities.GroceryItem;
import com.coxautodev.graphql.tools.GraphQLMutationResolver;

public interface MutationService extends GraphQLMutationResolver{
	//CommandService
	GroceryItem newGroceryItem(int listNo, Long idUserList, String itemName, int quantity, int caloricValue, String purchaseDate, String expirationDate, String consumptionDate);
	GroceryItem modifyGroceryItem(Long id, String itemName, int quantity, int caloricValue, String purchaseDate, String expirationDate, String consumptionDate) throws IOException;
	boolean deleteGroceryItem(Long id);
	boolean clearList(Long idUserL, int listNo);
}

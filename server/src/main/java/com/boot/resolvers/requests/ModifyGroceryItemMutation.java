package com.boot.resolvers.requests;

import lombok.Data;

@Data
public class ModifyGroceryItemMutation implements IRequest{
	private Long id;
	private String itemName;
	private int quantity;
	private int caloricValue;
	private String purchaseDate;
	private String expirationDate;
	private String consumptionDate;
	
	public ModifyGroceryItemMutation(Long id, String itemName, int quantity, int caloricValue,
			String purchaseDate, String expirationDate, String consumptionDate) {
		this.id = id;
		this.itemName = itemName;
		this.quantity = quantity;
		this.caloricValue = caloricValue;
		this.purchaseDate = purchaseDate;
		this.expirationDate = expirationDate;
		this.consumptionDate = consumptionDate;
	}
}

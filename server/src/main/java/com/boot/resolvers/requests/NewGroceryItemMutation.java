package com.boot.resolvers.requests;

import lombok.Data;

@Data
public class NewGroceryItemMutation implements IRequest{
	private int listNo;
	private Long idUserList;
	private String itemName;
	private int quantity;
	private int caloricValue;
	private String purchaseDate;
	private String expirationDate;
	private String consumptionDate;
	
	public NewGroceryItemMutation(int listNo, Long idUserList, String itemName, int quantity, int caloricValue,
			String purchaseDate, String expirationDate, String consumptionDate) {
		this.listNo = listNo;
		this.idUserList = idUserList;
		this.itemName = itemName;
		this.quantity = quantity;
		this.caloricValue = caloricValue;
		this.purchaseDate = purchaseDate;
		this.expirationDate = expirationDate;
		this.consumptionDate = consumptionDate;
	}
}

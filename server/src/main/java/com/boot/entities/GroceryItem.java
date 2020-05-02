package com.boot.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="grocerylist")
public class GroceryItem {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "ListNo")
	private int listNo;

	@Column(name = "idUserList")
	private Long idUserList;

	@Column(name = "ItemName")
	private String itemName;

	@Column(name = "Quantity")
	private int quantity;

	@Column(name = "CaloricValue")
	private int caloricValue;

	@Column(name = "PurchaseDate")
	private String purchaseDate;

	@Column(name = "ExpirationDate")
	private String expirationDate;

	@Column(name = "ConsumptionDate")
	private String consumptionDate;
	
}
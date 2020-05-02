package com.boot.repositories;

import org.springframework.data.repository.CrudRepository;

import com.boot.entities.GroceryItem;

public interface GroceryItemRepository extends CrudRepository<GroceryItem, Long>{
	
}

package chapter010.practice02.service;


import java.util.List;

import chapter010.practice02.entity.Item;

public interface InventoryService {
	void addItem(Item item);
	void updateItemPrice(String itemId, int newPrice);
	void deleteItem(String itemId);
	List<Item> getItemByCategory(String category);
	

}

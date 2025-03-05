package chapter010.practice02.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import chapter010.practice02.entity.Item;
import chapter010.practice02.repository.ItemRepository;


public class InventoryServiceImpl implements InventoryService {
	private final ItemRepository repository;
	
	public InventoryServiceImpl(ItemRepository repository) {
		this.repository = repository;
	}

	@Override
	public void addItem(Item item) {
		repository.addItem(item);
	}

	@Override
	public void updateItemPrice(String itemId, int newPrice) {
		Item item = repository.findById(itemId);
		
		if(item != null) {
			item.setPrice(newPrice);
		}
	}

	@Override
	public void deleteItem(String itemId) {
		Item item = repository.findById(itemId);
		
		if (item != null) {
			repository.removeItem(itemId);
		}
	}

	@Override
	public List<Item> getItemByCategory(String category) {
		Set<Item> allItems = repository.findAll();
		List<Item> categoryItems = new ArrayList<Item>();
		
		for(Item item: allItems) {
			if(item.getCategory().equalsIgnoreCase(category)) {
				categoryItems.add(item);
			}
		}
		return null;
	} // Impl : Implement

}

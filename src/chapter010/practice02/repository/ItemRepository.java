package chapter010.practice02.repository;

import java.util.Set;

import chapter010.practice02.entity.Item;

public interface ItemRepository {
	void addItem(Item item);
	void removeItem(String itemId);
	Item findById(String itemId);
	Set<Item> findAll();

}

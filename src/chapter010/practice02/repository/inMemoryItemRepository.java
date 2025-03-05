package chapter010.practice02.repository;

import java.util.HashSet;
import java.util.Set;

import chapter010.practice02.entity.Item;

// DB 대신하는 저장소 역할

public class inMemoryItemRepository implements ItemRepository{
	private Set<Item> items = new HashSet<Item>();

	@Override
	public void addItem(Item item) {
		items.add(item);
	}

	@Override
	public void removeItem(String itemId) {
		Item target = null;
		
		for (Item item: items) {
			if(item.getId().equals(itemId)) {
				target = item; // 제거하고자 하는 요소를 저장
				break;
			}
		}
		
		if (target != null) {
			items.remove(target);
		}
	}

	@Override
	public Item findById(String itemId) {
		for(Item item: items) {
			if(item.getId().equals(itemId)) {
				return item;
			}
		}
		
		return null; // 객체 타입(참조 타입)의 기본 형태는 null
	}

	@Override
	public Set<Item> findAll() {
		
		return items;
	}

}

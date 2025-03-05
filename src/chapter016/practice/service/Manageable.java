package chapter016.practice.service;

import java.util.List;

import chapter016.practice.entity.Category;
import chapter016.practice.entity.Item;

public interface Manageable {
	List<Item> searchByCategory(Category category);

}

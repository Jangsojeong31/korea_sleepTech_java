package chapter016.practice.service;

import java.util.ArrayList;
import java.util.List;

import chapter016.practice.entity.Book;
import chapter016.practice.entity.Category;
import chapter016.practice.entity.Item;

public class LibraryManager implements Manageable{
	
	// 데이터 저장소(repository) 역할
	private List<Item> items = new ArrayList<Item>();
	
	public LibraryManager() {
		items.add(new Book("1", "자바", "책1", "이승아", "코리아", Category.FANTASY));
		items.add(new Book("1", "자바", "책1", "이승아", "코리아", Category.FICTION));
		items.add(new Book("1", "자바", "책1", "이승아", "코리아", Category.HISTORY));
		items.add(new Book("1", "자바", "책1", "이승아", "코리아", Category.NONFICTION));
		items.add(new Book("1", "자바", "책1", "이승아", "코리아", Category.SCIENCE));
		items.add(new Book("1", "자바", "책1", "이승아", "코리아", Category.FANTASY));
		items.add(new Book("1", "자바", "책1", "이승아", "코리아", Category.SCIENCE));
		items.add(new Book("1", "자바", "책1", "이승아", "코리아", Category.HISTORY));
		items.add(new Book("1", "자바", "책1", "이승아", "코리아", Category.HISTORY));
	}

	@Override
	public List<Item> searchByCategory(Category category) {
		List<Item> result = null;
		try {
			for(Item item: items) {
				if(item instanceof Book && ((Book) item).getCategory() == category) {
					result.add(item);
					
				}
			}
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
		// TODO Auto-generated method stub
		return null;
	}

}

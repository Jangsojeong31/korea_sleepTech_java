package chapter012.controller;

// 추가, 조회, 검색 등의 기능

import java.util.ArrayList;
import java.util.List;

import chapter012.model.Book;

public class BookController {
	private List<Book> books;
	
	public BookController() {
		this.books = new ArrayList<>();
	}
	
	// 1. 책 추가
	public void addBook(String title, String author, String publisher) {
		Book newbook = new Book(title, author, publisher);
		books.add(newbook);
	}	
	// 2. 전체 책 조회
	public List<Book> getAllBooks() {
		return books;
	}
	
	// 3. 책 검색 - 책 제목
	
	public List<Book> searchBook(String title){  // 요청 값이 필요함 -> 매개변수
		List<Book> result = new ArrayList<Book>();
		
		for(Book book: books) {
			if(book.getTitle().contains(title)) {
				result.add(book);
			}
		}
		
		return result;
	}
	

}

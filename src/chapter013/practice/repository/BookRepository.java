package chapter013.practice.repository;

import java.util.ArrayList;
import java.util.List;

import chapter013.practice.model.Book;

// 도서 저장, 검색 및 삭제하는 데이터 저장소
public class BookRepository {
	private List<Book> books = new ArrayList<>();

	// 도서 저장
	public Book save(Book book) {
		// 중복된 id 값일 경우 도서 저장 하지 않기
		if (findById(book.getId()) != null) {
			System.out.println("Id " + book.getId() + " 책이 이미 존재합니다.");
			return null;
		}
		books.add(book);
		return book;
	}
	// 도서 삭제
	public void deleteById(int id) {
		if(findById(id) != null) {
			for (Book book: books) {
				if (book.getId() == id) {
					books.remove(book);
					return;
			
				}
			}
		}
		
		System.out.println(id + "의 책이 존재하지 않습니다. 책이 삭제되지 않았습니다.");
	}
	
	// 도서 조회(단건)
	public Book findById(int id) {
		for (Book book: books) {
			if(book.getId() == id) {
				return book;
			}
		}
		
		return null; // 해당하는 id의 책이 없을 경우
	}
	
	// 도서 조회(전체)
	public List<Book> findAll() {
		return books;
	}
}

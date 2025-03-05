package chapter013.practice.service;

import java.util.List;

import chapter013.practice.model.Book;
import chapter013.practice.repository.BookRepository;

// 비즈니스 로직 처리 - 싱글톤 패턴 구현

public class BookServiceImpl implements BookManager<Book> {
	private static BookServiceImpl instance; // 싱글톤 
	private final BookRepository repository = new BookRepository();
	
	private BookServiceImpl() {}
	
	public static BookServiceImpl getInstance() {
		if(instance == null) {
			instance = new BookServiceImpl();
		}
		return instance;
	}

	@Override
	public void addBook(Book book) {
		// TODO Auto-generated method stub
		Book addedBook = repository.save(book);
		
		if(addedBook == null) {
			System.out.println("해당 id의 값이 존재하여 책이 추가되지 않았습니다.");
		}else {
			System.out.println(book.getTitle() + "(이)가 추가되었습니다.");
		}		
	}

	@Override
	public List<Book> listAllBooks() {
		return repository.findAll();
	}

	@Override
	public Book findBookById(int id) {
		Book book = repository.findById(id);
		if(book == null) {
			System.out.println(id + "에 해당하는 도서를 찾을 수 없습니다.");
		}
		return book;
	}

	@Override
	public void updateBook(int id, Book updateBook) {
		Book existingBook = repository.findById(id);
		
		if(existingBook == null) {
			System.out.println(id + "에 해당하는 도서를 찾을 수 없습니다.");
			return;
		}
		
		repository.deleteById(id); // 기존 도서 삭제
		addBook(updateBook); // update된 도서 추가
		repository.save(updateBook); 
		
	}

	@Override
	public void removeBook(int id) {
		Book existingBook = repository.findById(id);
		if(existingBook == null) {
			System.out.println(id + "에 해당하는 도서를 찾을 수 없습니다.");
			return;
		}
		
		repository.deleteById(id);
		System.out.println(existingBook.getTitle() + "이(가) 삭제되었습니다.");
	}
	

}

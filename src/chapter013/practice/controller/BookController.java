package chapter013.practice.controller;

import java.util.List;

import chapter013.practice.model.Book;
import chapter013.practice.service.BookServiceImpl;
import chapter013.practice.view.BookView;

// 사용자의 요청 처리
// view 와 service를 연결
public class BookController {
	
	private final BookServiceImpl service = BookServiceImpl.getInstance(); // 싱글톤 패턴으로 인스턴스화
	private final BookView view = new BookView();
	
	public void start() {
		while(true) {
			view.showMenu();
			int choice = view.getInput(); // 숫자값을 검증해서 가져오는 메서드
			
			switch(choice){
				case 1: 
					Book book = view.getBookDetails();
					if(book != null) service.addBook(book);// 책 추가 : 매개변수(요청 값) O, 반환 값 x
					else System.out.println("필수 데이터값을 다시 확인하세요.");
					break;
				case 2: // 전체 조회 : 요청 데이터 x, 반환 값 o
					List<Book> books = service.listAllBooks();
					view.displayBooks(books); // 반환 데이터를 view에 전달
					break;
				case 3: // 단건 조회 : 요청 데이터 o, 반환 값 o
					int findBookId = view.getInput();
					if(findBookId != -1) {
						Book foundBook = service.findBookById(findBookId);
						view.displayBook(foundBook);
						
					}else {
						System.out.println("유효하지 않은 id입니다.");
					}
					break;
				case 4: // 책 수정 : 요청 데이터 o, 반환 값 x
					int modifiedId = view.getInput();
					if(modifiedId != -1) {
						Book updatedBook = view.getBookDetails();
						if(updatedBook != null) {
							service.updateBook(modifiedId, updatedBook);
						}else {
							System.out.println("도서 정보가 유효하지 않습니다.");
						}
					}else {
						System.out.println("유효하지 않은 id입니다.");
					}
					break;
				case 5: // 제거
					int removedId = view.getInput();
					if(removedId != -1) service.removeBook(removedId);
					else System.out.println("유효하지 않은 id입니다.");
					break;
				case 0:
					System.out.println("프로그램 종료");
					return; 
				default:
					System.out.println("잘못된 입력입니다. 다시 입력해주세요.");
					break;
			}
		}
	}

}

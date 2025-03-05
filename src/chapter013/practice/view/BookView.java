package chapter013.practice.view;

import java.util.List;
import java.util.Scanner;

import chapter013.practice.model.Book;
import chapter013.practice.model.Fiction;

public class BookView {
	private final Scanner sc = new Scanner(System.in);
	
	public void showMenu() { 
		System.out.println("=== 도서관리시스템 ===");
		System.out.println("1. 도서 추가");
		System.out.println("2. 도서 전체 조회");
		System.out.println("3. 도서 단건 조회");
		System.out.println("4. 도서 수정");
		System.out.println("5. 도서 삭제");
		System.out.println("0. 종료 ");
		System.out.print("선택 >> ");
	}
	
	// 사용자 입력 값에 대한 유효성 검증 로직 추가
	// - 프로세스 로직(데이터) 입력값
	public int getInput() {
		int choice;
		try { 
			choice = sc.nextInt(); // int 값으로 입력하지 않으면 아래 예외 실행
		} catch (Exception e) {
			System.out.println("잘못된 입력입니다. 숫자를 입력하세요");
			sc.nextLine();
			return -1;
		}
		return choice;  // int 값 반환
	}
	
	public Book getBookDetails() {
		System.out.println("도서 ID : ");
		int id = getInput();
		if(id == -1) return null;
		
		// 정상적으로 id 값이 입력된 경우(정수값) - nextInt의 버퍼 처리
		sc.nextLine();
		
		System.out.println("제목: ");
		String title = sc.nextLine().trim(); // 양 끝 공백 제거
		if(title.isEmpty()) {
			System.out.println("제목은 비어있을 수 없습니다.");
			return null;
		}
		
		System.out.println("저자: ");
		String author = sc.nextLine().trim(); // 양 끝 공백 제거
		if(author.isEmpty()) {
			System.out.println("저자 비어있을 수 없습니다.");
			return null;
		}
		
		System.out.println("1. Fiction / 2. NonFiction");
		int type = getInput();
		if (type == -1) return null;
		sc.nextLine(); // 정상적으로 id 값이 입력된 경우(정수값) - nextInt의 버퍼 처리
		
		if(type == 1) {  // Fiction 선택
			System.out.println("장르: ");
			String genre = sc.nextLine().trim(); // 양 끝 공백 제거
			if(genre.isEmpty()) {
				System.out.println("장르는 비어있을 수 없습니다.");
				return null;
			}
			
			return new Fiction(id, title, author, genre);
			
		}else if(type == 2) {  // Nonfiction 선택
			System.out.println("분야: "); 
			String field = sc.nextLine().trim(); // 양 끝 공백 제거
			if(field.isEmpty()) {
				System.out.println("분야는 비어있을 수 없습니다.");
				return null;
			}
			
			return new Fiction(id, title, author, field);
			
		}else {
			System.out.println("잘못된 선택입니다. 1 또는 2를 입력하세요.");
			return null;
		}
	}
	
	public void displayBooks(List<Book> books) {  // 전체 조회
		if(books.isEmpty()) {
			System.out.println("등록된 도서가 없습니다.");
		}else {
			for(Book book: books) {
				System.out.println(book.toString());  //toString 생략 가능
			}
		}
	}
	
	public void displayBook(Book book) { // 단건 조회
		if(book == null) {
			System.out.println("해당 도서를 찾을 수 없습니다.");
		}else {
			System.out.println(book);
		}
	
	}
	
	
}

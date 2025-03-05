package chapter007;

// === 도서 관리 시스템 === //
// : 책의 정보를 저장, 책의 상태(대여가능여부), 책의 정보 출력

// 1) Book 클래스
// : 속성) title(String, 불변성), author(String, 불변성), isAvailable(boolean)
// : 메서드) borrowBook(), returnBook(), diplayInfo()
// : 생성자) 매개변수 - title, author

class Book {
	// 속성
	private final String title;
	private final String author;
	private boolean isAvailable = true; // true : 대여 가능
	
	// final 키워드 - 생성자 주입 방식
	Book(String title, String author) {
		this.title = title;
		this.author = author;
	}
	
	// 매서드
	void borrowBook() {
		if (isAvailable) {  // true이면
			isAvailable = false;
			System.out.println("책 대여가 완료되었습니다.");
		}else {  //false이면
			System.out.println("현재 대여중입니다. 대여가 불가합니다.");
		}
	}
	
	void returnBook() {
		if(!isAvailable) { //isAvailable이 false이면 -> true 
			isAvailable = true;
			System.out.println("책이 반납되었습니다.");
		}else {
			System.out.println("이미 반납된 상태입니다.");
		}
	}
	
	// 책 정보 출력 메서드
	void displayInfo() {
		System.out.println("제목 : " + title + ", 저자 : " + author 
				+ ", 대여가능여부 : " + (isAvailable ? "대여가능" : "대여중"));
	}
	
	
	// 캡슐화를 위한 getter
	public String getTitle() { return title; }
	public String getauthor() { return author; }
	public boolean getisAvailable() { return isAvailable; }
	
}


// 2) EBook 클래스 : Book 상속받음
// 추가 속성) fileSize(double)
// 추가 메서드) displayInfo() - 재정의, fileSize()
// 생성자) EBook(title, author, fileSize)

class EBook extends Book{
	
	// 기본적으로
	// EBook() { super(); }가 생성되는데 (EBook의 빈 생성자)
	// Book에서 빈 생성자가 명시되지 않았기 때문에  
	// 오류가 발생 -> EBook에서 매개변수 생성자를 만들면 오류는 사라짐
	
	// 추가 속성 
	private double fileSize;
	
	// 생성자 
	
	EBook(String title, String author, double filesize){
		super(title, author);
		this.fileSize = filesize;
	}
	
	@Override
	void displayInfo() {
		super.displayInfo();
		System.out.println("파일 크기: " + fileSize + "MB");
	}
	
	double getFilesizes() { return fileSize; }
	
	
}


public class D_OOP_Prac {
	public static void main(String[] args) {
		Book book1 = new Book("역사의 쓸모", "최태성");
		book1.displayInfo();
		book1.borrowBook(); 
		book1.displayInfo();
		book1.borrowBook();
		
		book1.returnBook();
		book1.returnBook();
		
		book1.borrowBook();
		
		// EBook 객체 생성
		EBook ebook1 = new EBook("스위트 스팟", "샘 리처드", 131.23);
		ebook1.displayInfo(); 
		ebook1.borrowBook();
		
	}
}

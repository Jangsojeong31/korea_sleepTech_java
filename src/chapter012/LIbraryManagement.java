package chapter012;

import chapter012.view.BookView;

// < 도서 관리 시스템 >

// 1. 요구사항 분석
// - 새로운 도서 추가
// - 모든 도서 정보 출력
// - 도서 검색 (도서 제목으로 검색)

// 2. 프로그램 구조

//  Model(도서 정보를 담당)
//  : Book 클래스 - 도서 정보(제목, 저자, 출판사)

// View (사용자 인터페이스)
// : BookView 클래스 
// - 사용자로부터 입력을 받아 컨트롤러에게 전달, 컨트롤러에게 받은 정보를 출력

// Controller(사용자의 입력을 처리 - Model과 View 사이의 중재)
// : BookController 클래스 
// 	- 사용자의 입력에 따라 적절한 Model 메서드 호출

// 순서 : Book -> BookController -> BookView

public class LIbraryManagement {
	public static void main(String[] args) {
		BookView bookView = new BookView(); // 사용자와 상호작용하는 뷰만 인스턴스 생성
		bookView.showMenu();
		
		
	}
	
}

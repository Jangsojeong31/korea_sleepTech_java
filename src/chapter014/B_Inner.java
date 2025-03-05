package chapter014;

import lombok.AllArgsConstructor;
import lombok.Getter;

// == 학교 시스템 == // 

@AllArgsConstructor
@Getter
class School {
	private String schoolName;
	
	// 내부 클래스 - 학생
	@AllArgsConstructor // 필드값의 순서대로 매개변수 지정
	class Student {
		private int studentId;
		private String studentName;
		
		public void displayInfo() {
			System.out.println("학교명 : " + schoolName + ", 학생 이름: " + studentName);
		}
	}
	
	// 정적 내부 클래스 - 교장 선생님 (싱글톤 패턴)
	static class Principal {
		private static Principal instance;
		
		private Principal() {}
		
		public static Principal getInstance() { 
			if (instance == null) {
				instance = new Principal();
			}
			return instance;
		}
		
		public void displayInfo() {
			System.out.println("훈화 말씀 : 공부 열심히!");
		}
	}
	
	
}


public class B_Inner {
	public static void main(String[] args) {
		School school = new School("유성 초등학교");
		School.Student student1 = school.new Student(43, "이승아");
		student1.displayInfo(); // "학교명 : 유성 초등학교, 학생 이름: 이승아"
		
		School.Principal principal = School.Principal.getInstance(); // getInstance() 내부의 new 연산자 사용으로 new 생략 가능
		principal.displayInfo(); // "훈화 말씀 : 공부 열심히!"

	}

}

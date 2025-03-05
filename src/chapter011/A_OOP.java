package chapter011;

/*
 		OOP (객체 지향 프로그래밍)
 		
 		SOLID 원칙
 		: 객체 지향 프로그래밍의 5가지 소프트웨어 개발 원칙
 		- SRP, OCP, LSP, ISP, DIP
 		- 소프트웨어 설계에서 유지보수성과 확장성을 높임
 		- 다양한 디자인 패턴(Design Pattern)이 SOLID 설계 원칙에 따라 만들어짐
 		
 	 	SOLID 원칙 적용 시 주의점
 		- 적용 순서 x 
 		- 모두 필수 x
 		- 서로 독립적 개념 x / 개념적으로 연관 o
 		
 		cf) 상속, 추상화, 다형성, 캡슐화 등은 OOP의 4가지 특징!
 		
 		1) SRP : Single Responsibility Principle (단일 책임 원칙)
 			- 클래스는 단 하나의 책임만을 가져야 함
 			- 한 가지 역할(기능)만 담당
 			- 하나의 클래스가 가지는 하나의 역할과 관련된 변경사항만 클래스에 영향을 미쳐야 함
 			
 */
// 1) 잘못된 예제
class SchoolHelper {
	void cleanClassroom () {
		System.out.println("교실 청소");
	}
	
	void prepareLunch() {
		System.out.println("급식 준비");
	}
	
}

// 2) 올바른 예제 - 각각의 클래스가 역할을 담당
class Janitor {
	void cleanClassroom() {
		System.out.println("교실 청소");
	}	
}

class LunchStaff{
	void prepareLunch() {
		System.out.println("급식 준비");
	}
}

/*
 		2) 개방 폐쇄 원칙(OCP) : Open-Closed Principle
 			- 소프트웨어 엔티티(클래스, 모듈, 함수 등)는 확장에는 열려있어야 하고,
 				수정에는 닫혀있어야 한다.
			- 기존 코드는 변경하지 않고 새로운 기능을 추가할 수 있어야 함
			- 추상클래스와 인터페이스를 사용하여, 상속, 구현을 통한 클래스 관계 구축
			
 */
//1) 잘못된 예제 - 기존 코드에 대한 직접적인 수정
class LunchMenu {
	void serveLunch(String studentType) {
		if(studentType.equals("일반 학생")) {
			System.out.println("알레르기가 없음");
		}else if(studentType.equals("주의 학생")){
			System.out.println("알레르기에 주의");
			
		}
	}
}

//2) 올바른 예제 - 기존의 코드를 수정하지 않고 새로운 기능의 확장
interface LunchMenuInterface {
	void serveLunch();
}

class RegularStudent implements LunchMenuInterface {

	@Override
	public void serveLunch() {
		System.out.println("알레르기가 없음");
	}
	
}

class VegetableStudent implements LunchMenuInterface {

	@Override
	public void serveLunch() {
		System.out.println("채식 학생 - 샐러드 제공");
	}
	
}

class AllergyStudent implements LunchMenuInterface {

	@Override
	public void serveLunch() {
		System.out.println("알레르기가 없음");
	}
	
}

/*
 		3) 리스코프 치환 원칙(LSP) : Liskov Substitution Principle
 			- 상위 클래스의 객체를 하위 클래스의 객체로 치환하더라도 
 				프로그램의 동작이 일관되게 유지되어야 함
			- 자식 클래스는 부모 클래스의 기능을 완전하게 대체할 수 있음
			- 업캐스팅 상태에서 부모의 메서드 사용 시 동작 가능
			- 추상적인 메서드를 통해 하위 클래스에서 구체적인 기능의 선택이 가능하도록 설계
			
 */
// 잘못된 예
class Student {
	void playSoccer () {
		System.out.println("축구를 할 수 있습니다.");
	}
	
	
}

class InjuredStudent extends Student {
	void playSoccer () {
		// 부모의 메서드와 상충(부모가 가진 기능의 일관성 x)
		System.out.println("축구를 할 수 없습니다.");
	}
}

// 올바른 예
abstract class StudentAbstract {
	abstract void activity();
}

class SoccerPlayer extends StudentAbstract {

	@Override
	void activity() {
		System.out.println("축구를 할 수 있습니다.");
	}
	
}

class InjuredSoccerPlayer extends StudentAbstract {

	@Override
	void activity() {
		System.out.println("축구를 할 수 없습니다.");
	}
	
}
public class A_OOP {

}

package chapter008;

/*
  	추상화
  	
  	1. 추상 클래스 정의 
  		: 미완성 클래스(설계도), 완전하지 않은 클래스
  		>> 자체로 인스턴스를 생성할 수 없다. 
  		>> 다른 클래스가 상속받아 기능을 완성해야만 사용 가능
  		
  	2. 추상 클래스 특징
  		1) 클래스 자체로 인스턴스 생성 불가
  		2) 하나 이상의 '추상 메서드'를 포함해야 함
  		3) 확장성 제공을 위해 사용
  			: 자식 클래스가 공통된 기능을 공유 + 고유 기능을 구현하도록 '강제'
		4) 다중 상속이 불가
			: 하나의 extends만 가능
			
		+) 메서드 오버라이딩과 추상 메서드
			- 추상 메서드 : 반드시 오버라이딩되어야 함
			- 일반 메서드 : 필요에 따라 오버라이딩해도 되고 안해도 되고
			
	3. 추상 클래스 구현 방법
		: 클래스 선언 앞에 'abstract' 키워드
		
	4. 추상 메서드
		: 메서드의 선언부만 존재, 구현부({})는 없는 메서드
		> 자식 클래스에서 반드시 구현하도록 강제하기 위해
		> abstract 키워드 + {} 대신 ;를 사용하여 선언
		
		cf) 메서드 구성 : 선언부 + 구현부
			[접근 제어자] 반환타입 메서드명 (매개변수 ...) {구현부 - 기능}
			
 */

//abstract class Human {
//	abstract void work(); 
//}
//
//class Police extends Human {
//	// 추상 메서드 구현
//	void work() {
//		System.out.println("경찰은 치안유지 업무를 담당합니다.");
//	}
//}
//
//class Student extends Human {
//	void work() {
//		System.out.println("학생은 공부를 합니다.");
//	}
//}

// 다중 상속 불가 예시

abstract class Lion{
	abstract void mane();  //갈기
}
abstract class Tiger{
	abstract void stripe(); //줄무늬
}
class Liger extends Lion //extends Tiger -> 다중 상속 불가
{
	void mane() {
		
	}
}

// 추상 클래스 예시
abstract class Animal{
	// 추상 메서드
	abstract void makeSound();
	// 일반 메서드
	void eat() {
		System.out.println("동물은 먹이를 먹습니다.");
	}
}
class Dog extends Animal {
	void makeSound() {
		System.out.println("멍멍");
	}
	@Override
	void eat() {
		System.out.println("강아지는 개껌을 먹습니다.");
	}
}
class Cat extends Animal {
	void makeSound() {
		System.out.println("야옹");
	}
}


public class A_Abstract {
	public static void main(String[] args) {
	
	
//	Animal animal = new Animal();
	// => 추상 클래스로는 인스턴스화 불가
	
	Dog dog = new Dog();
	Cat cat = new Cat();
	
	dog.makeSound();
	dog.eat();
	
	cat.makeSound();
	cat.eat();
	
	}
	

}


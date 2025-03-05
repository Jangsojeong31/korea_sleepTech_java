package chapter007;

/*
 		자바에서의 형 변환
 		
 		1) 자료형 변환 : 변수 & 자료형에서의 '자동 형 변환(묵시적)', '강제 형 변환(명시적)'
 		
 		2) 클래스 타입 변환 : 자동 타입 변환(Upcasting), 강제 타입 변환(Downcasting)
 				- 자료형 변환보다 가능한 범위가 좁다. >> '상속 관계'에 있는 클래스 사이에서만 변환 가능
 				//cf) ?클래스 타입도 참조형 자료형의 일종?
 				1) 자동 타입 변환
 					: 자식 객체를 부모 클래스 타입으로 변환 
 					>> 직접 명시 x, 자동으로 타입 변환이 일어남
 					
 					1-1) 자식 객체를 생성하면서 즉시 부모 타입으로 변환하여 저장
 						: 부모 클래스 객체변수 = new 자식클래스();
 						
					1-2) 이미 생성된 객체를 이후 부모 타입으로 변환
						: 부모 클래스 객체 변수 = 자식객체변수;
						
				2) 강제 타입 변환 
					: 부모 클래스 타입으로 변환된 객체를 '다시' 자식 클래스 타입으로 변환
					- 자식타입 객체 변수 = (자식타입) 부모객체;
					
				cf) 클래스 타입 변환 시 주의점
					: 반드시 상속 관계에 있는 객체의 실제 타입을 확인
						잘못된 캐스팅은 오류 발생
 */

class Parent {
	void displayInfo() {
		System.out.println("부모 클래스입니다.");
	}
}

class Child extends Parent {
	@Override
	void displayInfo() {
		System.out.println("자식 클래스입니다. - 재정의");
	}
	
	void childMethod() {
		System.out.println("자식 클래스의 고유 메서드입니다.");
	}
}

public class E_Class_Type {
	public static void main(String[] args) {
	
		// 1) 자동 타입 변환(upcasting)
		// 1-1) 
		Parent childObject = new Child();
		childObject.displayInfo(); // 부모 클래스의 메서드는 실행됨 
//		childObject.childMethod(); => 오류 발생 : 자식 클래스만의 메서드는 실행 안됨 
									// 자동 형 변환의 경우 해당 객체는 보존되면서, 부모 객체처럼 사용
									// 두 클래스 만의 공통된 특성만 사용 가능
		
		// 1-2) 
		Child childObject2 = new Child();
		childObject2.displayInfo();  // 자식 클래스입니다. - 재정의
		childObject2.childMethod();  // 자식 클래스의 고유 메서드입니다.
		
		Parent parentObject = childObject2; // 업캐스팅
		parentObject.displayInfo();
//		parentObject.childMethod(); => 오류 
		
		
		//2) 강제 타입 변환(다운캐스팅)
		Child child = (Child) parentObject;
		child.displayInfo();
		child.childMethod();  // 두 메서드 모두 실행 가능
		
		
	}

}

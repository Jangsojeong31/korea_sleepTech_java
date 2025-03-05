package chapter014;

/*
 	내부 클래스 (Inner class, 중첩 클래스, Nested Class)
 		: 다른 클래스 내부에 선언된 클래스를 의미
 		
 	장점 
 		: 코드의 가독성이 향상 - 코드의 구조 파악이 용이
 		: 클래스 간의 관계를 명확하게 표현 - 내부 클래스는 외부 클래스의 멤버에 접근 가능
 		cf) 멤버 : 클래스의 필드, 메서드
 	종류
 		1) (비정적) 내부 클래스
 			: '외부 클래스의 인스턴스'에 속함
 				>> 외부 클래스의 인스턴스 변수 및 메서드에 직접 접근 x 
 				
 		2) 정적(static) 내부 클래스
 			: '외부 클래스의 정적 멤버'에 속함
 				>> 외부 클래스의 인스턴스 변수에 접근 x 
 				>> 외부 클래스의 정적 멤버에만 접근 o (외부 클래스의 인스턴스 생성 없이 인스턴스화 가능) 
 				
 		3) 메서드 내부 클래스 (지역 클래스)
 			: '메서드 내에서 정의된 내부 클래스'
 				>> 해당 메서드 내에서만 사용 가능
 				>> 메서드의 지역 변수에만 접근 가능
 				cf) 로컬 변수(외부 클래스의 멤버 변수)가 final 인 경우에만 접근 가능
 				
 		4) 익명 (내부) 클래스
 			: 이름이 없는 내부 클래스
 			: 주로 인터페이스나 추상 클래스의 구현에 사용
 				>> 즉시 객체 생성 가능
 				>> 주로 클래스를 일회성으로 사용하는 경우 
 */

class OuterClass {
	private String outerField = "외부 클래스의 (인스턴스) 필드";
	static String staticField = "외부 클래스의 정적 필드";
	
	// 1. (비정적) 내부 클래스 - 인스턴스 멤버처럼 사용(외부 클래스를 인스턴스화 해야지 생성 가능)
	class InnerClass {
		void display() {
			System.out.println("외부 클래스 필드에 접근: "+ outerField);
		}
	}
	
	// 2. 정적 내부 클래스 - 인스턴스화 없이 사용 가능
	static class StaticClass {
		void display() {
//			System.out.println("외부 클래스 필드에 접근: " + outerField); // 오류 -> 외부 클래스의 인스턴스 필드에 접근 불가
			System.out.println("외부 클래스의 정적 필드에 접근: " + staticField); // 클래스명. 을 생략하고 정적 필드 사용 가능
		}
	}
	
	// 3. 메서드 내부 클래스 (지역 클래스)
	void outerMethod() {
		String localVar = "메서드 로컬 변수1";
//		localVar = "변수값 변경";  - 지역 변수는 암묵적으로 final 로 간주(생략 가능 - 권장), 재할당 불가
		final String localFinalVar = "메서드 로컬 변수 (Final)";
		
		System.out.println("외부 클래스의 메서드를 호출");
		
		class MethodClass {  // 메서드 내부 클래스 (지역 클래스)
			void display() {
				System.out.println("로컬 변수에 접근(Final X): " + localVar);
				System.out.println("로컬 변수에 접근(Final O): " + localFinalVar);
			}
		}
		
		// 로컬 클래스의 인스턴스화 
		// : 메서드 내부에서만 사용되기 때문에 인스턴스화도 내부에서만 일어남 
		MethodClass methodClass = new MethodClass(); // 인스턴스화 
		methodClass.display(); // 외부 클래스의 메서드(outerMethod)를 호출하면 같이 호출됨
	}
}

// 추상 클래스: 하나 이상의 추상 메서드를 포함
abstract class AbstractClass {
	abstract void display(); // 추상 메서드
}

// 인터페이스
interface InterfaceClass {
	void something(); // public abstract 생략됨
}

public class A_Inner {
	public static void main(String[] args) {
		
		System.out.println("=== 비정적 내부 클래스 ===");
		// 1) 외부 클래스 인스턴스화
		OuterClass outerClass1 = new OuterClass();
		
		// 2) 외부 클래스. 내부 클래스 형식으로 내부 클래스 생성
		// 	: 외부 클래스 타입. 내부클래스타입 변수명 = 외부인스턴스.new 내부클래스();
		OuterClass.InnerClass innerClass = outerClass1.new InnerClass(); // outerClass1.필드명 과 유사한 접근
		
		innerClass.display(); // "외부 클래스 필드에 접근: 외부 클래스의 (인스턴스) 필드"
		
		System.out.println("=== 정적 내부 클래스 ===");
		// 1) 외부 클래스 인스턴스화 없이, 클래스를 사용한 내부 클래스 생성 가능 (static의 특징)
		// 	: 외부클래스타입.내부클래스타입 변수명 = new 외부클래스명.내부클래스();
		OuterClass.StaticClass staticClass = new OuterClass.StaticClass();
		
		staticClass.display();  // "외부 클래스의 정적 필드에 접근: 외부 클래스의 정적 필드"
		
		System.out.println("=== 메서드 내부 클래스 (지역 클래스) ===");
		OuterClass outerClass2 = new OuterClass();
		outerClass2.outerMethod();  
		// "외부 클래스의 메서드를 호출"
		// "로컬 변수에 접근(Final X): 메서드 로컬 변수1"
		// "로컬 변수에 접근(Final O): 메서드 로컬 변수 (Final)"
		
		System.out.println("=== 익명 (내부) 클래스 ===");
		// 클래스타입 변수명 = new 클래스명() { 메서드 구현 - 추상클래스/인터페이스의 추상 메서드 }
		AbstractClass abstractClass1 = new AbstractClass() {
			
			@Override
			void display() {
				// TODO Auto-generated method stub
				System.out.println("익명 내부 클래스 - 추상 클래스 1");
				
			}
		};
	
		abstractClass1.display(); // "익명 내부 클래스 - 추상 클래스 1"
		
		AbstractClass abstractClass2 = new AbstractClass() {
			
			@Override
			void display() {
				// TODO Auto-generated method stub
				System.out.println("익명 내부 클래스 - 추상 클래스 2");
				
			}
		};
		
		abstractClass1.display(); // "익명 내부 클래스 - 추상 클래스 2"
		
		System.out.println(abstractClass1 == abstractClass2); // false
		
		// >> 재사용될 필요가 없거나 단 한번의 사용 목적에 유용
		
		
		// 인터페이스 구현
		InterfaceClass interfaceClass = new InterfaceClass() {
			
			@Override
			public void something() {
				// TODO Auto-generated method stub
				System.out.println("익명 클래스");
				
			}
		};
		
		interfaceClass.something(); // "익명 클래스"



	}

}

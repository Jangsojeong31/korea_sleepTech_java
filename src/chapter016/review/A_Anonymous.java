package chapter016.review;

// == 익명 클래스 == //
// : 클래스를 정의하면서 동시에 인스턴스화가 이루어지는 방법
// >> 이름 x , 재사용 x (일회성)

// 1. 인터페이스 구현 예시
interface Animal {
	void sound(); // 추상 메서드
	// cf) 람다 표현식으로 변환 가능한 인터페이스는 '함수형 인터페이스'
	// >> 단 하나의 추상 메서드만을 가짐
}

// cf) 인터페이스로 구현한 클래스 - 재사용 o
class Dog implements Animal {

	@Override
	public void sound() {
		// TODO Auto-generated method stub
		System.out.println("멍멍");
	}
	
}

// 2. 추상 클래스 구현 예시
abstract class Vehicle {
	abstract void run();  // absract 키워드 생략 불가 : 추상 클래스는 구현 메서드를 생성할 수 있기 때문에 default 로 인식
	
}
public class A_Anonymous {
	public static void main(String[] args) {
		
		// 인터페이스
		Animal dog1 = new Animal() {
			
			@Override
			public void sound() {
				// TODO Auto-generated method stub
				System.out.println("익명 - 멍멍1");
				
			}
		};
		
		Animal dog2 = new Animal() {
			
			@Override
			public void sound() {
				// TODO Auto-generated method stub
				System.out.println("익명 - 멍멍2");
				
			}
		};
		
		dog1.sound();  // 익명 - 멍멍1
		dog2.sound();  // 익명 - 멍멍2
		
		//2. 
		Vehicle car = new Vehicle() {
			
			@Override
			void run() {
				// TODO Auto-generated method stub
				System.out.println("자동차가 달립니다.");
			}
		};
		
		car.run(); // 자동차가 달립니다.

		
	}
}

package chapter008;

import chapter20.exam;

/*
 	인터페이스의 (멤버) 변수의 특성
 		: 자동으로 public static final 특성
 		> 어디서든 접근 가능 + 모두 같은 값 공유 (인스턴스화 없이 인터페이스에서 접근) + 불변성
 		
 		cf) 클래스 또는 인터페이스의 '멤버' : 해당 구조의 내부 '구성 요소'
 		
 */

// 다중 인터페이스 구현
interface Example1 {
	// 필드
	int EXAMPLE_VARIABLE = 10;
	// 메서드 
	void printVar1();
	
	default void method() {
		System.out.println("예시1");
	}
	
}

interface Example2 {
	void printVar1();
	void printVar2();
	
	default void method() {
		System.out.println("에시2");
	}
	
}

class ExampleClass implements Example1, Example2{  // 여러개의 인터페이스 구현(횟수 제한 없음)
	
	public void printVar1() {  // Example1 과 Example2에서 중복되는 추상 메서드
		System.out.println(EXAMPLE_VARIABLE);
	}
	
	public void printVar2() {  // Example2에서만 있는 메서드
		System.out.println("다중 인터페이스 구현");
		
	}
	
	@Override
	// 다중 인터페이스 구현 시 같은 시그니처를 가진 디폴트 메서드가 존재할 경우
	// 반드시 @Override (어노테이션)을 작성하기
	public void method() {
		System.out.println("Method, 중복되는 디폴트 메서드");
	}
	
}

public class D_Interface {
	public static void main(String[] args) {
		
		ExampleClass exampleClass = new ExampleClass();
		exampleClass.printVar1();   // 10
		exampleClass.printVar2();	// 다중 인터페이스 구현
		exampleClass.method();		// Method, 중복되는 디폴트 메서드
		
		Example1 example1 = exampleClass;  // 업캐스팅
		example1.printVar1();		// 10
//		example1.printVar2(); => 오류 : Example1에 정의되지 않았기 때문  (Example1에 있는 기능만 가능)
		example1.method();			// Method, 중복되는 디폴트 메서드
		
		// cf) 인터페이스의 다형성
		// : 인터페이스로 구현한 클래스(ExampleClass)의 객체는 해당 인터페이스(Example1)의 타입으로 동작 가능
		// >> 업캐스팅의 일부
		// - 해당 인터페이스(Exampe1) 내의 구조만 가짐 : (ExampleClass 내에서) 추가 구현된 기능은 읽히지 않음
		// - 재정의된 메서드는 유지
		
		
		// 의문점 : exampleClass를 Example1으로 업캐스팅 했을때, 메서드를 호출하면 ExampleClass에서 재정의된 메서드가 호출되었음
		// 상속의 경우에, 업캐스팅을 하면 자식 클래스에서 재정의된 메서드가 호출되는가
		
		
	}

}

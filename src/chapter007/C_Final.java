package chapter007;

/*
	final 키워드
	: 변수, 메서드, 클래스에서 사용 
	1) 변수 : 값을 변경할 수 없는 '상수' 선언
	2) 메서드 : 자식 클래스에서 '재정의(오버라이드)할 수 없는' 메서드 선언
			>> 해당 메서드는 재정의 될 수 없다.
	3) 클래스 : '상속될 수 없는' 클래스 선언
 */

class MyFinalClass {
	// 1. final 변수
	// : 상수를 지정하는 키워드
	// - 선언과 동시에 '초기화'되어야 함 ; 재할당 불가능
	// - UPPER_SNAKE_CASE(전체 키워드를 대문자로 작성)
	final int FINAL_VARIABLE = 30;
	
	// 2. final 메서드
	// : 자식 클래스에서 오버라이드(재정의)할 수 없는 메서드를 의미
	// [접근제어자] final 반환타입 메서드명() {}
	public final void myMethod() {
		System.out.println("재정의할 수 없는 메서드~");
	}	
}

class ChildClass extends MyFinalClass {
//	public void myMethod() {}  => 오류 발생 : 재정의 불가능(확장 불가)
	
	// 생성자
	ChildClass(){
		super.myMethod(); // 이렇게는 가능(그냥 가져다 쓰는 거임. 재정의 아님)
	}
}


// 3. final 클래스
// : final class 클래스명 {}
// : 더 이상 상속될 수 없는 클래스를 의미
// >> final 클래스를 부모 클래스로 사용 불가

final class Example1 {}
//class Example2 extends Example1 {} => 오류 발생 : final class인 Example1을 상속 불가


// ================================================================= //

class StudentClass {
	private String name;  // 보호 o / 변경 가능
	private final int residentNumber = 1234567; // 보호 o / 변경 불가능  => 주민번호에 대한 불변성이 필요하다!
	private final String gender; // 보호 o / 변경 불가능
	// >> 방법 : final 필드 사용(초기화 필수) OR setter를 제거하고 생성자로만 값을 결정하기
	
	// cf) final 필드의 데이터 주입
	//		: final 키워드는 선언과 동시에 초기화가 필요
	//		- 필드 주입 방식) residentNumber
	// 		- 생성자 주입 방식) gender
	
	// 생성자
	public StudentClass(String gender){
		this.gender = gender;
	}
	
	// name의 getter/setter
	public String getName() { return name; }
	public void setName(String name) { this.name = name; }
	
	public String getgender() { return gender; }
//	public void setgender(String gender) {this.gender = gender;}
	// private final : getter는 생성되지만 setter는 안됨(재할당 불가하기 때문에)
}


// =================================================================== //

public class C_Final {
	public static void main(String[] args) {
		
		ChildClass childClass = new ChildClass();
		childClass.myMethod(); // final 메서드는 재정의는 안되지만 사용은 가능
		
		/*
			final 키워드의 장단점
		  	장점) 불변성 (안정성 보장)
		  	단점) 유연성 감소(상속 x, 오버라이딩 x)
		 */
		
	}

}

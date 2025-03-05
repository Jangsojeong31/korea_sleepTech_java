package chapter006;

// == 오버라이딩 == //   cf) 오버로딩 : 하나의 클래스 내에서 같은 이름의 메서드
// : 자식 클래스가 부모 클래스에서 상속받은 '메서드'를 자신의 상황에 맞게 '재정의'
// - 상속 관계에 있는 클래스들 사이에서 사용
// - 부모 클래스의 기본 동작을 자식 클래스에서 변경하거나 확장할 때 사용

class ParentClass {
	void exercise() {
		System.out.println("달리기를 잘합니다");
	}
}

class ChildClass extends ParentClass {
	
	/* @Override
	 * 자바에서 제공하는 코드 어노테이션(annotation, 주석)
	 * 부모 클래스의 메서드를 자식 클래스에서 재정의 했다는 것을 명시적으로 나타냄
	 * 
	 * cf) @Override를 생략해도 오류가 나지 않는 이유
	 * 		: 자바 컴파일러가 메서드 시그니처(이름, 매개변수, 반환타입 : 선언부)을 비교하여 
	 * 			부모 클래스의 메서드를 자식 클래스에서 재정의했는지 판단
	 * 
	 * 상속받은 메서드명과 동일한 메서드를 자식 클래스에서 정의하는 경우
	 * 	: 자동으로 재정의임을 판단 
	 */

	@Override
	void exercise() {
		super.exercise();
		System.out.println("피구도 잘합니다.");
	}
}

// == 오버라이딩 특징 == //
/*
 	메서드 시그니처가 일치
 		: 부모 클래스의 메서드와 동일한 '이름', '매개변수' 구성을 가져야 함.
 		  '반환 타입'은 같거나 자동 형변환이 가능하게 작성
    메서드명 바로 위에 @Override 어노테이션 작성
    목적 : 다형성 구현 
    		- 하나의 이름으로 여러 기능을 수행하는 코드 작성
    	  재사용성, 확장성 향상 
    	  	- 기존의 코드 변경 없이, 새로운 기능 추가와 변경 가능
    	  
 */

class AnimalClass {
	
	void sound() {
		System.out.println("동물이 울음소리를 냅니다.");
	}
}

class Dogclass extends AnimalClass {
	
	/*
	  코드 어노테이션
	  	: 코드에 메타데이터를 제공하는 방법
	  		필수는 아니지만 권장 사항(컴파일러의 효율적인 작동을 위해)
	 */
	
	@Override
	void sound() {
		System.out.println("강아지가 멍멍하고 짖습니다.");
	}
	
}

class Catclass extends AnimalClass {
	

	@Override
	void sound() {
		super.sound();
		System.out.println("고양이가 야용하고 웁니다.");
	}
	
}


public class D_Overriding {
	public static void main(String[] args) {
		
		ChildClass childClass = new ChildClass();
		childClass.exercise(); // 달리기를 잘합니다
		     				   // 피구도 잘합니다.
		
		
		
		// ========================================== //
		
		AnimalClass animalClass = new AnimalClass();
		animalClass.sound(); // 동물이 울음소리를 냅니다.
		
		Catclass catclass = new Catclass();
		Dogclass dogclass = new Dogclass();
		
		catclass.sound();  // 강아지가 멍멍하고 짖습니다.
		dogclass.sound();  // 동물이 울음 소리를 냅니다.
						   //고양이가 야용하고 웁니다. 
		
		/*
		 * 해당 상태나 동작을 반드시 가지지만
		 * 상속받는 클래스마다 차이를 두고 싶은 경우
		 */
		
		// == 오버로딩 vs 오버라이딩 == //
		// 공통점 : 매서드의 이름을 재사용 (다형성 - 같은 이름으로 다른 행위)
		
		// 차이점
		// 1) 오버로딩 
		// - 같은 '클래스 내'에서 같은 이름을 가진 메서드를 여러 개 정의
		// - 메서드명 동일 / 매개변수 타입, 개수, 순서 중 적어도 하나 이상을 달라야 함 / 반환 타입만 다르면 같은 메서드로 인식
		// - 메서드 동작을 다양한 상황에 맞게 조정
		// 예) 생성자
		
		// 2) 오버라이딩
		// - '상속 관계' 있는 클래스에서 사용(각각 다른 클래스)
		// - 메서드 시그니처(반환 타입, 이름, 매개변수)가 동일 (구현부에서 차이)
		// : 메서드의 동작을 변경하거나 확장
		// @Override 사용 : 컴파일러에게 전달
		
		
		
	}

}

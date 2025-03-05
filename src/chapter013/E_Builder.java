package chapter013;

/*
 	빌더(Builder) 패턴
 	
 	1. 빌더 패턴 이란
 		: 객체 생성 방법 중 하나
 		- 복잡한 객체를 단계별로 만들 때 사용
 		- 필드(속성)가 많거나, 필드의 필수값과 선택값이 섞여 있을 때 유용
 		
 	2. 사용 목적
 		- 생성자가 너무 많아질 때 사용 
 		- 코드가 복잡하고 읽기 어려울 때
 		
 	3. 장단점
 		- 장점
 			: 가독성 향상, 유연성 증가, 확장성 용이
 		- 단점
 			: 구현 복잡성 증가, 작은 객체(필드가 적은)에는 부적합
 			
 	4. 동작 원리
 		1) 객체 생성 시 필요한 데이터를 저장하는 Builder 클래스 생성
 		2) Builder 클래스는 원하는 속성을 단계별로 설정할 수 있는 메서드 제공
 		3) build() 메서드를 호출하여 객체 생성
 		
 	5. 빌더 사용 방법
 */
class Pizza {
	private final String menu; // 종류 (필수)
	private final String size; // 크기 (필수)
	
	private final boolean cheese; // 선택
	private final boolean mushroom; // 선택
	private final boolean pepperoni; // 선택
	
//	// 생성자 : 경우의 수가 너무 많이 발생
//	public Pizza(String menu, String size, boolean cheese, boolean mushroom, boolean pepperoni) {
//		this.menu = menu;
//		this.size = size;
//		this.cheese = cheese; 
//		this.mushroom = mushroom;
//		this.pepperoni = pepperoni;
//	}
//	
//	public Pizza(String menu, String size) {
//		this.menu = menu;
//		this.size = size;
//		this.cheese = false; 
//		this.mushroom = false;
//		this.pepperoni = false;
//	}
	
	// == Builder 패턴 ==
	// 1) Builder 클래스 정의
	public static class Builder{
		// 필수 필드
		private final String menu; // 종류 (필수)
		private final String size; // 크기 (필수)
		// 선택 필드 - 기본값(false) 설정 : 추가하지 않으면 해당 값으로 입력됨
		private boolean cheese = false; // 선택
		private boolean mushroom = false; // 선택
		private boolean pepperoni = false; // 선택
		
		public Builder(String menu, String size) {
			// 필수값 설정
			this.menu = menu;
			this.size = size;
		}
		
		// 선택값 지정 메서드
		public Builder addCheese() {
			this.cheese = true;
			return this; // this : 해당 클래스타입(Builder)의 객체 그 자체
		}
		public Builder addMushroom() {
			this.mushroom = true;
			return this; 
		}
		public Builder addPepperoni() {
			this.pepperoni = true;
			return this; 
		}
		
		// Builder 객체를 생성하는 build 메서드
		public Pizza build() {
			return new Pizza(this); // 피자 클래스의 인자로 Builder 클래스의 인스턴스 제공
		}
	}
	
	private Pizza (Builder builder) {
		this.menu = builder.menu;
		this.size = builder.size;
		// add 메서드 호출을 하지 않아도 기본값 false 값이 지정
		this.cheese = builder.cheese;
		this.mushroom = builder.mushroom;
		this.pepperoni = builder.pepperoni;
	}
	
}
public class E_Builder {
	public static void main(String[] args) {
		
//		Pizza noBuilderPizza = new Pizza("파인애플 피자", "L", false, false, false);
		
		// Builder 패턴 사용
		Pizza builderPizza = new Pizza.Builder("고구마 피자", "M") // Pizza 내부의 Builder 생성자 메서드 호출
				.build();
		
		Pizza optionPizza1 = new Pizza
				.Builder("포테이토 피자", "L")
				.addMushroom()  // Builder 타입을 반환
				.addPepperoni()
				.build();		// Pizza 타입을 반환
		
		Pizza optionPizza2 = new Pizza
				.Builder("쉬림프 피자", "M")
				.addCheese()
				.addPepperoni()
				.build();
		
		// cf) 메서드 체이닝
		// : 메서드 호출 뒤 반환되는 데이터에 곧바로 추가 메서드를 호출(. 이용)
		
		
	}

}

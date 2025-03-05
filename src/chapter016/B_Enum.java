package chapter016;

/*
 	ENUM(열거형) 자료형
 	: 서로 관련된 상수들의 집합을 표현
 	- 상수들은 서로 유기적인 관계성을 가짐, 하나의 클래스로 취급
 	- 특정 값들만 가질 수 있도록 제한
 	
 	cf) static final 
 	
 */

// 선언 방법 - enum 키워드 : enum Enum명 {}
// 명명규칙 - 클래스와 동일
// {} 내에서 열거할 데이터를 ','로 구분하여 나열

enum Fruits {
	// final의 특징을 살려 enum 내부의 데이터는 UPPER_SNAKE_CASE 사용
	APPLE, BANANA, ORANGE
}

// 예제2
enum CoffeSize {
	SMALL(200), MEDIUM(300), LARGE(400); // 각 필드는 CoffeSize(Enum)과 대등
	// >> 생성자 호출
	private final int ml;
	
	 CoffeSize(int ml) {
		 this.ml = ml;
	 }
	 
	 public int getMl() { return ml; }
}

public class B_Enum {
	public static void main(String[] args) {
		// static final 필드처럼 사용됨 : 각 상수는 정의된 Enum 타입으로 간주
		Fruits apple = Fruits.APPLE;
		System.out.println(apple); // APPLE
		
		// == Enum 주요 메서드 == //
		// 1) values(): 열거형의 모든 값을 배열로 반환
		System.out.println(Fruits.values()); // [Lchapter016.Fruits;@6fffcba5

		for(Fruits fruit: Fruits.values()) {
			System.out.println(fruit);
		}
//		APPLE
//		BANANA
//		ORANGE
		
		// 2) names(): Enum 상수의 이름을 문자열로 반환
		String appleName = Fruits.APPLE.name();
		System.out.println(appleName.toLowerCase());  // apple
		
		// 3) valueOf(String name) : 문자열로 Enum 상수(0부터 시작) 반환
		// : 잘못된 문자열을 보낼 경우 IllegalArgumentException 발생
		Fruits orange = Fruits.valueOf("ORANGE");
		System.out.println(orange); // ORANGE
		// 4) ordinal(): Enum 상수의 순서를 반환(0부터 시작)
		System.out.println(orange.ordinal());  // 2
		
		
		
		
		// 예제 2
		CoffeSize size = CoffeSize.MEDIUM;  // MEDIUM의 객체 size가 생성되면서 동시에 size.ml에 300이 할당
		System.out.println(size + "'s ml: " + size.getMl() + "ml"); // MEDIUM's ml: 300ml

		CoffeSize anotherSize = CoffeSize.LARGE;
		System.out.println(anotherSize + "'s ml: " + size.getMl() + "ml"); // LARGE's ml: 300ml

	}

}

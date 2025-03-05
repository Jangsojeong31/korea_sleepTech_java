package chapter006;

// == 생성자(Constructor) == //
// : 객체(인스턴스)가 생성될 때 호출되는 '인스턴스 초기화 메서드' 

// - 생성자 조건
// 		: 클래스명과 동일한 이름을 사용
// 		: 리턴값이 없는 메서드 형식 (void 타입이 생략)

// 1) 컴파일러가 제공하는 기본 생성자
// : 클래스에 생성자가 없으면 자동 생성되는 빈 생성자
// >> 매개변수 x, 아무런 작업도 하지 x(구현부 내의 기능 코드 x)

class Example1 {
	int value; 
	// 기본 생성자가 자동 생성됨
}

class Example2 {
	int value;
	
	// 사용자 정의 생성자
	Example2 (int value) {
		this.value = value;
	}
	// 사용자 정의 생성자를 생성하면
	// 컴파일러가 자동으로 기본 생성자를 제거한다. 
	// 기본 생성자를 직접적으로 명시
	Example2() {}
}

// == Car 클래스 == //
class Car {
	String color;
	String gearType; //auto(자동), manual(수동)
	int door;
	
	// 기본 생성자 - 차를 생성한 뒤 필드값 초기화
	Car() {} 
	
	// 사용자 정의 생성자
	Car(String color, String gearType, int door){
		this.color = color;
		this.door = door;
		this.gearType = gearType;
	}
	//
	Car(String color, String gearType){
		this.color = color;
		this.gearType = gearType;
		door = 6;
	}
	//
	Car(String color, int door){
		this.color = color;
		this.door = door;
	
	}
	//
	Car(String color) {
		
		this(color, "auto", 4);  // 40번째 줄에 작성한 사용자 정의 생성자의 호출
		// : 객체 생성 시 색상만 지정하는 경우
		
		// cf) 사용자 정의 생성자에서 다른 생성자 호출: this();
				// 		: 생성자 이름으로 클래스명 대신 this를 사용
				// 		>> 정의 생성자에서 타 생성자 호출 시 반드시 '첫 줄에서만' 호출 가능
				
				// - 호출된 생성자가 변수값을 초기화하는 경우
				// 		: 현재의 생성자가 수행하는 작업을 유지하기 위함(무의미함 방지)
		
//		this.color = color;  // 위의 코드와 같은 의미?
//		gearType = "auto";
//		door = 4;
		
		door = 5;
//		this(color, "manual", 4);
		
		// : 타 생성자의 호출이 해당 생성자의 기능 이후에 작성되는 경우
		// >> 타 생성자의 호출의 결과와 동일
	}
	//
	Car(int door){
		this("blue", door);
	}
	
	
}

/*
 	this 키워드
 	1. this 키워드
 		: 인스턴스 자신을 참조
 		>> 모든 인스턴스 메서드와 생성자 내부에서 사용 가능
 		>> 정적 메서드에서는 사용 불가
 		
	2. this()
		: 같은 클래스 내의 다른 생성자 호출
		>> 중복 코드 제거와 유지보수성 향상에 기여
		
 */

public class A_Constructor {
	public static void main(String[] args) {
		Example1 example1 = new Example1(); // 빈 생성자 호출
		Example2 example2 = new Example2(50); 
		
		//Car 인스턴스 생성
		Car car1 = new Car(); // 기본 생성자 호출
		car1.color = "black"; // 객체명.필드명
		car1.gearType = "auto";
		car1.door = 4;
		
		Car car2 = new Car("white", "manual", 2); // 사용자 정의 생성자 호출
		
		Car car3 = new Car("red");
		System.out.println(car3.color);     // red
		System.out.println(car3.gearType);  // auto
		System.out.println(car3.door);      // 5
		
		Car car4 = new Car("blue", "auto");
		System.out.println(car4.door); //6
		car4.door = 2;
		System.out.println(car4.door); //2
		
		Car car5 = new Car(3);
		System.out.println(car5.door); //3
		System.out.println(car5.color); //blue
		System.out.println(car5.gearType); //null
		
		
		// cf) 인스턴스 생성
		// : 생성자가 인스턴스 생성 x
		// >> new 연산자가 인스턴스 생성 o
		
		
		
	}

}

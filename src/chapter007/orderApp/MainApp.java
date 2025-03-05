package chapter007.orderApp;

/*
 * MainApp 클래스
 * : 주문 시스템의 실행 진입점
 * - 제품 생성, 주문 생성, 주문 결과 출력 등
 * 
 */
public class MainApp {
	public static void main(String[] args) {
		
		// 제품 생성(업캐스팅)
		Product laptop = new Electronics("Laptop", 5000);
		Product apple = new Food("apple", 600);
		
		// 주문 생성
		Order order1 = new Order(laptop, 1);
		Order order2 = new Order(apple, 1);
		
		System.out.println(order1); //Order Detail[ Laptop * Quantity: 1 >> 5750.0 ]
		System.out.println(order2); //Order Detail[ apple * Quantity: 1 >> 600.0 ]

		// cf) toString();
		// : '클래스명@해당객체의주소값'이 문자열로 출력
		// - 객체를 문자열로 표현할 때 사용(재정의 가능)
		// - 모든 클래스의 최상위 클래스인 Object 클래스에서 정의되어 있는 메서드
		
		
	}

}

package chapter18;
/* 
 * 클래스의 객체화(인스턴스화) : 클래스 ---> 생성 -> 사용
 * 클래스 변수명 = new 클래스();
 * 변수명 : 인스턴스(클래스의 위치를 담고 있음)
 */
public class CarMain {
	public static void main(String[] args) {
		
		Car car = new Car();
		
		car.year = 2020;
		car.carName = "소나타";
		car.go();
		
		
		
	}

}

package chapter18;
/*
 * 라이브러리 클래스(main과 별도의 클래스로 생성)
 */

public class Car {

	//필드 : 인스턴스 멤버
	int year; //연도 : 클래스의 필드, 자동으로 기본값으로 초기화됨
	String carName;
	
	//메서드 : 인스턴스 메서드
	public void go() {
		System.out.println(carName + "이 출발합니다.");
	}
}

package chapter009;

/*
 	java.lang 패키지
 		: 자바 프로그램의 가장 기본적인 클래스들을 포함
 		- 별도의 import 없이 사용 가능
 		
	1) Object 클래스
		: 자바의 모든 클래스의 최상위 클래스
		- 모든 클래스는 Object 클래스를 상속받음
		- toString, equals ...
		
	2) Math 클래스
		: 수학 연산 및 함수를 제공
		- 모든 필드와 메서드는 static이다. 
		- abs, max, min, sqrt, pow, random ...
		
	3) String 클래스
		: 문자열 조작을 위한 다양한 메서드 제공
		- charAt, length, equals, indexOf ...
		
	cf) Object의 equals와 String의 equals의 차이
 */

class MyClass { // extends Object 가 생략되어 있음
	private int id;
	private String name;
	
	MyClass(int id , String name){
		this.id = id;
		this.name = name;
	}
	
	// 1) toString() 메서드
	// : 객체의 문자열 표현을 반환
	// - 기본 구현 : '패키지명.클래스명 + @ + 메모리 주소' 반환
	// - 오버라이딩 : 원하는 정보 반환 
//	@Override
//	public String toString() {
//		return "MyClass(ID : " + id + " / NAME: " + name + ")";
//	}
	
	String displayInfo() {
		return "ID: " + id + " / NAME: " + name;
	}
	
	// 2) equals(Object obj)메서드
	// : 두 객체가 동등한지 비교
	// - 두 객체의 '참조'를 비교(동일한 주소값을 가지는지 확인)
}




public class JavaLang {
	public static void main(String[] args) {
		
		System.out.println("Object 클래스 ====");
		MyClass myClass1 = new MyClass(1, "이승아");
		System.out.println(myClass1);
		// MyClass(ID: 1 / NAME: 이승아)
		// : 객체를 출력하는 경우 자동으로 toString() 호출 - '생략 가능' : toString()의 이점
		// cf) toString()을 재정의 하지 않을 경우 : chapter009.MyClass@75412c2f 가 출력됨
		System.out.println(myClass1.toString());
		// MyClass(ID : 1 / NAME: 이승아)

		System.out.println(myClass1.displayInfo());
		// ID: 1 / NAME: 이승아
		
		// 2) equals
		
		MyClass myClass2 = new MyClass(2, "이도경	");
		System.out.println(myClass1.equals(myClass2)); // false
		
		MyClass myClass3 = myClass1;
		System.out.println(myClass3.equals(myClass1)); // true
		// : 주소값을 비교
		
		String s1 = "이승아";
		String s2 = "이승아";
		System.out.println(s1.equals(s2)); // true
		// : 문자열의 equals() 메서드는 두 문자열의 내용(값)을 비교
		
		
		System.out.println("Math 클래스 ======");
		// Math 클래스는 모든 필드와 메서드가 static
		
		System.out.println(Math.abs(-10)); // 절대값 반환 : .abs() 
		System.out.println(Math.max(10, 20)); // 최대값 반환 
		System.out.println(Math.min(10, 20)); // 최소값 반환
		System.out.println(Math.sqrt(16)); // 제곱근 
		System.out.println(Math.pow(2, 3)); // 제곱 값 : 8
		System.out.println(Math.random()); // 무작위 난수 생성 : 0.0 이상 0.1 미만의 난수 생성
		
		System.out.println("===== String class =====");
		
		String message = "Merry Christmas!";
		System.out.println(message.length()); // 공백, 기호 포함 문자 길이 (str.length())
		boolean isEquals = message.equals("Merry Christmas^^");
		System.out.println(isEquals); // false 
		
		// substring(int start, int end)
		// : 시작 인덱스(포함)부터 끝 인덱스(미포함)까지의 부분 문자열을 반환(start ~ end-1)
		// - 문자열 인덱스 번호는 0부터 시작, '공백과 기호까지 포함'
		System.out.println(message.substring(6, 15)); // Christmas
		System.out.println(message); // Merry Christmas!
		// 문자열은 불변성(immutable) 데이터(substring을 통해 추출해도 기존의 message는 변하지 않는다)
		
		// indexOf(String str)
		// : 문자열에서 특정 문자열의 첫번째 위치(시작 위치)를 반환 
		int index = message.indexOf("Christmas");
		System.out.println(index); // 6
		System.out.println(message.indexOf("C")); // 6
		System.out.println(message.indexOf('C')); // 6
		
		// charAt(int index)
		// : 인덱스의 문자를 반환
		char c = message.charAt(6);
		System.out.println(c); // C

	}

}

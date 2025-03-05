package sjs01;

public class HelloJava {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/*
		 * 자바는 객체지향 
		 * 프로그램에서의 객체는 ? : 속성과 기능을 포함 
		 * 파일 > 클래스 > 변수(속성, 성질) > 메서드(기능) > 실행코드
		 * 소스 파일의 이름이 메인 클래스(public이 붙은 클래스) 이름과 동일해야 함
		 * 매서드 : 동작코드는 모두 메서드 아래에서 작성되어야 함
		 * public class HelloJava : public, class는 예약어, 키워드
		 * 프로젝트 이름은 보통 소문자로
		 * 클래스는 파스칼 표기법 ex) HelloJavaWorld
		 * 변수명은 카멜식 표기법, 명사형, 변수명을 보고 데이터의 의미를 알 수 있도록,
		 * 특수기호 또는 숫자가 첫글자로 올 수 없음($,_는 제외), 
		 * 자바 예약어는 쓸 수 없다. ex) superManPower
		 */
		
		/* 단축키
		 * 실행 : ctrl + f11
		 * sysout 자동완성 : ctrl + space
		 * 글자 확대 : ctrl + +/-
		 */

		// 주석
		/*
		 * 여러줄
		 * 주석
		 * */
		// 정수형 타입 : byte(1), short(2), int(4), long(8)
		//데이터 타입  변수명 = 값(초기값)
		int num01 = 20;
		byte byNum = 20;	
		int a = 0; //int a;는 오류 : 변수에 초기값을 부여
		a = a + 1;
		//실수 : float(소수점 5번째 "), double(소수점 15번쨰 자리부터 오류)
		double doubleNum = 30.3111;
		//문자(한글자) : char('')
		char ch = 'A' ;	
		//문자열(문장, 한글자 이상) : String("") *클래스 타입
		String str = "날씨";	
		//논리형 : boolean(true or false)
		boolean b = false;
		
		//문장이 끝나고 줄이 바뀌는 명령
		System.out.println(num01);
		System.out.println(byNum);
		System.out.print(doubleNum); //줄 안바뀜
		System.out.println(ch);
		System.out.println(b);
	
	

	}

}

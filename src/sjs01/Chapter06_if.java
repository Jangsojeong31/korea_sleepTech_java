package sjs01;

import java.util.Scanner; //자동 import : ctrl + shift + o


/*
 * 제어문 1 : 조건문 if
 * 제어문의 종류 : 분기문(조건문) - if / switch-case  / 반복문
 */

public class Chapter06_if {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//1) if (조건문) {실행문} : 조건문 -> true/false
		int score = 80;
		
		// 점수가 60점 이상이면 합격
		if(score >= 60) {
			//참일 때 실행
			System.out.println("합격!");
		}else {
			//거짓일 때 실행
			System.out.println("불합격");
		}
		
		//2) Scanner : 키보드 값 입력
		/*
		 * import : 가져다 쓰기
		 * Scanner scan = new Scanner(System.in);
		 * nextInt(); nextLong(); nextDouble(); -> 정수
		 * next(), nextLine(); -> 문장
		 */
		
		//키보드로부터 입력되는 값을 기다렸다가 들어오면 가져온다.
		Scanner scan = new Scanner(System.in);
		
		System.out.println("나이 입력 : ");
		int age = scan.nextInt(); //정수값 입력 대기
	
		if (age > 19) {
			System.out.println("성인입니다.");
		}else {
			System.out.println("미성년자입니다.");
		}
	
		//스캐너 사용 후 닫아주기
		scan.close();
		
		//3) elseif
		//구조 : if (조건1) {} else if (조건2) {} else if(조건3) {} else {}
		//좁은 범위의 조건부터 
		
//		System.out.println("정수를 입력하세요 : ");
//		int scor = scan.nextInt();
//		
//		if(scor >= 90) {
//			System.out.println("점수 : " + scor + "학점 : A");
//		}else if(scor >=80){
//			System.out.println("점수 : " + scor + "학점 : B");
//		}else if(scor >=70) {
//			System.out.println("점수 : " + scor + "학점 : C");
//		}else {
//			System.out.println("점수 : " + scor + "학점 : F");
//		}
//		
//		scan.close();
		
		
		//연습
		
		String grade;
		int scor2;
		
		System.out.print("점수를 입력하세요 : ");
		scor2 = scan.nextInt();
		
		if(scor2 >= 90) {
			grade = "A";
		}else if(scor2 >= 80) {
			grade = "B";
		}else if(scor2 >= 70) {
			grade = "C";
		}else if(scor2 >= 60) {
			grade = "D";
		}else {
			grade = "F";
		}
		
		System.out.println("점수는 : " + scor2 + ", 학점은 : " + grade + " 입니다.");
		
		scan.close();
		
		
	}

}

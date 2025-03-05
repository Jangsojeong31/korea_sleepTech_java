package sjs01;

/*
 * switch:case 조건문 ; 단순 조건
 * 구조 : switch(변수, 수식){case 값1: 코드; break; case 값2: 코드; break; default: 코드;}
 * 변수, 수식이 '값'으로 떨어짐 / 범위가 없음 / break를 생략하면 밑에 코드까지 실행됨(활용 가능)
 */

/*
 * 랜덤 함수 : Math. random() ; 0 <= x < 1(x = 0~0.9999)
 * random * 100 -> 0 ~ 99.9999 -> int로 형변환(강제 형변환) -> 0 ~ 99
 * (int)(random * 100) +1 -> 1~100 ; 최소값 : 1, 최대값 : 100
 */

public class Chapter07_swithcase {
	public static void main(String[] args) {
		
		int score = 0;
		score = (int)(Math.random() * 100) + 1; //1~100 무작위 추출
		
		switch(score / 10) {
		
		case 10 : //break없으면 아래로 내려감 
		case 9 : 
			System.out.println("점수 : " + score + ", 학점 : A학점");
			break;
		case 8 :
			System.out.println("점수 : " + score + ", 학점 : B학점");
			break;
		case 7 :
			System.out.println("점수 : " + score + ", 학점 : C학점");
			break;
		default :
			System.out.println("점수 : " + score + ", 학점 : F학점");
		}
			
			//최소 60점
//			int scor = 0;
//			scor = (int)(Math.random() * (100 - 60 + 1)) + 60;
//			
//			switch(scor / 10) {
//			
//			case 10 : 
//			case 9 : 
//				System.out.println("점수 : " + scor + ", 학점 : A학점");
//				break;
//			case 8 :
//				System.out.println("점수 : " + scor + ", 학점 : B학점");
//				break;
//			case 7 :
//				System.out.println("점수 : " + scor + ", 학점 : C학점");
//				break;
//			default :
//				System.out.println("점수 : " + scor + ", 학점 : F학점");
//
//		}
	}
}

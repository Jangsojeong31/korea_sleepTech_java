package sjs01;

import java.util.Scanner;

/*
 * while문
 * 구조:
 * while(조건) {실행문} 
 * 조건이 true일 동안만 실행문 실행, false가 되면 반복문 stop
 * 조건 검색 -> true -> 실행문 실행
 */

public class Chapter10_while {
	public static void main(String[] args) {
		
		//1부터 10까지 더하기
//		int sum = 0;
//		int count = 1;
//		
//		while(count <= 10) {
//			sum = sum + count;
//			count++; //count를 증가시킴
//		}
//		System.out.println(sum);
		
		//업다운 숫자 맞추기 게임
		
//		int target = (int)(Math.random() * 50) + 1; //1~50
//		Scanner scan = new Scanner(System.in);
//		
//		int user = 0;
//		int count1 = 0;
//		
//
//		
//		
//		while(target != user) { //target == user이 되면 loop 종료
//			
//			System.out.print("숫자를 입력 : "); //40, 41번 코드를 위로 올리면 무한루프가 됨 
//			user = scan.nextInt();
//			
//			if(target < user) {
//				System.out.println("다운!");
//			}else if(target > user) {
//				System.out.println("업!");
//			}else {
//				System.out.println("정답! 값은 : " + target + "입니다.");
//				System.out.println((count1 + 1) +"번 만에 맞췄습니다!");
//			}
//			
//			
//			
//			count1++;	
//		}
//		scan.close();
		
		/*
		 * do-while문
		 * 구조 : 
		 * Do {
		 * 실행문
		 * } while(조건);
		 * 실행 먼저 -> 조건 검색 : while문과의 차이  
		 *
		 */
		
		//while문과 do-while문의 차이
		
		int count = 1;
		
		//while문
		
		while(count < 1) { //false(조건 부합 안됨) -> 실행문 실행 안됨
			System.out.println("실행");
		}
		
		//do-while문
		
		do {
			System.out.println("do-while 실행"); //실행문 먼저 실행됨, 조건에 상관없이 최소1회는 실행되어야 하는 경우
		}while(count < 1);
		
		//do-while문 예)
		int count01 = 1;
		int sum = 0;
		
		do {
			sum += count++;  //sum += count;
							 // count++;와 같은 개념
			
		}while(count <= 10);
		
		System.out.println(sum);
	}
}

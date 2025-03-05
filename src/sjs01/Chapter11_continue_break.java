package sjs01;

import java.util.Scanner;

/*
 * continue문 : 현재 반복이 종료, 실행문의 종료, 다음 반복 시작
 */

/*
 * break문 : loop 자체의 종료
 */
public class Chapter11_continue_break {
	public static void main(String[] args) {
		
		//continue문 예 ; 짝수만 더하기
		
//		int sum = 0;
//		
//		for(int i = 1; i <= 10; i++) {
//			if(i % 2 != 0) { //홀수일 때 continue문 실행
//				continue;  //continue를 만나면 다시 맨 위로 올라감(진행 중인 실행문 종료)
//			}			
//			sum = sum + i;
//		}
//		System.out.println(sum);
		
		//break문 예(while, random 이용)
		
		int sum01 = 0;
		
		while(true) { //무한루프  //for문 무한루프 : for(;;)
			int val = (int)(Math.random() * 50) + 1;
			
			if(val == 30) {
				System.out.println("30! 종료!");
				break;
			}
			
			sum01 += val;
			System.out.print(val + ", ");
		}
//		System.out.println();
		System.out.println(sum01);
		
		//업다운 게임
		int target = (int)(Math.random() * 50) + 1;
		Scanner scan = new Scanner(System.in);
		
		int count = 1;
		int user = 0;
		
		while(true) {
			System.out.println("숫자를 입력 : ");
			user = scan.nextInt();
			
			if(target == user) {
				System.out.println("정답! 숫자는 " + user + " 입니다." + count + "번 만에 맞췃네요");
				break;	
			}else if(target > user) {
				System.out.println("업!");
			}else if(target < user) {
				System.out.println("다운!");
			}
			
			count++;
		
		}
		
		scan.close();
	}
}

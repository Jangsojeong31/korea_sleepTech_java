package sjs01;

/* 
 * 중첩(다중, 다차원) for문
 * 
 */

public class Chapter09_multi_for {
	public static void main(String[] args) {
		
		//구구단
		int sum = 0;
		
		for(int i = 2; i < 10; i++) {
			
			for(int j = 1; j < 10; j++) {
				System.out.print(i + "x" + j + "=" + (i * j) + "\t"); //\t : 띄어쓰기
			}
			System.out.println(); //줄바꿈
		}
		
		//직각 삼각형
		for (int i = 0; i < 7; i++) { //7줄 생성
			for(int j = 0; j < 6 - i; j++) { //공백 : 감소(6회 반복-> 5회 반복 -> ...)
				System.out.print(" ");
			}
			for(int star = 0; star < (i + 1); star++) { //별 : 증가(1회 반복 -> 2회 반복 ..)
				System.out.print("*");
			}
			
			System.out.println();
			
		}
	
		
		/*
		 * 풀이 : i = 0일 때, 실행문 1-1 6회 반복, 실행문 1-2 1회 반복, 줄바꿈
		 * 		 i = 1일 때, 		    5회 반복, 		  2회 반복, 줄바꿈
		 * ...
		 
		 */
			  
		
		// 10줄 트리 
		
//		for(int a = 0; a < 10; a++) {
//			for(int j = 0; j < 9 - a; j++) { //반복횟수 : 9->8->...->0
//				System.out.print(" ");
//			}
//			
//			if(a == 0) {
//			 System.out.print(" ");
//			}
//			else {
//				System.out.print("/");
//			}
//			
//			for(int star = 0; star < 1 + (a*2); star++) { //반복횟수 : 1->3->5->7->9	
//				System.out.print("*");
//			} 
//			
//			if(a == 0) {
//				System.out.print(" ");
//			}
//			else { 
//				System.out.print("\\");
//			}
//			
//			System.out.println();
//		}
//		
//		//나무기둥
//		for(int b = 0; b < 3; b++) {
//			System.out.print("         ");
//			System.out.print("|");
//			System.out.print(" ");
//			System.out.print("|");
//			System.out.println();
//		}
//		
//			
		
	}
}
 
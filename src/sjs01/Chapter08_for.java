package sjs01;

/* 
 * 반복문
 * : 동일한 동작을 여러번 반복해서 진행하게 하는 것
 * 종류 : for, while, do-while
 * for문 : 반복횟수가 정해져 있음
 * while, do-while문 : 조건에 부합할 때까지 반복 ex) 바구니에 물이 다 찰 떄까지 채워라
 * for문 구조 : for(초기값; 조건; 증감 연산) { 실행문 }
 * 진행 순서 : 초기값 확인 -> 조건 부합 -> 실행문 실행 -> 증감 연산 -> 조건 부합 -> 실행문 -> 증감 연산
 * -> 조건 부합하지 않음 -> 종료
 * 증감 연산 ex) a++, a=a+1(같은 의미)
 */
public class Chapter08_for {
	public static void main(String[] args) {
		/*10회 반복 예시
		 * for(int i = 0; i < 10; i++) //i : 0 -> 9
		 * for(int i = 1; i <= 10; i++)//i : 1 -> 10
		 * for(int i = 10; i > 0 ; i--)//i : 10 -> 1
		 */
		
		//예제1 : 1~10까지 더하기
		
//		int sum = 0;  //변수 선언 및 초기화
		
//		for(int i = 1; i <= 10; i++) {
//			sum = sum + i;  //sum += i
//		}
//		System.out.println(sum);
//		
		//예제2 : 1~100까지 짝수만 더하기
		int sum01 = 0;
		
		for(int j = 1; j <= 100; j++) {
			
			if(j % 2 == 0) {
				sum01 = sum01 + j;
			}
			
		}
		
		System.out.println("짝수의 합 : " + sum01); //2550
		
		//홀수 더하기 (연습)
		
		int sum02 = 0;
		
		for(int k = 1; k <= 100; k++) {
			if(k % 2 == 1) {
				sum02 += k;
			}
		}
		System.out.println("홀수의 합은 : " + sum02); //2500
		
	}
	

}

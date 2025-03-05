package chapter009;

import java.util.Random;
import java.util.Scanner;

/*
 	java.util 패키지
 		: 자바에서 가장 많이 쓰이는 기능을 모아놓은 패키지
 		- 컬렉션 프레임워크, 유틸리티 (배열, 컬렉션 등), 날짜 및 시간 처리, 랜덤 값 생성, 입력기 등
 		
 */

public class JavaUtil {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		sc.close();
		
		// == Random class == //
		Random random = new Random(); // 랜덤 객체 생성
		int num = random.nextInt();
		System.out.println(num);  // 음수, 양수 무작위로 출력됨
		
		int num2 = random.nextInt(100); // 0 ~ 100 사이의 난수 생성
		System.out.println(num2);  
		
		int num3 = random.nextInt(101, 200); // 100 ~ 200 사이의 난수 생성
		System.out.println(num3);  
	}

}

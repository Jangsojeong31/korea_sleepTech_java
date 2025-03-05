package test;

import java.util.Scanner;

//1. src 폴더 내에 test 패키지 생성
//2. JavaTest_본명 class 파일 생성
//3. main 메서드 내에 문제 답안 작성

//cf) 구글링, AI Tool 사용 금지
//		: 아는 내용만 작성, 없을 경우 문제 번호만 작성하고 공란 제출

class Student {
	String name;
	int score;
	
	public Student(String name, int score) {
		this.name = name;
		this.score = score;
	}
		
}

public class JavaTest_장소정 {
	public static void main(String[] args) {
		
		// cf) 답안 작성 예시
				// 1. 서술형
				// - 기본 데이터 타입: 메모리에 데이터 값이 저장된다.
				//	int, char, long, double 등
				// 예) int a = 3;
				// - 참조 데이터 타입: 메모리에 주소값이 저장된다. 
				// String, Integer, 클래스 타입, Array 등
				// String str = "Hello";
				
				// 2. 코드 구현 문제
				int num1; // 이후 풀이 작성
				num1 = 10;
				double num2 = 3.5;
				double result = num1 + num2;
				System.out.println(result);
				
				// 3. 코드 구현 문제
				Scanner sc = new Scanner(System.in);
				int a = sc.nextInt();
				if(a % 2 == 0) {
					System.out.println("입력하신 숫자는 짝수입니다.");
				}else if(a % 2 != 0) {
					System.out.println("입력하신 숫자는 홀수입니다.");
				}
				sc.close();
				
				// 4. 코드 구현 문제
				int[] numbers = {1, 2, 3, 4, 5};
				
				for(int num: numbers) {
					System.out.println(num);
				}
				
				// 5. 코드 구현 문제
				
				Student[] students = new Student[5];
				students[0] = new Student("John", 85);
				students[1] = new Student("Jane", 92);
				students[2] = new Student("Tom", 78);
				students[3] = new Student("Emily", 88);
				students[4] = new Student("Alex", 95);
				
				for(Student student: students) {
					if(student.score >= 90) {
						System.out.println(student.name);
					}
				}
				
				// 6. 단답형
				// -> Object
				// 7. 단답형
				// -> .size()
				// 8. 단답형
				// ? :
				
				// 9. 다음 중 인터페이스에서 사용할 수 없는 것은 무엇입니까?
				// -> 3
				
				// 10. 다음 중 @FunctionalInterface에 해당하는 조건으로 올바른 것은 무엇입니까?
				// -> 2
				
				// 11: 다음 코드에서 출력 결과는 무엇입니까?
				// -> Child
				
				// 12: 싱글톤 패턴을 구현할 때 가장 일반적으로 사용되는 메서드는 무엇입니까?
				// -> 2.
				
				// 13: 추상 클래스
				// -> 1.
				
				// 14: 다운 캐스팅
				// -> animal instanceof Dog => true
				
				// 15: 빌더 패턴의 주요 이점은 무엇입니까?
				// -> 2.
				
				// 16: MVC 패턴에서 사용자의 입력을 처리하는 역할은 무엇입니까?
				// -> 2.
				
				// 17: 인터페이스의 모든 메서드는 기본적으로 어떤 접근 제어자를 가집니까?
				// -> public abstract
				
				// 18: 추상 클래스와 인터페이스의 주요 차이점 중 맞지 않는 것은 무엇입니까?
				// -> 2
	}
}

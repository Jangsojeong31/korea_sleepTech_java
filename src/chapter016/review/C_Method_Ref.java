package chapter016.review;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;

class MethodRef {
	// 정적 메서드 참조
	static void printUpperCase(String str) {
		System.out.println(str.toUpperCase());
	}
	
	// 인스턴스 메서드 참조
	void printLowerCase(String str)	{
		System.out.println(str.toLowerCase());
	}
}

// 특정 객체의 인스턴스 참조
class Calculator {
	int add(int a, int b) { // 2개의 인자
		return a + b;		// 1개의 반환값
	}
}

public class C_Method_Ref {
	public static void main(String[] args) {
		List<String> fruits = Arrays.asList("apple", "mango", "banana");
		
		// 1. 정적 메서드 참조
		fruits.forEach(MethodRef::printUpperCase);
		
		// 2. 인스턴스 메서드 참조
		List<String> fruits2 = Arrays.asList("APPLE", "MANGO", "BANANA");
		MethodRef methodRef = new MethodRef();  // 인스턴스 생성
		fruits2.forEach(methodRef::printLowerCase);
		
		// 3. 특정 객체의 인스턴스 참조
		// Function<T, R> : 하나의 인자(매개변수)를 다른 타입(반환값)으로 변환시키는 함수형 인터페이스
		// BiFunction<T, U, R> : 2개의 인자를 받고 한 개의 객체(반환값)을 리턴시키는 함수형 인터페이스
		Calculator calc = new Calculator();
		BiFunction<Integer, Integer, Integer> addition = calc::add; 
		int result = addition.apply(5, 3);
		System.out.println(result); // 8
	}

}

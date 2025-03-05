package chapter016.review;

import java.util.Arrays;
import java.util.List;

// == 람다 표현식 == //
// :  함수형 프로그래밍 표현식 >> 익명 클래스를 간결하게 표현

interface AnimalInterface {
	void speak();
}

// speak 추상 메서드를 화실표로 이름없이 구현

public class B_Lambda {
	public static void main(String[] args) {
		List<String> list = Arrays.asList("apple", "orange", "banana");
		list.sort((a, b) -> a.compareTo(b));
		// a.compareTo(b) : a와 b를 비교하여 0, 양수(오름차순), 음수(내림차순) 
		System.out.println(list); // [apple, banana, orange]
		
		// 일반 람다식
		list.forEach(name -> System.out.println(name));
		
		// 메서드 참조
		list.forEach(System.out::println);

	}
}

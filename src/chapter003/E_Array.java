package chapter003;

import java.util.ArrayList;
import java.util.Arrays;

// == 자바 배열 (정적) == //
// : 한번 생성되면 크기 변경 불가
// : 크기 변경이 필요한 경우, 변경된 크기의 배열을 생성하여 요소값을 복사

public class E_Array {
	
	public static void main(String[] args) { 
		
		int[] numbers = new int[5];
		System.out.println(Arrays.toString(numbers)); //[0, 0, 0, 0, 0]
		
		// == 동적 배열(ArryaList) 사용법 == // 
		 
		// 1. ArrayList
		// : 자바의 동적 배열 구현체
		// 크기 제한이 없다. : 동적으로 요소 추가/삭제 기능
		// Java Collection Framework의 일부: java.util.ArrayList'에서 제공
		
		// 2. ArrayList의 장점
		// : 동적 크기, 유연성, 다양한 메서드(기능) 제공
		
		// 3. ArrayList 주의점 
		
		// cf) int[] 베열 = new int[크기];
		// 		: 정적 배열의 경우 기본값이 '기본 데이터'로 지정
		// boolean[] - false
		// char[] - ''
		// int[] - 0
		// double[] - 0.0
		
		//ArrayList의 경우 기본 데이터 타입 사용 불가
		// : 참조 데이터타입만 가능
		// String (문자열)
		// int >> Integer
		// char >> Character
		// 이외의 기본 데이터타입은 첫 글자를 대문자로 작성
		
		// +) 참조 데이터 타입은 기본값이 모두 null
		// cf) null
		// : 아무 객체도 참조하지 않음을 나타내는 값 (기본 데이터 타입 사용)
		
		// +) Collection Framewrok의 모든 클래스 내부에서는 객체 구조만을 다름
		// : 기본 타입 사용 안함
		
		Integer a = null;
		
		// == ArrayList 생성 == //
		// : ArrayList<데이터타입> 변수명 = new ArrayList<>(초기용량);
		
//		int[] numberArray = new int[]; -> 오류 : 정적 배열은 크기값 미지정 시 오류
		// 크기를 명시적으로 전달하지 않을 경우 실제 요소값이라도 전달
		
		ArrayList<Integer> arrayList = new ArrayList<>();
		// : 초기 용량 미지정 시 - 기본값 10
		// > 해당 용량은 배열 사용 시 담겨있는 요소의 크기만큼만 측정
		
		System.out.println(arrayList); // []
		System.out.println(arrayList.size()); // 0
		// 용량(capacity)는 10이고 크기(size)는 0 : capacity를 넘는 데이터를 추가하려 하면 오류 발생(IndexOutOfBoundsException)
		
		// 1. ArrayList 데이터 추가 (add)
		// : 배열의 마지막에 값을 추가
		// 배열명.add(추가할 데이터) or 배열명.add(추가할 인덱스, 추가할 데이터)
		arrayList.add(10);
		arrayList.add(20);
		arrayList.add(30);
//		arrayList.add(3, 40);
//		arrayList.add(5, 50);  -> 오류 발생(IndexOutOfBoundsException) 
		// : ArrayList는 데이터가 연속된 자료 구조 -> 데이터 사이에 빈 공간 x
		
		System.out.println(arrayList); // [10, 20, 30]
		
		// 2. ArrayList 데이터 변경 (set)
		// 배열명.set(인덱스번호, 변경할 데이터);
		arrayList.set(1, 50);
		System.out.println(arrayList); // [10, 50, 30]
		
		// 3. ArrayList 데이터 삭제 (remove)
		// 배열명.remove(인덱스번호);
		arrayList.remove(2);
		System.out.println(arrayList); // [10, 50] 
		
		// 4. ArrayList 크기 확인 (size)
		// 배열명.size();
		System.out.println(arrayList.size()); // 2
		
		// +) ArrayList 원하는 위치에 데이터 삽입
		// 배열명.add(인덱스번호, 데이터값);
		arrayList.add(1, 123);
		System.out.println(arrayList); // [10, 123, 50]
		
		// +) 특정 요소 접근
		// 배열명.get(인덱스 번호)
		System.out.println(arrayList.get(1)); // 123
		
		
		
		
	}

}

package chapter15;

import java.util.Arrays;
import java.util.Comparator;

public class ArraysClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/*
		 * Arrays 클래스
		 * 
		 * 메서드 종류 : 
		 *
		 * (1) toString(배열(1차)); 
		 * -> 1차 배열을 String 문자열로 변환
		 * -> loop 없이 배열을 출력가능
		 * 
		 * 버블정렬(오름차순, 내림차순) : 
		 * (2) sort(배열);
		 * 배열의 data type은 참조형 제외 
		 * 자동으로 오름차순 정렬
		 * 내림차순은 추가적인 과정이 필요(클래스 형태 정수 데이터 타입 Integer 이용)
		 * 
		 * deep copy :
		 * (3) copyOf(복사대상, 복사길이)
		 */
		
		//배열 선언
		int[] arr = {5,7,1,4,11,9,10,2,4,3};
		
		//배열 출력
		System.out.println("정렬 전 : " + Arrays.toString(arr));
		
		//오름차순 정렬
		Arrays.sort(arr);
		
		System.out.println("정렬 후 : " + Arrays.toString(arr));
		
		//내림차순 정렬
		Integer[] arr01 = {3,4,5,2,17,24,16};
		
		System.out.println("정렬 전 : " + Arrays.toString(arr01));
		
		Arrays.sort(arr01, Comparator.reverseOrder());
		System.out.println("정렬 후 : " + Arrays.toString(arr01));
		
		//deep copy
		int[] cards = {3,7,10,11,12};
		int [] newCards = Arrays.copyOf(cards, cards.length); //System.arraycopy와의 차이
		
		System.out.println("복사 후 : " + Arrays.toString(newCards));
		
	}

}

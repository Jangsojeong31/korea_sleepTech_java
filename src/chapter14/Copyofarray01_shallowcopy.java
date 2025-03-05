package chapter14;

public class Copyofarray01_shallowcopy {
public static void main(String[] args) {
		
		/*
		 * 복사 : 똑같이 다른 개체를 만드는 것
		 * 배열의 복사
		 * (1) 얕은 복사(shallow copy) : 배열은 참조형 변수; 배열에 위치값을 대입
		 * 얕은 복사는 두개의 배열(arr01, arr02)에 하나의 공간({1,2,3}, 같은 위치값)이 대입됨
		 * 문제점 : 하나의 배열의 값을 바꿨을 때 나머지 하나도 바뀜
		 */
		
		// 얕은 복사(shallow copy) :
		int[] arr01 = {1, 3, 5, 7, 9};
		int[] arr02 = null;
		
		arr02 = arr01;
		
		for(int i = 0; i < arr01.length; i++) {
			System.out.print(arr02[i] + "\t");
		}
		
		//값 바꾸기
		arr02[1] = 4;
		arr01[0] = 8;
		
		System.out.println();
		System.out.print("arr02 값 출력 : ");
		for(int i = 0; i < arr02.length; i++) {
			System.out.print(arr02[i] + "\t");
		}
		
		System.out.println();
		System.out.print("arr01 값 출력 : ");
		for(int i = 0; i < arr01.length; i++) {
			System.out.print(arr01[i] + "\t");
		}
	}
}

package sjs01;

import java.util.Arrays;

/*
 * 정렬
 * (1)버블정렬 (오름차순)
 * 1차) 앞칸 뒤칸 비교해서 큰 숫자를 뒤로 : 마지막 칸에 가장 큰 숫자가 위치하게 됨
 * 2차) 마지막 칸 제외하고 1차와 동일하게 비교 
 * 
 */
public class Chapter12_array_3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//ex) 5칸 배열일 경우
		//1차 -> 2차 -> 3차 -> 4차까지 비교
		//1차 : 가로로 비교 (5칸) -> 2차 : 4칸 -> 3차 : 3칸 ...
		
		
		//배열에 값 대입
		int[] arr = new int[10];
		
		for(int i = 0; i < 10; i++) {
			arr[i] = (int)(Math.random() * 50) + 1;
		}
		
		//배열 출력 : Arrays 클래스
		System.out.println("정렬 전 : " + Arrays.toString(arr));
		
		//버블 정렬(오름차순) : for문으로 만들기 
		int temp = 0; 
		
		for(int i = 0; i < arr.length; i++) {
			for(int j = 0; j < (arr.length - 1) -i; j++) { // j: index 번호, 0부터 시작
			//ex) 4칸 배열 : 1차)3번 비교(arr.length-1) 
			//차수가 커지면서 비교 칸수 1씩 감소 : (arr.length-1)-i
			//1차) arr[0]과 arr[1]비교, arr[1]과 arr[2]비교, arr[2]과 arr[3]비교
				
				if(arr[j] > arr[j+1]) { //앞칸이 뒷칸보다 클 경우 -> 앞뒤 숫자 바꾸기
					temp = arr[j+1];
					arr[j+1] = arr[j];
					arr[j] = temp;
				}
			}
		}
		
		System.out.println("정렬 후 : " + Arrays.toString(arr));
		
		

	}

}

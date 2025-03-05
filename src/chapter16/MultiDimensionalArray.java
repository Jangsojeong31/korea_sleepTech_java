package chapter16;

import java.util.Arrays;

/*
 * 다차원 배열
 * 
 * 선언방식 3가지
 * 1) int[][] arr = new int[3][4]; int[행][열]
 * 2) int[][] arr01 = new int[3][]; 1차원 배열(행)만 입력(행 입력은 필수,열은 나중에 입력)
 * 3) int[][] arr02 = {{1,2,3}, {4,5,6}} ; 2행 3열
 */
public class MultiDimensionalArray {
	public static void main(String[] args) {
		
		//1차원 배열
		int[] a = {1,2,3};
		
		//2차원 배열 : 1개의 공간마다 숫자(값)이 아닌 공간(배열)을 가짐, 행렬과는 다른 개념(각각 공간의 갯수가 다른 배열을 가질 수 있다.) 
		//2차원 배열이 행렬인 것은 아니지만 행렬구조를 2차 배열로 표현 가능
		
		//2차배열 선언
		int[][] arr = new int[3][5];
		int[][] arr01 = new int[3][];
		int[][] arr02 = {{1,2,3},{4,5,6}};   //선언할때만 가능한 방식
		
		//출력
		System.out.println("2차배열 : " + arr); //주소값(참조값)이 나옴
		System.out.println("2차배열의 1차수 출력 : " + arr[1]); //주소값이 나옴
		System.out.println("2차배열의 2차수 출력 : " + arr02[1][1]); //5
		
		//열 추가해주기
//		for(int i = 0; i < arr01.length; i++) { //arr01.length : 행의 길이
//			arr01[i] = new int [3];				//결과 : int[3][3]										
//		}

		arr01[0] = new int [3];
		arr01[0][0] = 1;
		arr01[0][1] = 2;
		arr01[0][2] = 3;
		arr01[1] = new int [4];
		arr01[2] = new int [5];
		System.out.println(Arrays.toString(arr01[0]));
		System.out.println(Arrays.toString(arr01[1]));
		System.out.println(Arrays.toString(arr01[2]));

		
		
	}
	
	
}

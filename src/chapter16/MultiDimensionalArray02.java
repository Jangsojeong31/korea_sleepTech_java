package chapter16;

import java.util.Arrays;
import java.util.Scanner;

public class MultiDimensionalArray02 {
	public static void main(String[] args) {
		
		int[][] std = new int[3][3];
		Scanner scan = new Scanner(System.in);
		
		for(int i = 0; i < std.length; i++) { //i:0~2 j: 0~2으로 이중 for문으로도 가능
			System.out.print((i + 1) + " 번째 학생 국어점수! : ");
			std[i][0] = scan.nextInt();
			System.out.print((i + 1) + " 번째 학생 영어점수! : ");
			std[i][1] = scan.nextInt();
			System.out.print((i + 1) + " 번째 학생 수학점수! : ");
			std[i][2] = scan.nextInt();
		}
		
		//Arrays.toString
		for(int i = 0; i < std.length; i++) {
			System.out.println((i + 1) + " 번째 학생 : " + Arrays.toString(std[i]));
		}
		
		
		scan.close();
		
		//점수 평균내서 1등 뽑기
		int maxIndex = 0;
		int sum = 0;
		int maxSum = 0;
		
		for(int i = 0; i < std.length; i++) {
			sum = 0; //합산 초기화
			for(int j = 0; j < std[i].length; j++) {	
				sum += std[i][j];	
			}
			//합이 끝난 후 비교
			if(maxSum < sum) {
				maxSum = sum;
				maxIndex = i;
			}
		}
		
		System.out.println("성적 최우수자 : " + (maxIndex + 1) + "번 학생 : " + Arrays.toString(std[maxIndex]) + "총점 : " + maxSum);
			
		
		
		
		
		
		
	}

}

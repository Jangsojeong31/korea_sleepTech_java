package sjs01;

import java.util.Arrays;
import java.util.Scanner;

public class Practice {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
//		Scanner scan = new Scanner(System.in); //import : ctrl + shift + o
//		
//		// 실행하기 : f11
//		//sysout + ctrl + space
//		
//		
//		//업다운 게임(1)
//		
//		int target = (int)(Math.random() * 50) + 1;
//		int user = 0;
//		int count = 1;
//		
//		while(true) {  //무한루프
//			System.out.print("숫자를 입력하세요 >>> ");
//			user = scan.nextInt();
//			
//			if(target == user) {
//				System.out.println("맞췄습니다! 정답은 " + target + "입니다." + count + "번 만에 맞췄네요");
//				break;   //loop 종료
//			}else if(target > user) {
//				System.out.println("업!");
//			}else if(target < user) {
//				System.out.println("다운!");
//			}
//			
//			count++;
//		}
//		
//		scan.close();
//		
		
		//업다운 숫자 맞추기 게임(2)
		
//		int target = (int)(Math.random() * 50) + 1; //1~50
//		Scanner scan = new Scanner(System.in);
//		
//		int user = 0;
//		int count1 = 0;
//		
//
//		
//		
//		while(target != user) { //target == user이 되면 loop 종료
//			
//			System.out.print("숫자를 입력 : "); //40, 41번 코드를 위로 올리면 무한루프가 됨 
//			user = scan.nextInt();
//			
//			if(target < user) {
//				System.out.println("다운!");
//			}else if(target > user) {
//				System.out.println("업!");
//			}else {
//				System.out.println("정답! 값은 : " + target + "입니다.");
//				System.out.println((count1 + 1) +"번 만에 맞췄습니다!");
//			}
//			
//			
//			
//			count1++;	
//		}
//		scan.close();
		
//		//배열에 값 대입하기
//		int[] arr = new int[5];
//		
//		for(int i = 0; i < 5; i++) {
//			arr[i] = (int)(Math.random() * 100) + 1;
//		}
////		//배열 출력
//		System.out.println(Arrays.toString(arr));
//		
//		
//		//배열의 값 더하기
//		
//		int sum = 0;
//		
//		for(int i = 0; i < arr.length; i++) {
//			System.out.print(arr[i] + "\t");
//			sum += arr[i];
//		}
//		
//		System.out.println("합 : " + sum);
//		
//		//버블정렬
//		
//		int temp = 0;
//		
//		for(int i = 0; i < arr.length; i++) {
//			for(int j = 0; j < (arr.length - 1)-i; j++) {
//				
//				if(arr[j] > arr[j+1] ) {
//					temp = arr[j+1];
//					arr[j+1] = arr[j];
//					arr[j] = temp;
//				}
//			}
//		}
//		
//		System.out.println("정렬 후 : " + Arrays.toString(arr) );
		
//		int[][] std = new int[3][3];
//		Scanner scan = new Scanner(System.in);
//		
//		for(int i = 0; i < std.length; i++) { //i:0~2 j: 0~2으로 이중 for문으로도 가능
//			System.out.print((i + 1) + " 번째 학생 국어점수! : ");
//			std[i][0] = scan.nextInt();
//			System.out.print((i + 1) + " 번째 학생 영어점수! : ");
//			std[i][1] = scan.nextInt();
//			System.out.print((i + 1) + " 번째 학생 수학점수! : ");
//			std[i][2] = scan.nextInt();
//		}
//		
//		int sum = 0;
//		int maxSum = 0;
//		int maxIndex = 0;
//		
//		for(int i = 0; i < std.length; i++) {
//			sum = 0;
//			for(int j = 0; j < std[i].length; j++) {
//				sum += std[i][j];
//			}
//			
//			if(maxSum > sum) {
//				maxSum = sum;
//				maxIndex = i;
//			}
//		}
//		
//		System.out.println("총점이 가장 높은 학생은 : " + (maxIndex+1) + "번째 학생이며,  총점은 " + maxSum + "입니다.");
//		

	}

}

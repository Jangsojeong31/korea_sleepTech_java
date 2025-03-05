package sjs01;

public class Chapter12_array_2 {
	public static void main (String[] arg) {
		
		
		int[] arr = new int[10]; 
		
		//loop를 이용해 배열에 값 대입하기
		for(int i = 0; i < 10; i++) { //i는 index
			
			arr[i] = (int)(Math.random() * 100) + 1; //1부터 100까지 랜덤값 대입
		}
		
		
		//배열의 값들을 더하기
		int sum = 0;
		for(int i = 0; i < arr.length; i++) {
			System.out.print(arr[i]+"\t");
			sum += arr[i];
		}
		
		System.out.println("\n합 : " + sum);
		
		
		
		
		
	}

}

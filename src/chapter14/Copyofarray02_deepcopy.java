package chapter14;

public class Copyofarray02_deepcopy {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/*
		 * (2) deep copy
		 * 값들을 하나씩 대입 
		 */
		
		int[] arr01 = {1, 3, 5, 7, 9};
		int[] arr02 = new int[5];
		
		//첫번째 배열의 값들을 loop를 이용해서 두번째 배열에 대입
		for(int i = 0 ; i< arr01.length; i++) {
			arr02[i] = arr01[i];
		}
		
		arr02[1] = 11;
		arr01[0] = 8;
		
		System.out.println();
		System.out.println("arr02 값 출력 : ");
		for(int i = 0; i < arr01.length; i++) {
			System.out.print(arr02[i] + "\t");
		}
		
		System.out.println();
		System.out.println("arr01 값 출력 : ");
		for(int i = 0; i < arr01.length; i++) {
			System.out.print(arr01[i] + "\t");
			
		}	
		//두 배열의 값이 달라짐
	}

}

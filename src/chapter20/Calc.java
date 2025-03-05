package chapter20;

public class Calc {
	
	//매개변수 있고, 리턴값이 있는
	public static int sumArray(int[] nums) {
		int sum = 0;
		for(int i = 0; i < nums.length; i++) {
			sum += nums[i];
		}
		return sum;
	}
	
	static String printResult(int result) {
		return "결과 : " + result;	
	}
	
	//매개변수 있고, 리턴값이 없는
//	static void printResult(int result) {
//		sysout("결과 : " + result);	
//	}
	

}

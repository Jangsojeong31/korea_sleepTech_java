package chapter20;

public class CalcMain {
	
	public static void main(String[] args) {
		
		int[] nums = {1, 10, 12, 8, 7, 13};
		
		int sum = Calc.sumArray(nums);
		

		System.out.println(Calc.sumArray(nums));
		System.out.println(Calc.printResult(sum));
		
		
//		Calc.printResult(sum);
	}

}

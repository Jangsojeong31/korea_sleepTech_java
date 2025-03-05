package chapter20;

public class exam {
	public static void main(String[] args) {
		
		int money = 30000;
		int count = 0;
		
		while(true) {  //무한루프
			if(money < 1500) {
				System.out.println("버스를 " + count + "만큼 탔음");
				System.out.println("버스카드가 " + money + "남음! 버스카드 충전요망");
				return;  //메서드 실행 죵료의 기능(break;의 기능)
			}
			
			money -= 1500;
			count++;
		}
		
		
		
	}

}

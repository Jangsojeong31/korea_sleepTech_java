package chapter016;

/*
 	 ENUM 메서드 오버라이딩
 	 : Enum은 상수별 다른 동작 정의 가능
 	 - abstract 메서드를 선언 -> 상수별로 구현
 	 
 */
// 1.
enum Operation {
	ADD {
		public int apply(int x, int y) { // ADD 만의 동작
			return x + y;
		}
	},
	SUBTRACT {
		public int apply(int x, int y) {
			return x - y;
		}
	},
	MULTIPLY{

		@Override
		public int apply(int x, int y) {
			// TODO Auto-generated method stub
			return x + y;
		}
		
	};
	
	public abstract int apply(int x, int y); // 상수마다 동작을 강제(추상메서드를 통해, 필수로 오버라이딩하도록)
}


// 2.
enum Season {
	SPRING("봄"),
	SUMMER("여름"),
	AUTUMN("가을"),
	WINTER("겨울");
	
	private final String seasonName;
	
	Season(String seasonName){
		this.seasonName = seasonName;
	}
	
	public String getSeasonName() { return seasonName; }
}



public class C_Enum {
	public static void main(String[] args) {
		
		//1.
		System.out.println(Operation.ADD.apply(5, 3));
		System.out.println(Operation.SUBTRACT.apply(5, 3));
	
	
		// 2.
		Season season = Season.WINTER;
		switch(season) {
		case SPRING:
			System.out.println("봄이 왔어요");
			break;
		case SUMMER:
			System.out.println("여름이 왔어요");
			break;
		case AUTUMN:
			System.out.println("가을이 왔어요");
			break;
		case WINTER:
			System.out.println("겨울이 왔어요");
			break;
		}
		
		// 결과 : 겨울이 왔어요

		

	}
}

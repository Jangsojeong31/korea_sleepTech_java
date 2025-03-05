package chapter008;

// interface 정의
interface Flyable {
	int AVERAGE_SPEED = 100; // 1. 상수(public static final이  생략됨)
	
	void fly(); // 2. 추상 메서드(public abstract 가 생략됨)
	
	default void land() { // 3. default 메서드 (재정의 가능)
		System.out.println("착륙합니다.");
	}
	
	static int getWingCount() {   // 4. 정적 메서드 (재정의 불가)
		return 2;
	}
}

// interface 구현
class 참새 implements Flyable {
	public void fly() {
		System.out.println("참새의 속력은  " + AVERAGE_SPEED + "km의 평균 속도보다 느립니다.");
	}
	
	@Override
	public void land() {
		System.out.println("사뿐");
	}
}

class 독수리 implements Flyable {
	public void fly() {
		System.out.println("독수리의 속력은 " + AVERAGE_SPEED + "km의 평균 속도보다 빠릅니다.");
	}
	
	@Override
	public void land() {
		System.out.println("슈우웅");
	}
}

public class C_Interface {
	public static void main(String[] args) {
		
		참새 bird1 = new 참새();
		bird1.fly();
		bird1.land();
		
		독수리 bird2 = new 독수리();
		bird2.fly();
		bird2.land();
		
		System.out.println(Flyable.getWingCount());  // 2
		
	}
}

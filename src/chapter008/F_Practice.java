package chapter008;

// 인터페이스 연습
// : Fruit 인터페이스 정의
// color 추상 메서드
// describe 디폴트 메서드
// printType 정적 메서드

interface Fruit {
	
	// 추상 메서드
	String color();
	
	// 디폴트 메서드(재정의 가능)
	default void describe() {
		System.out.println("과일의 색상은 " + color() + "이며, 모양은 동그랗습니다.");
	}
	
	// 정적 메서드(재정의 불가)
	static void printType() {
		System.out.println("과일(Fruit)의 타입입니다.");
	}
}

class Apple implements Fruit {
	public String color() { return "red"; }
	
}

class Orange implements Fruit{
	public String color() { return "orange"; }

}

class Banana implements Fruit{
	public String color() { return "yellow"; }
	
	@Override
	public void describe() {
		System.out.println("과일의 색상은 " + color() + "이며, 모양은 깁니다.");
	}

}

// 인터페이스 추가 
interface TropicalFruit extends Fruit{  // 인터페이스끼리 확장(extends) 가능 (클래스끼리 확장, 인터페이스끼리 확장)
										// cf) implements (클래스 implements 인터페이스 : 인터페이스를 클래스로 구현)
	
	// color 추상 메서드
	// describe 디폴트 메서드
	// printType 정적 메서드
	// 가 생략되어있음(from Fruit)
	
	default void tropicalFeature() {
		System.out.println("열대 과일은 후숙하면 더 맛있습니다.");
	}
	
}

class Mango implements TropicalFruit {
	
	public String color() { return "yellow"; }
	
	@Override
	public void describe() {
		System.out.println("과일을 색상은 " + color() + "이며, 모양은 타원형입니다.");
		
	}
}





public class F_Practice {
	public static void main(String[] args) {
		
		// 다형성 적용
		Fruit apple = new Apple();
		Fruit orange = new Orange();
		Fruit banana = new Banana();
		TropicalFruit mango = new Mango(); // mango를 Mango에서 TropicalFruit로 형 변환(업캐스팅)
		
//		System.out.println(mango instanceof Mango);  //true
//		System.out.println(mango instanceof TropicalFruit); // true
//		System.out.println(mango instanceof Fruit);  // true
		
		Fruit[] fruits = { apple, orange, banana, mango };
		// mango가 TropicalFruit에서 Fruit로 형 변환(업캐스팅)
		
//		System.out.println(mango instanceof Mango);  // true
//		System.out.println(mango instanceof TropicalFruit);  // true
//		System.out.println(mango instanceof Fruit);  // true
		
		for(Fruit fruit: fruits) {
			fruit.describe();
			
			if(fruit instanceof TropicalFruit) {  // mango일 경우에
				TropicalFruit tropicalFruit = (TropicalFruit) fruit; // 다운 캐스팅
				tropicalFruit.tropicalFeature();
			}
		}
		
//		System.out.println(mango instanceof Mango);  //true
//		System.out.println(mango instanceof TropicalFruit); // true
//		System.out.println(mango instanceof Fruit);  // true
		
//		// A instanceof B
//		// : 'A' 객체가 B 클래스(종류)와 같은지 확인
		
		Fruit.printType(); // 정적 메서드
	}

}

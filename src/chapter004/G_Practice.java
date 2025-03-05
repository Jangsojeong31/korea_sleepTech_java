package chapter004;

class Card {
	// 인스턴스 변수
	int number;
	String kind;
	
	// 클래스 변수
	static int width = 100;
	static int height = 200;
	
	
}
public class G_Practice {
	public static void main(String[] args) {
		
		System.out.println(Card.width);
		System.out.println(Card.height);

		Card c1 = new Card();
		c1.number = 7;
		c1.kind = "Spade";
		
		System.out.println(c1.kind + c1.number);
		
		
	}

}

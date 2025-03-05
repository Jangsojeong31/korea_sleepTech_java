package chapter007.orderApp;

/*
 * 식품은 세금 면제
 */
public class Food extends Product {
	
	Food(String name, int price){
		super(name, price);
	}
	
	@Override
	double calculateTax() {
		return 0;
	}

}

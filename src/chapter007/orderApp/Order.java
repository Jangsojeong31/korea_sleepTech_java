package chapter007.orderApp;

/*
 * 실제 주문 로직이 구현
 * - 특정 제품(Product)과 수량을 기반으로 주문을 생성
 * - 총 가격(세금 포함)을 계산하는 역할
 * 
 */

public class Order {
	private Product product;  // Electronics와 Food 객체를 사용하려면 Product로 업캐스팅해서 사용
	private int quantity;
	
	Order(Product product, int quantity){
		this.product = product;
		this.quantity = quantity;
	}
	
	// 총 가격 계산 메서드
	double calculateTotalPrice() {
		double tax = product.calculateTax();
		double totalPrice = (product.getPrice() + tax) * quantity;
		return totalPrice;
	}
	
	// 주문 정보를 반환하는 메서드
	
	@Override  // Object 클래스의 toString() 오버라이딩
	public String toString() {
		return "Order Detail[ " + product.getName() 
				+ " * Quantity: " + quantity 
				+ " >> " + calculateTotalPrice() + " ]";
		// 출력 형태 : Order Detail[ cake * 2 >> 18000 ]
	}
	
	

}

package chapter007.orderApp;

/*
 * Electronics 클래스
 * 
 * Product(제품)를 상속받는 하위 클래스
 * 추가 기능) 전자 제품은 특별 세율 적용 : 15%
 * 
 */
public class Electronics extends Product{
	
	Electronics(String name, int price){
		super(name, price);
	}
	
	@Override
	double calculateTax() {
		return getPrice() * 0.15;
	}
	
	// getPrice() 대신 price를 쓸 수 없는 이유 : price는 private을 선언됨
	// price가 protected로 선언되었을 경우 가능하다(상속되었기 때문에)
}

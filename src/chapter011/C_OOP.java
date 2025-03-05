package chapter011;

/*
		SOLID 원칙 정리
		1) SRP 단일 책임 원칙
		2) OCP 개방 퍠쇄 원칙
		3) LSP 리스코프 치환 원칙 
		4) ISP 인터페이스 분리 원칙
		5) GIP 의존 역전 원칙
			 
 */
// == SOLID 원칙을 활용한 주문 관리 시스템 === //
// 1. SRP - Order 클래스는 주문 정보를 저장하는 역할만 담당
class Order {
	private String orderId;
	private int amount;
	
	public Order(String orderId, int amount) {
		this.orderId = orderId;
		this.amount = amount;
	}
	
	public String getOrderId() { return orderId; }
	public int getAmount() { return amount;}
	
}

// 2. OCP, DIP - 결제 프로세스를 추상화한 인터페이스 생성
interface PaymentProcessor {
	void processPayment (Order order); // 주문 객체를 받아 결체를 처리하는 메서드
}

class CreditCardPaymentProcessor implements PaymentProcessor { // 신용카드로 결제

	@Override
	public void processPayment(Order order) {
		System.out.println("신용카드로 결제합니다." + order.getOrderId());
	}
	
	
	
}

class SamSungPaymentProcessor implements PaymentProcessor{  // 삼성페이로 결제

	@Override
	public void processPayment(Order order) {
		System.out.println("삼성페이로 결제합니다. " + order.getOrderId());
	}
	
}

// 3. ISP - 주문 보고서 생성을 위한 별도의 인터페이스

interface GenerateReport {
	void generateReport(Order order);
}

class PdfReportGenerator implements GenerateReport {

	@Override
	public void generateReport(Order order) {
		System.out.println("주문 정보 보고서를 PDF 파일로 생성 " + order.getOrderId());
	}
	
}

// 4. DIP - OrderService 클래스는 결제 및 보고서 생성 인터페이스에 의존
class OrderService {
	 private final PaymentProcessor paymentProcessor;
	 private final GenerateReport generateReport;
	 
	 public OrderService(PaymentProcessor paymentProcessor, GenerateReport generateReport) {
		 this.paymentProcessor = paymentProcessor;
		 this.generateReport = generateReport;
	 }
	 
	 void placeOrder(Order order) {
		 paymentProcessor.processPayment(order);
		 generateReport.generateReport(order);
		 System.out.println("주문 완료");
	 }
}
public class C_OOP {
	public static void main(String[] args) {
		
		PaymentProcessor paymentProcessor = new CreditCardPaymentProcessor();
		GenerateReport generateReport = new PdfReportGenerator();
		
		OrderService orderService = new OrderService(paymentProcessor, generateReport);
		
		// 여러 개의 주문 객체 생성
		Order order1 = new Order("1", 18000);
		Order order2 = new Order("2", 22000);
		Order order3 = new Order("3", 15000);
		Order order4 = new Order("4", 11000);
		
		// 주문 처리 실행
		orderService.placeOrder(order1);
		orderService.placeOrder(order2);
		orderService.placeOrder(order3);
		orderService.placeOrder(order4);
		
	}

}



 	
 	
 	

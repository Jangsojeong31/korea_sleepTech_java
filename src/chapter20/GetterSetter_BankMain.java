package chapter20;

public class GetterSetter_BankMain {
	public static void main(String[] args) {
	
		
	GetterSetter_Bank b = new GetterSetter_Bank();
	
	b.setMoney(-500);
	b.setMoney(10000);
			
	System.out.println("잔금 : " + b.getMoney());
	
	}
}


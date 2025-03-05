package chapter20;

public class GetterSetter_Bank {
	
	private int money; //접근제한자 private : 외부에서 접근 불가능
	
	//입금
	public void setMoney(int money) {
		if(money < 0) {
			System.out.println("값이 잘못입력되었습니다.");
//			return; //else구문 없이 return;써도 종료됨
		}else{
			this.money = money;
		}
	}
		
		
	//돈 출력
	public int getMoney() {
		return money;
	}
	

}



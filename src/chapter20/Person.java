package chapter20;

public class Person {
	
	private int age;
	private String myName;
	
	
	public String getMyName() {
		return myName;
	}
	public void setMyName(String myName) {
		this.myName = myName;
	}
	
	
	
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		if(age < 0) {
			System.out.println("잘못 입력되었습니다.");
			return;
		}
		this.age = age;
	}
	
	

}

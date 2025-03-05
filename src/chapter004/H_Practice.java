package chapter004;

class Person {
	
	// 필드
	String name;
	int age;
	static int population;
	
	// 생성자
	Person() {
		population++;
	}
	
	Person(String name, int age) {
		this.name = name;
		this.age = age;
		population++;
	}
	
	// 메서드
	void introduce() {
		System.out.println("안녕하세요, 저는 " + name + "이고, " + age + "살입니다.");
	}
}



public class H_Practice {
	public static void main(String[] args) {
		
		Person person01 = new Person("홍길동", 25);
		
		person01.introduce(); // 안녕하세요, 저는 홍길동이고, 25살입니다.
		
		System.out.println(Person.population); // 1

		
		new Person();
		new Person();
		new Person();
		new Person();

		System.out.println(Person.population); // 5
	}

}

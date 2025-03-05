package chapter011;

/*
 		SOLID 원칙
 		
 		4) ISP(Interface Segregation Principle) : 인터페이스 분리 원칙
 		- 하나의 큰 인터페이스보다 여러 개의 작은 인터페이스 사용 권장
 		- 인터페이스의 단일 책임을 강조 cf) SRP : 하나의 클래스가 하나의 역할
 		- 클래스가 자신이 사용하지 않는 메서드에 의존하지 않아야 한다. 
 */
// 잘못된 예제 - 필요하지 않은 행위를 강제로 구현
interface Worker {
	void work();
	void eat();
}

class Robot implements Worker {

	@Override
	public void work() {
		System.out.println("로봇은 일 할 수 있다.");
	}

	@Override
	public void eat() {
		System.out.println("로봇은 음식을 먹지 않는다.");
	}
	
}

// 올바른 예제 - 각 행위의 인터페이스가 분리
interface Workable {
	void work();
}

interface Eatable {
	void eat();
}

class Employee implements Workable, Eatable{

	@Override
	public void eat() {
		System.out.println("12시부터 13시까지 점심시간입니다.");
	}

	@Override
	public void work() {
		System.out.println("9시부터 18시까지 일합니다.");
	}
	
}

class RobotClass implements Workable {

	@Override
	public void work() {
		System.out.println("로봇이 일을 합니다.");
	}
	
}

/*
 		5) DIP(Dependency Inversion Principle) : 의존역전원칙
 			- 고수준 모듈은 저수준 모듈에 의존하면 안됨
 			- 모두 추상화에 의존해야 함
 			- 세부 구현이 아닌, 추상화된 인터페이스에 의존하도록 설게
 			
 			
 */
// 잘못된 예시
class MathBook {
	void read() {
		System.out.println("수학책을 읽습니다.");
	}
}

class DIPStudent {
	private MathBook book;
	public DIPStudent() {
		this.book = new MathBook();
	}
	
	void study () {
		book.read();
	}
}

// 2) 올바른 예제 - 클래스 간의 결합도을 줄이고, 추상화에 의존 
interface Book {
	void read();
}

class ScienceBook implements Book {
	public void read() {
		System.out.println("과학책을 읽습니다.");
	}
}

class KoreanBook implements Book {
	public void read() {
		System.out.println("국어책을 읽습니다.");
	}
}

class CorrectStudent {
	private Book book;
	
	public CorrectStudent(Book book) {
		this.book = book;
	}
	
	void study() {
		book.read();
	}
}
public class B_OOP {
	public static void main(String[] args) {
		Book scienceBook = new ScienceBook();
		CorrectStudent correctStudent = new CorrectStudent(scienceBook);
		correctStudent.study(); // 과학책을 읽습니다.
	}

}

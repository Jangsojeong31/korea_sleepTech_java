package chapter19;

public class StudentMain {
	public static void main(String[] args) {
		
		Student st01 = new Student();
		Student st02 = new Student();
		
//		st01.myName = "홍길동";
		st02.myName = "고길동";
		
		st01.schoolInfo();
		System.out.println("나의 학교는 " + Student.school); //static String school = "자바고등학교";이기 때문에 
															//인스턴스 없이 가능, 클래스.필드명
		st02.schoolInfo();
		
//		Student.schoolInfo(); //: static 메서드면 가능
	}

}

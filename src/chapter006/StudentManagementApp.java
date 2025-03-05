package chapter006;

import java.util.ArrayList;

// 학생 관리 시스템
// 
class Student {
	int studentId;
	String name;
	int age;
	String major;
	double gpa;
	
	// == 생성자 == //
	Student () { // 초기화하는 생성자
		this.studentId = 0;
		this.name = "Unknown";
		this.age = 20;
		this.major = "Undeclared";
		this.gpa = 0.0;
	}
	
	Student(int studentId, String name, int age, String major, double gpa) {		
		this.studentId = studentId;
		this.name = name;
		this.age = age;
		this.major = major;
		this.gpa = gpa;
	}
	
	Student(int studentId, String name, int age){
		this.studentId = studentId;
		this.name = name;
		this.age = age;
	}
	
	// == method == //
	void printSutdentInfo() {
		System.out.println("ID: " + studentId	
				+ ", Name: " + name
				+ ", Age: " + age
				+ ", Major: " + major
				+ ", Gpa: " + gpa);
	}
	
	void updateGpa(double newGpa) {
		this.gpa = newGpa;
		
	}
	
}



// cf) Java 클래스명은 파일 이름과 동일(대소문자까지)
// : 하나의 파일에서 public 단위의 클래스는 한 개만 지정 가능
// >> public 클래스명은 파일명과 일치!
public class StudentManagementApp {

	  static ArrayList<Student> studentList = new ArrayList<>();
	  // static을 안 붙일 경우 오류: Cannot make a static reference to the non-static field studentList
	  // 아래 static 메서드에서 studentList 필드를 참조할 경우, studentList도 static 변수여야 함(인스턴스 변수 사용 불가) 
	
	// static 메서드
	// : 인스턴스화 없이 클래스 자체에서 직접 호출
	// 	 main 메서드 내부에서 다른 메서드 호출 시 반드시 해당 메서드는 static이어야 함
	 
	
	// 학생 등록 기능 메서드 (studentList에 등록)
	  static void addStudent(int studentid , String name, int age, String major, double gpa) {
		Student student = new Student(studentid, name, age, major, gpa); // 객체 생성
		studentList.add(student); // .add(리스트의 요소 타입(Student)과 일치한 데이터만 삽입 가능);
		System.out.println("학생이 등록되었습니다.");
	}
	
	// 전체 학생 출력
	static void printAllStudents() {
		System.out.println("== 전체 학생 목록 ==");
		for (Student student : studentList) {
			student.printSutdentInfo();
		}
	}
	
	// 학생 검색 : 학생 id 사용
	static void findStudentById(int studentId) {
		for (Student student: studentList) {
			if(student.studentId == studentId) {
				student.printSutdentInfo();
				return;
			}
		}
		System.out.println("해당 ID의 학생을 찾을 수 없습니다.");
	}
	
	// 평점 업데이트: 학생 ID를 사용하여 해당 학생의 평점을 업데이트
	static void updateStudentGpa(int studentId, double newGpa) {
		for (Student student: studentList) {
			if(student.studentId == studentId) {
				student.updateGpa(newGpa);
				System.out.println("평점이 업데이트 되었습니다.");
				return;
			}
		}
		
		System.out.println("해당 ID의 학생을 찾을 수 없습니다.");
	}
	
	
	// main 메서드 //
	// : 프로그램의 진입점을 제공
	// public static void main(String[] args) 형식이어야만 실행 가능
	// >>  jvm은 main 메서드가 없을 경우 해당 파일을 실행x
	public static void main(String[] args) {
		
		// 학생 등록
		addStudent(1, "이승아", 30, "슬립테크", 4.0);  // addStudent는 static 메서드이기 때문에 인스턴스 없이 호출 가능
													// 같은 클래스 내이기 때문에 메서드명으로만 호출
		addStudent(2, "이도경", 31, "슬립테크", 3.1);
		addStudent(3, "이지희", 20, "슬립테크", 4.2);
		addStudent(4, "이지훈", 17, "슬립테크", 3.3);
		// 학생 1 ~ 4가 studentList에 등록됨
		System.out.println(studentList.size()); //4
		System.out.println(studentList);
		  //[chapter006.Student@2f92e0f4, chapter006.Student@28a418fc, chapter006.Student@5305068a, chapter006.Student@1f32e575]
		
		// 전체 조회
		printAllStudents();
		
//		== 전체 학생 목록 ==
//				ID: 1, Name: 이승아, Age: 30, Major: 슬립테크, Gpa: 4.0
//				ID: 2, Name: 이도경, Age: 31, Major: 슬립테크, Gpa: 3.1
//				ID: 3, Name: 이지희, Age: 20, Major: 슬립테크, Gpa: 4.2
//				ID: 4, Name: 이지훈, Age: 17, Major: 슬립테크, Gpa: 3.3
		
		// 개인 조회 
		System.out.println("== 학생 개인 조회 ==");
		findStudentById(3);  // ID: 3, Name: 이지희, Age: 20, Major: 슬립테크, Gpa: 4.2
		findStudentById(5); // 해당 ID의 학생을 찾을 수 없습니다.

		
		// 평점 업데이트
		updateStudentGpa(1, 3.5); // 평점이 업데이트 되었습니다.

		findStudentById(1); // ID: 1, Name: 이승아, Age: 30, Major: 슬립테크, Gpa: 3.5

		
		
	}
	
	

}

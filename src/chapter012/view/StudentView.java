package chapter012.view;

//View(StudentView)
//* : 사용자와 상호작용할 수 있는 메뉴를 표시
//* - 각각의 요청에 따라 controller에게 요청값과 행위를 전달 

import java.util.List;
import java.util.Scanner;

import chapter012.controller.StudentController;
import chapter012.model.Student;

public class StudentView {
	private final Scanner scanner;
	private final StudentController controller;
	
	public StudentView() {
		this.scanner = new Scanner(System.in);
		this.controller = new StudentController();
	}
	
	public void showMenu() {
		int choice = 0;
		
		while(true) {  // 무한루프
			System.out.println("== Student Management System ==");
			System.out.println("1. 학생 추가");
			System.out.println("2. 전체 조회");
			System.out.println("3. 단건 조회");
			System.out.println("4. 학생 수정");
			System.out.println("5. 학생 삭제");
			System.out.println("6. 프로그램 종료");
			System.out.print("항목을 선택하세요 >> ");
			choice = scanner.nextInt();
			scanner.nextLine();
			
			switch (choice) {
			case 1:
				addStudentView();
				break;
			case 2:
				showAllStudentView();
				break;
			case 3:
				findStudentView();
				break;
			case 4:
				updateStudentView();
				break;
			case 5:
				removeStudentView();
				break;
			case 6:
				System.out.println("프로그램을 종료합니다.");
				scanner.close();
				return;
			default:
				System.out.println("유효하지 않은 메뉴입니다. 다시 선택하세요");
			}
			
			
		}
		
		
	}
	
	private void addStudentView() {
		System.out.print("학생 이름 : ");
		String name = scanner.nextLine();
		System.out.print("학생 나이 : ");
		int age = scanner.nextInt();
		scanner.nextLine();
		System.out.print("학생 번호 : ");
		String id = scanner.nextLine();
		
		controller.addStudent(name, age, id);
		System.out.println("학생 추가 완료");
	}
	
	
	private void showAllStudentView() {
		List<Student> students = controller.getAllStudents();
		
		for(Student student: students) {
			System.out.println(student); // student.toString()
		}
	}
	
	private void findStudentView() {
		
		System.out.print("학생 번호 : ");
		String id = scanner.nextLine();
		
		Student student = controller.findStudentByStudentId(id); // 해당 id의 학생 또는 null로 반환됨
		if(student != null) { // 해당 id의 학생이 있으면
			System.out.println(student);
		}else {
			System.out.println("해당 ID의 학생을 찾을 수 없습니다.");
		}
		
	}
	
	private void updateStudentView() {
		System.out.print("새로운 학생 이름 : ");
		String newname = scanner.nextLine();
		System.out.print("새로운 학생 나이 : ");
		int newage = scanner.nextInt();
		scanner.nextLine();
		System.out.print("새로운 학생 번호 : ");
		String newid = scanner.nextLine();
		
		boolean result = controller.updateStudent(newid, newname, newage);
		
		if(result) {
			System.out.println("학생 수정 완료");
		}else {
			System.out.println("해당 id의 학생을 찾을 수 없습니다.");
		}
	}
	
	private void removeStudentView() {
		System.out.print("학생 번호 : ");
		String id = scanner.nextLine();
		
		boolean result = controller.removeStudent(id);
		
		if(result) {
			System.out.println("학생 삭제 완료");
		}else {
			System.out.println("해당 id의 학생을 찾을 수 없습니다.");
		}

	}

}

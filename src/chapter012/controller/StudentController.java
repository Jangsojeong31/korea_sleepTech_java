package chapter012.controller;

//Controller(StudentController)
//* @Field 
//* - 학생데이터 저장(List<Student>) : 6가지 기능 수행

import java.util.ArrayList;
import java.util.List;

import chapter012.model.Student;

public class StudentController {
	private List<Student> students;
	
	public StudentController() {
		this.students = new ArrayList<Student>();
	}
	
	// 1. 학생 추가(create)
	public void addStudent(String name, int age, String studentId) {
		// 학생 추가시 id 중복 불가 : 기능 x + 메시지 출력
		Student student = findStudentByStudentId(studentId);  // 단건 조회 메서드 활용
		// >> 해당 id의 학생이 존재하지 않는 경우 null 값이 반환되어 student에 저장
		
		if(student != null) { // null이 아니면 해당 id의 학생이 이미 존재 -> 학생 추가 불가
			System.out.println("해당 id의 학생이 이미 존재합니다.");
			return;
		}
		
		students.add(new Student(name, age, studentId)); // student 값이 null 이어야 추가할 수 있다.
		

	}
	
	// 2. 전체 조회
	public List<Student> getAllStudents() {
		return students;
	}
	
	// 3. 단건 조회
	public Student findStudentByStudentId(String StudentId) {
		for(Student student: students) {
			if(student.getstudentId().equals(StudentId)) {
				return student;
			}
		}
		
		return null; // id에 해당하는 학생이 없을 경우 null 반환
	}
	
	// 4. 학생 데이터 수정
	public boolean updateStudent(String id, String newName, int newAge) {
		// id의 학생이 있는지 유무 확인
		Student student = findStudentByStudentId(id);
		
		if(student != null) {
			student.setName(newName);
			student.setAge(newAge);
			student.setStudentId(id);
			return true;
		}
		return false;
	}
	
	// 5. 학생 데이터 삭제
	public boolean removeStudent(String id) {
		// id의 학생이 있는지 유무 확인
		Student student = findStudentByStudentId(id);
		
		if(student != null) {
			students.remove(student);
			return true;
		}
		return false;
	}

}

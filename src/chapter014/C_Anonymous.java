package chapter014;

import lombok.AllArgsConstructor;
import lombok.Getter;

// == 성적 계산 프로그램 == //
// 익명 클래스 이용

@AllArgsConstructor
@Getter
class Student {
	private String name;
	private int score;
}

// 인터페이스
interface Grading {
	String calculateGrade(Student student);
}
public class C_Anonymous {
	public static void main(String[] args) {
		
		Student student1 = new Student("조승범", 85);
		Student student2 = new Student("진상영", 90);
		Student student3 = new Student("윤대휘", 100);
		Student student4 = new Student("정규민", 80);
		Student student5 = new Student("박성욱", 95);
		
		// 익명 클래스
		Grading grading = new Grading() {
			
			@Override
			public String calculateGrade(Student student) {
				// TODO Auto-generated method stub
				int score = student.getScore();
				if(score > 100 || score < 0) {
					System.out.println("잘못된 점수입니다.");
					return null;
				}else if (score >= 90) {
					return "A";
				}else if (score >= 80) {
					return "B";
				}else if (score >= 70) {
					return "C";
				}else if (score >= 60) {
					return "D";
				}else {
					return "F";
				}
			}
		};
			
		System.out.println(student1.getName() + "의 성적 : " + grading.calculateGrade(student1)); // "조승범의 성적 : B"
		
		
	}

}

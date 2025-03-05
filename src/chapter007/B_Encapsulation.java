package chapter007;

/*
 	캡슐화
 	: OOP에서 데이터와 해당 데이터를 처리하는 함수(메서드)를 하나로 묶는 것을 의미
 	- 객체 내부의 구현을 숨기고 외부에서는 제공된 메서드를 통해서만 접근하도록 설정
 	- 목적 : 데이터 보호, 유지보수성 향상, 사용자 편의성 증대
 	
 */

// == getter & setter == //
// : 캡슐화된 데이터에 안전하게 접근하고 수정할 수 있도록 하는 기능 
// +) 데이터의 무결성 유지와 정보 은닉

// cf) 데이터 보호/유지보수성 향상을 목적으로 데이터 필드(속성)를 private 선언
// 	>> 데이터에 접근하거나 수정할 때는 getter & setter 메서드를 사용 

// 1) getter: 객체의 특정 필드값을 '읽는' 메서드
		// get<필드명>();
//			ex) getName, getAge ...

// 2) setter: 객체의 특정 필드값을 '설정'하는 메서드
//		set<필드명>();
// 		ex) setName, setAge ...

// == 예시) 학생 정보 관리 클래스 == //
class Student {
	private String name;
	private int residentNumber;  // 주민등록번호
	private int age;
	private int  score;
	
	//getter & setter
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	public String getAge() {  // return값이 String이기 때문에 반환타입 String으로 바꿔주기
		// getter는 단순히 데이터 반환 뿐만 아니라, 데이터 가공 역할을 담당하기도 함.
		if(age > 19) {
			return "성인";
		} else {
			return "미성년자";
		}
		 
	}
	public void setAge(int age) {
		if(age < 0) {   // 데이터의 무결성 유지 (유효성 검사)
			System.out.println("유효하지 않은 나이입니다.");
		} else {
		this.age = age; 
		}
	}
	
	public void setResidentNumber(int residentNumber) {
		this.residentNumber = residentNumber;
	}
	
	
	public int getScore() { return score; }
	public void setScroe(int score) { 
		if(score >= 0 && score <= 100) {
		this.score = score; 
		} else {
			System.out.println("유효하지 않은 점수입니다.");
		}
	}	
	
}


public class B_Encapsulation {
	public static void main(String[] args) {
		
		Student student1 = new Student();
		
		student1.setAge(29);
		student1.setAge(-3);  // 유효하지 않은 나이입니다.
		student1.setName("이승아");
		student1.setResidentNumber(1234567);
		student1.setScroe(101);  // 유효하지 않은 점수입니다.
		
		student1.setResidentNumber(9999999);
		// 주민번호 같은 경우는 바뀌면 안됨
		// 데이터의 불변성이 지켜지지 않음
		// >> final 키워드 사용
		
		
		
	}

}

// a_hello : 하나의 단어를 가독성을 위해 _로 구분
// a-hello : 서로 다른 단어를 '-'로 연결
// 더블 클릭했을 때 차이 발생

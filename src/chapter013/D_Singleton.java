package chapter013;

/*
 * 	Singleton 패턴
 * 	: 소프트웨어 설계 패턴 중 하나
 * 	- 클래스의 '인스턴스가 하나만 생성'되도록 보장
 * 	- 해당 클래스의 인스턴스에 전역적 접근을 제공하지만 일관된 상태를 유지
 * 
 * 	1) 사용 목적
 * 	- 객체의 유일성 보장
 * 	- 자원의 절약
 * 
 * 	2) 장단점
 * 	- 장점
 * 		: 자원의 중복 생성 방지 > 메모지 사용 최적화
 * 		: 전역 상태 공유 + 통제된 접근
 * 	- 단점
 * 		: 전역 상태 관리 + 다른 클래스에 영향(결합의 가능성)
 * 		: 테스트가 어려움
 * 
 *  3) 사용 방법
 */
class Singleton {
	// 필드값 : static - 인스턴스화 없이 호출하기 위해
	private static Singleton instance;
	
	// 생성자 : private
	// - 외부에서 직접적인 인스턴스화 불가
	private Singleton () {};
	
	// 싱글톤 패턴의 전역 접근성 제공하는 메서드 정의(인스턴스화 담당)
	public static Singleton getInstance() {
		// 주로 getInstance를 메서드명으로
		if(instance == null) {
			// 필드에 초기화 이전 >> 아직 인스턴스화 x
			instance = new Singleton(); // 인스턴스화 진행
			
		}
		
		return instance;
		// 1) if 조건문이 true라면 인스턴스화된 객체를 반환
		// 2) if 조건문이 false라면 기존의 필드에 객체를 반환
		
		// >> 객체는 반드시 단 하나!
	}
	
}

// 교장 선생님 클래스
class SchoolPrincipal {
	// 유일한 객체를 저장할 변수
	// : 클래스 그 자체의 객체값 저장
	private static SchoolPrincipal instance;
	
	// 1. 생성자를 private으로 만들어 다른 곳에서 객체 생성이 불가하도록 설정
	// >> 해당 클래스 외부에서 객체 생성 불가
	private SchoolPrincipal() {
		System.out.println("교장 선생님 객체 생성");
	}
	
	// 2. getInstance() 메서드를 통해 객체 생성
	// >> 해당 클래스로 생성된 객체가 없는 경우에만 새롭게 생성하여 반환
	public static SchoolPrincipal getInstance() {
		if(instance == null) {
			// 객체가 없다면 인스턴스 생성
			instance = new SchoolPrincipal();
		}
		return instance; // 기존 객체 or 생성 객체 반환
	}
	
	// 메서드
	public void announce() {
		System.out.println("공부 열심히 하고 운동 열심히 해라!");
	}
	
	
}
public class D_Singleton {
	public static void main(String[] args) {
		
		SchoolPrincipal principal1 = SchoolPrincipal.getInstance();  // "교장 선생님 객체 생성"
		// instance == null : 새로운 객체 생성
		SchoolPrincipal principal2 = SchoolPrincipal.getInstance();
		SchoolPrincipal principal3 = SchoolPrincipal.getInstance();
		SchoolPrincipal principal4 = SchoolPrincipal.getInstance();
		// 2, 3, 4 : 기존의 instance의 주소를 반환  // return instance;
		
		System.out.println(principal1); // chapter13.SchoolPrincipal@5f150435
		System.out.println(principal2); // chapter13.SchoolPrincipal@5f150435
		System.out.println(principal3); // chapter13.SchoolPrincipal@5f150435
		System.out.println(principal4); // chapter13.SchoolPrincipal@5f150435
		
		System.out.println(principal1 == principal2); // true
		
		principal1.announce();  // "공부 열심히 하고 운동 열심히 해라!"

	}

}

package chapter013;

//import lombok.AllArgsConstructor;
//import lombok.Getter;
//import lombok.RequiredArgsConstructor;
//import lombok.Setter;
//import lombok.ToString;
import lombok.*; // 위의 모든 import를 대체 (롬복 라이브러리 내의 전체 클래스 import) - 권장은 안함, 필요한 것만 호출 권장

/*
 	Lombok 라이브러리
 	: 보일러플레이트 코드를 줄여주는 '라이브러리'
 	- 어노테이션을 사용하여 코드를 간결하게 만들어줌
 	
 	cf) 프레임워크 vs 라이브러리
 	1) 프레임워크
 		: 개발자가 따라야하는 가이드 제공
 		- Frame(틀) + Work(일하다)
 		
 	2) 라이브러리
 		: 개발자가 만들어낸 클래스들의 나열
 		- 원하고자 하는 기능을 라이브러리 내에서 추출하여 사용
 		
 	>> 프레임워크가 개발자를 제어
 		개발자가 라이브러리를 제어
 		
 	cf) 보일러플레이트 코드
 		: 프로그래밍에서 반복되는 작업이나 패턴에 대한 일종의 표준화된 코드 (반복적인 코드)
 			ex) getter / setter
 	
 	롬복 라이브러리의 어노테이션 종류
 	1. @Getter / @Setter
 		: 필드에 대한 getter와 setter 메서드 자동 생성
 		
 	2. @ToString
 		: 클래스의 toString 메서드를 자동으로 구현
 		- 객체를 출력하는 경우 지정된 형식으로 출력
 		- 클래스명(필드명 1=필드값 1, 필드명 2=필드값 2, ...)
 		
 	3. 생성자 어노테이션
 		cf) 매개변수 - parameter(params) / 인자(인수) - argument(args)
 		1) @NoArgsConstructor
 		2) @AllArgsConstructor
 		3) @RequiredArgsConstructor
			 cf) RequiredArgsConstructor
			 		: 필수값을 매개변수로 받는 생성자
			 		- final 필드값 또는 @NonNull 어노테이션을 매개변수로 받음
			 		
 	4. @Data 어노테이션
 		: @Setter, @Getter, @ToString, @RequiredArgsConstructor, @EqualAndHashCode 어노테이션을 
 			한번에 적용하는 어노테이션
 		
 		cf) @EqualsAndHashCode
 			: 두 객체의 내용이 같은지(동등성) 비교, 두 객체가 같은 객체인지(동일성) 비교 연산자
 			>> boolean으로 반환
 	
 	5. @Builder 어노테이션
 		: 복잡한 객체를 생성할 때 사용하는 빌더 패턴을 자동으로 구현
 		- @Builder 어노테이션을 사용하는 경우
 			>> 필드값을 모드 메서드 체이닝으로 가져옴(선택 필드의 메서드명이 필드명)
 			>> 필수값을 builder()의 메서드 인자로 받지 x
 				: 메서드 체이닝에서 누락 시 오류
 		
 */
@Data
//@Setter
//@Getter
//@ToString
// 위의 어노테이션 + @RequiredArgsConstructor : @Data로 대체

//@NoArgsConstructor
// : 필드에 final 값이 있는 경우 빈 생성자 호출이 불가
@AllArgsConstructor		 // title, author을 매개변수로 가짐
//@RequiredArgsConstructor // title(필수값)을 매개변수로 가짐
@Builder
class LombokClass {
	
	
	private final String title;
	@NonNull // null 값이 들어갈 수 없음 (필드값 필수 지정)
	private String author;
	
	// 1. getter/setter
	// : public 접근제한자 사용
	// - getter는 필드 타입의 반환타입을 가지는 메서드
	// - setter는 필드의 타입과 필드명의 매개변수를 가지는 메서드
	// ex) public String getTitle() { return title; }
	//		public void setAuthor(String author) { this.author = author; }
	

	
}

public class H_Lombok {
	public static void main(String[] args) {
//		LombokClass lombokClass = new LombokClass();  // 빈생성자가 호출을 안했기 때문에 오류
//		System.out.println(lombokClass);  //LombokClass(title=null, author=null)
//		lombokClass.setTitle("백설공주");
//		lombokClass.setAuthor("이도경");
//		System.out.println(lombokClass); // LombokClass(title=백설공주, author=이도경)
		
//		LombokClass lombokClass1 = new LombokClass("백설공주"); // 자동으로 String title에 할당됨 (필수값이기 때문에)
//		lombokClass1.setTitle("신데렐라"); // 오류 -> final 필드는 재할당 불가
		// : @Setter 는 final 필드에 대해서는 메서드 생성 x
		
		LombokClass lombokClass2 = new LombokClass("신데렐라", "이승아");
//		System.out.println(lombokClass1);
		System.out.println(lombokClass2);
		
		LombokClass lombokClass3 = LombokClass.builder()
				.author("루피") // 메서드명이 필드명
				.build();
		// author 필드는 @NonNull 지정되어 있기 때문에 null(기본값)으로 지정 불가(할당이 이루어져야 함)
		// cf) final 필드는 null값 할당 가능
		System.out.println(lombokClass3);


	}

}

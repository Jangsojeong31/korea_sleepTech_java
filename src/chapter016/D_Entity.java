package chapter016;

import lombok.AllArgsConstructor;
import lombok.Getter;

// == DTO, VO, DAO, Entity == //
// : 데이터를 목적에 따라 정의하는 구조

/*
 	DTO(Data Transfer Object)
 		: 데이터를 전달하기 위한 객체
 	VO(Value Object)
 		: 값 자체를 표현하는 객체
 	DAO(Data Access Object)
 		: DB에 접근하는 역할을 하는 객체
 	Entity
 		: 실제 DB 테이블과 매핑(1:1로 연관)되는 클래스
 		
 	1) DTO
 		: 계층 간 데이터 교환 역할
 		- 로직을 가지지 않는 순수한 데이터 객체(Getter/Setter 만을 가짐)
 		- 주로 DB에서 데이터를 가져오거나 (프론트엔드와의)통신에서 요청/응답 데이터를 담아 전달할 때 사용
 */
class UserSignInRequestDto {
	// 로그인 할때 정보 일치 유무 확인
	private String userId;
	private String password; 
}
/*
 	2) VO
 		: 값을 표현
 		- 데이터를 담는 용도, 불변성을 가짐(읽기 전용) - 한 번 생성되면 내용 변경이 불가
 		- 주로 필드값에 final 선언, Getter 만을 가짐 (Setter로 재대입 x)
 		
 */
@AllArgsConstructor
@Getter
class Address {
	private final String city;
	private final String zipcode;
}
/*
 	3) DAO
 		: DB 접근
 		- 서비스 모델과 DB를 연결
 		- 데이터의 CRUD 작업을 시행하는 클래스
 		- 비즈니스 로직에서 DB의 직접적인 조작없이 데이터를 다룸 
 */

@AllArgsConstructor
class UserSignInResponseDto {  // 사용자 로그인 후 사용자 정보(id, nickname)을 포함하여 응답
	private String userId;
	private String nickname;
	
	
	
}

class UserDao { // 사용자 데이터베이스와 연관된 작업을 모두 명시
	// 로그인한 사용자 데이터 단건 조회
	public UserSignInResponseDto getUserById(String userId) {
		String id = "qwe";
		String nickname = "개구리";
		
		return new UserSignInResponseDto(id, nickname); // UserSignInResponseDto 타입 객체를 생성하여 반환
	}
}
/*
 	4) Entity(실제)
 	: 데이터베이스의 테이블에 해당하는 데이터구조와 일치하는 클래스
 	- JPA(Jav Persistance API)와 같은 ORM 툴에서 사용
 	- DB의 각 레코드와 매핑(테이블 형식을 다룸)
 */
class User {
	private Long id;
	private String userId;
	private String password;
	private String name;
	private String email;
	private int date;
	
}
public class D_Entity {

}

package chapter015.signUp;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class UserService {
	// 회원가입 (dto 정보 받아서 user 생성)
	// 요청값 : UserSignUpRequestDto
	// 반환값 : User

	public static User signUp(UserSignUpRequestDto dto) {
		User user = null;
		
		try {
			// 회원 유효성 검증
			// : 비밀번호와 비밀번호 확인 값의 일치 유무 검증
			String password = dto.getPassword();
			String passwordCheck = dto.getPasswordCheck();
			
			if(!password.equals(passwordCheck)) { // 일치하지 않을 경우
				throw new Error("비밀번호와 비밀번호 확인이 일치하지 않습니다."); // 예외 발생
			}
			
			Long id = 1L; // 데이터베이스의 역할을 대신!
			Date nowDate = new Date(); // 회원가입을 하는 시점 저장
			
			user = User.builder()
					.id(id)  // dto에 없는 값을 할당
					.userId(dto.getUserId())
					.password(password) // dto에 없는 값을 할당
					.username(dto.getUsername())
					.email(dto.getEmail())
					.phone(dto.getPhone())
					.nickname(dto.getNickname())
					.signUpDate(nowDate) // dto에 없는 값을 할당
					.build();
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return user;
	}
	
	
	public static void main(String[] args) {
		UserSignUpRequestDto dto1 = new UserSignUpRequestDto("qwe123", "qwe123!!", "qwe123!!", "이승아"
				, "qwe123@naver.com", "010-1234-5678", "개구리");
		UserSignUpRequestDto dto2 = new UserSignUpRequestDto("qwe123", "qwe123!!", "qwe123!!", "이승아"
				, "qwe123@naver.com", "010-1234-5678", "개구리");
		
		User user1 = signUp(dto1); // dto로 user 생성
		System.out.println(user1.getSignUpDate());  // 회원가입 일자 출력
		
		List<User> userList = null;
		List<UserSignUpRequestDto> dtos = new ArrayList<UserSignUpRequestDto>();
		dtos.add(dto1);
		dtos.add(dto2);
		
		userList = dtos.stream()  // dto들을 한꺼번에 user로 
				.map(dto -> signUp(dto))
//				.map(UserService::signUp) // static 메서드 참조
				.collect(Collectors.toList());
		
		userList.forEach(System.out::println);
		
		
		
	}

}

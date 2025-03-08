package todo_app.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class UserSignUpRequestDto { // 회원가입

	private String name;
	private String userId;
	private String password;
	private String email;
	
}

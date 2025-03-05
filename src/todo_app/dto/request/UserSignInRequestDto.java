package todo_app.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class UserSignInRequestDto { // 로그인

	private String userId;
	private String password;
	
}

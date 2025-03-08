package todo_app.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class UserResponseDto {

	private String name;
	private String userId;
	
	@Override
	public String toString() {
		return "이름: " + name + " / 아이디: " + userId;
	}
	
}

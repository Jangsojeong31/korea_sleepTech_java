package todo_app.service;

import java.util.List;

import todo_app.dto.request.UserSignInRequestDto;
import todo_app.dto.request.UserSignUpRequestDto;
import todo_app.dto.response.UserResponseDto;
import todo_app.entity.User;

public interface UserService {
	
	void signUp(UserSignUpRequestDto dto);
	void signIn(UserSignInRequestDto dto);
	void logout(String userId);
	public List<UserResponseDto> listAllUsers();
	void deleteUser(String userId);

}

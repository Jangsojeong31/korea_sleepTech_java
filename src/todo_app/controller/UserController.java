package todo_app.controller;

import java.util.List;

import todo_app.dto.request.UserSignInRequestDto;
import todo_app.dto.request.UserSignUpRequestDto;
import todo_app.dto.response.UserResponseDto;
import todo_app.service.UserService;
import todo_app.service.impl.UserServiceImpl;

public class UserController {

	private UserService service;
	
	public UserController () {
		this.service = new UserServiceImpl();
	}
	
	public void signUp(UserSignUpRequestDto dto) {
		service.signUp(dto);
		System.out.println("회원가입이 완료되었습니다.");
	}
	
	public void signIn(UserSignInRequestDto dto) {
		service.signIn(dto);
	}
	
	public void logout(String userId) {
		service.logout(userId);
	}
	
	public List<UserResponseDto> getAllUsers() {
		List<UserResponseDto> users = service.listAllUsers();
		return users;
		
	}
	
	
	public void deleteUser(String userId) {
		service.deleteUser(userId);
		System.out.println("탈퇴가 완료되었습니다.");
	}
	
	
}

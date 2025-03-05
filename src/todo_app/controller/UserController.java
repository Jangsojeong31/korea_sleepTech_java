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
	};
	
	public void signIn(UserSignInRequestDto dto) {
		service.signIn(dto);
	};
	
	public List<UserResponseDto> getAllUsers() {
		List<UserResponseDto> users = service.listAllUsers();
		return users;
		
	}
	
	public UserResponseDto getUserById(String userId) {
		UserResponseDto user = service.findUserById(userId);
		return user;
	}
	
	public void logout() {
		service.logout();
	};
	
	public void withdraw(String userId) {
		service.deleteUser(userId);
	};
	
	
}

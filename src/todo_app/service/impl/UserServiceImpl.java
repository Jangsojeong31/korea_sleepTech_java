package todo_app.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import todo_app.dto.request.UserSignInRequestDto;
import todo_app.dto.request.UserSignUpRequestDto;
import todo_app.dto.response.UserResponseDto;
import todo_app.entity.User;
import todo_app.repository.UserRepository;
import todo_app.service.UserService;

public class UserServiceImpl implements UserService {
	
	private UserRepository repository;
	private boolean isLoggedIn;
	
	public UserServiceImpl() {
		this.repository = new UserRepository();
	}

	@Override
	public void signUp(UserSignUpRequestDto dto) {
		// TODO Auto-generated method stub
		User user = new User(dto.getUserId(), dto.getPassword()
				, dto.getName(), dto.getEmail());
		repository.save(user);
		
	}

	@Override
	public void signIn(UserSignInRequestDto dto) {
		// TODO Auto-generated method stub
		if(repository.findById(dto.getUserId()) != null) {
			isLoggedIn = true;
			System.out.println("로그인 되었습니다.");
		}
	}


	@Override
	public void logout() {
		if(isLoggedIn) {
			isLoggedIn = false;
			System.out.println("로그아웃 되었습니다.");
		} else {
			System.out.println("잘못된 접근입니다.");
		}
		// TODO Auto-generated method stub
		
	}

	
	public List<UserResponseDto> listAllUsers() {
		
		List<User> users = repository.findAll();
		
		List<UserResponseDto> responseDtos = users.stream()
				.map(user -> new UserResponseDto(user.getUserId(), user.getName()))
				.collect(Collectors.toList());
		return responseDtos;
	}

	@Override
	public UserResponseDto findUserById(String userId) {
		User user = repository.findById(userId);
		UserResponseDto responseDto = new UserResponseDto(user.getUserId(), user.getName());
		return responseDto;
	}

	@Override
	public void deleteUser(String userId) {
		repository.deleteById(userId);
		
	}
}

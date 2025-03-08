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
	
	private final UserRepository repository;
	
	
	public UserServiceImpl() {
		this.repository = new UserRepository();
	}

	@Override
	public void signUp(UserSignUpRequestDto dto) {
		// TODO Auto-generated method stub
		User user = new User(dto.getName(), dto.getUserId(), dto.getPassword()
				,  dto.getEmail());
		repository.save(user);
		
	}

	@Override
	public void signIn(UserSignInRequestDto dto) {
		// TODO Auto-generated method stub
		User user = repository.findById(dto.getUserId());
		if(user != null) {
			user.setLoggedIn(true); 
			System.out.println("아이디 [" + dto.getUserId() + "]님이 로그인되었습니다.");
		}else {
			System.out.println("잘못된 접근입니다.");
		}
	}


	@Override
	public void logout(String userId) {
		try {
			User user = repository.findById(userId);
			if(user.isLoggedIn() && repository.findById(userId) != null) {
				user.setLoggedIn(false); 
				System.out.println("아이디 [" + userId + "]님이 로그아웃되었습니다.");
			} else {
				System.out.println("잘못된 접근입니다.");
			}
		} catch (NullPointerException e)  {
		    e.printStackTrace(); // 예외 발생 위치 확인
		}
	
	}

	
	public List<UserResponseDto> listAllUsers() {
		
		List<User> users = repository.findAll();
		
		List<UserResponseDto> responseDtos = users.stream()
				.map(user -> new UserResponseDto( user.getName(), user.getUserId()))
				.collect(Collectors.toList());
		return responseDtos;
	}

	@Override
	public void deleteUser(String userId) {
		repository.deleteById(userId);
		
	}
}

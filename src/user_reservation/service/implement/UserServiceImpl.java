package user_reservation.service.implement;

import java.util.Optional;

import user_reservation.entity.User;
import user_reservation.repository.UserRepository;
import user_reservation.service.UserService;

public class UserServiceImpl implements UserService{
	
	private final UserRepository userRepository;
	private User loggedUser;
	
	public UserServiceImpl() {
		this.userRepository = new UserRepository();
	}

	@Override
	public void registerUser(String userId, String password, String name, String email) {
		// TODO Auto-generated method stub
		// 중복 ID 확인
		Optional<User> optionalUser = userRepository.findByUserId(userId);
		
		// 옵셔널데이터.get()
		if(optionalUser.get() != null) { 
			System.out.println("해당 ID의 유저가 존재합니다. 다시 시도해주세요.");
			return;
		}
		User newUser = new User(userId, password, name, email); 
		userRepository.save(newUser);
		System.out.println("사용자 회원가입 완료: " + name);
	}

	@Override
	public void login(String userId, String password) {
		// TODO Auto-generated method stub
		userRepository.findByUserId(userId).ifPresentOrElse(user -> {
			// userID에 일치하는 정부는 확인
			// +) 일치하는 user의 비밀번호가 일치자는지 확인
			if(user.getPassword().equals(password)) {
				loggedUser = user;
				System.out.println("로그인 성공");
				
			}else {
				System.out.println("로그인 실패: 비밀번호 불일치");
			}
		}, () -> System.out.println("로그인 실패: 아이디를 찾을 수 없습니다."));
	}

	@Override
	public void logout() {
		// TODO Auto-generated method stub
		if(loggedUser != null) {
			// 로그인 중	
			System.out.println("로그아웃 성공 : "+ loggedUser.getName());
			loggedUser = null;
		}else {
			System.out.println("로그인 상태가 아닙니다. 로그아웃할 수 없습니다.");
		}
		
	}

	@Override
	public boolean isLoggedIn() {
		// TODO Auto-generated method stub
		boolean result = loggedUser != null;
		
		return result;
	}

}

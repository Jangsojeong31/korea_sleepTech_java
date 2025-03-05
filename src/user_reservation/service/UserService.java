package user_reservation.service;

public interface UserService {
	void registerUser(String userId, String password, String name, String email);
	void login(String userId, String password);
	void logout();
	boolean isLoggedIn(); // 사용자의 로그인 유무 확인
	
	
}

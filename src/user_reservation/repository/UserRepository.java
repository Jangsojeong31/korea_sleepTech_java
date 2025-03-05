package user_reservation.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import user_reservation.entity.User;

public class UserRepository {
	private final List<User> users = new ArrayList<User>();
	
	public void save(User user) {
		users.add(user);
	}
	
	public Optional<User> findByUserId(String userId){
		// isPresentOrElse() : 존재할 경우 isPresent 로직 처리 / 그렇지 않은 경우 orElse 로직 처리
		
		return users.stream()
				.filter(user -> user.getUserId().equals(userId)).findFirst();
	}

}

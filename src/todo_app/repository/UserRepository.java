package todo_app.repository;

import java.util.ArrayList;
import java.util.List;
import todo_app.entity.User;

public class UserRepository {
	private final List<User> userList = new ArrayList<>();

	public void save(User newuser){
		userList.add(newuser);
	}
	
	
	public List<User> findAll(){
		return userList;
	}
	
	public User findById(String userId) {
	    for (User user: userList) {
	        if (user != null && user.getUserId().equals(userId)) {
	            return user;
	        }
	    }
	    return null;
	}
	
	public void deleteById(String userId) {
		userList.removeIf(user -> user.getUserId().equals(userId));
	}
}

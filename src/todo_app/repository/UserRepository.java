package todo_app.repository;

import java.util.ArrayList;
import java.util.List;

import todo_app.entity.User;

public class UserRepository {
	List<User> userList = new ArrayList<>();

	public void save(User newuser){
		userList.add(newuser);
	}
	
	
	public List<User> findAll(){
		return userList;
	}
	
	public User findById(String userId) {
		for(User user : userList) {
			if(user.getUserId().equals(userId)) {
				return user;
			}
		}
		return null;
	}
	
	public void deleteById (String userId) {
		for(User user : userList) {
			if(user.getUserId().equals(userId)) {
				userList.remove(user);
			}
		}
	}
}

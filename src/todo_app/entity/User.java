package todo_app.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class User {
	private String name;
	private String userId;
	private String password;
	private String email;
	
	private boolean isLoggedIn;
	
	public User( String name, String userId, String password, String email) {
		this.name = name;
		this.userId = userId;
		this.password = password;
		this.email = email;
	}
	

}

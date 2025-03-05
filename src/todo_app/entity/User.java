package todo_app.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class User {
	private String userId;
	private String password;
	private String name;
	private String email;
}

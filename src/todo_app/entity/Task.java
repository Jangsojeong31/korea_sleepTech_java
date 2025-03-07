package todo_app.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;


@AllArgsConstructor
@Getter
@Setter
public class Task {
	private int todoId;
	private String deadline;
	private String content;

	public boolean isDone;  // 할일 완료 -> true
	
	
	public Task( String deadline, String content) {
		this.deadline = deadline;
		this.content = content;
		this.isDone = false;
	}
	
	
	public void completeTask() {
		this.isDone = true;
	}
	
}

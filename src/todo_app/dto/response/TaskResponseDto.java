package todo_app.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import todo_app.entity.Task;

@Getter
@AllArgsConstructor
public class TaskResponseDto {
	private int todoId;
	private String author;
	private String content;
	
	public TaskResponseDto(Task task) {
		this.todoId = task.getTodoId();
		this.author = task.getAuthor();
		this.content = task.getContent();
	}
	
	public static TaskResponseDto fromEntity(Task task) {
		return new TaskResponseDto(task);
	}
	
	@Override
	public String toString() {
		return "[" + todoId + "] 작성자 : " + author 
				+ ", 할일 : " + content;
	}

}

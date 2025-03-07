package todo_app.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import todo_app.entity.Task;

@Getter
@AllArgsConstructor
public class TaskResponseDto {
	private int todoId;
	private String deadline;
	private String content;
	
	public TaskResponseDto() {}
	
	public TaskResponseDto(Task task) {
		this.todoId = task.getTodoId();
		this.deadline = task.getDeadline();
		this.content = task.getContent();
	}
	
	public static TaskResponseDto fromEntity(Task task) {
		return new TaskResponseDto(task);
	}
	
	@Override
	public String toString() {
		return "[" + todoId + "] 할일 : " + content + " " + deadline + "까지";
	}

}

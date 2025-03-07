package todo_app.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import todo_app.entity.Task;

@AllArgsConstructor
@Getter
public class TaskRequestDto {
	
	private String deadline;
	private String content;
	
	public Task toEntity() {
		// 요청값으로 Board 객체 생성
		return new Task(deadline, content);
	}

}

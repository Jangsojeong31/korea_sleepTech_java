package todo_app.service;

import java.util.List;

import todo_app.dto.request.TaskRequestDto;
import todo_app.dto.response.TaskResponseDto;
import todo_app.entity.Task;

public interface TaskService {
	
	void createTask(TaskRequestDto dto);
	List<TaskResponseDto> findAllTasks();
	TaskResponseDto findTaskByAuthor(String author);
	public void updateTask(int todoId, TaskRequestDto dto);
	void deleteTask(int todoId);
	
//	List<Task> checkUncompletedTask();
//	public void completeTask(int todoId);
}

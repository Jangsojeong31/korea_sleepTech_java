package todo_app.service;

import java.util.List;

import todo_app.dto.request.TaskRequestDto;
import todo_app.dto.response.TaskResponseDto;
import todo_app.entity.Task;

public interface TaskService {
	
	void createTask(TaskRequestDto dto);
	List<TaskResponseDto> findAllTasks();
	TaskResponseDto findTaskByContent(String content);
	public void updateTask(int todoId, TaskRequestDto dto);
	void deleteTask(int todoId);
	
	List<TaskResponseDto> checkUncompletedTask();
	public void completeTask(String content);
}

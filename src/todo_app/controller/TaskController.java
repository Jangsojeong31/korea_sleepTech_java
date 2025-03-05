package todo_app.controller;

import java.util.List;

import todo_app.dto.request.TaskRequestDto;
import todo_app.dto.response.TaskResponseDto;
import todo_app.entity.Task;
import todo_app.service.TaskService;
import todo_app.service.impl.TaskServiceImpl;

public class TaskController {
	private final TaskService service;
	
	public TaskController () {
	this.service = new TaskServiceImpl();
	}
	
	public void creatTask(TaskRequestDto dto) {
		service.createTask(dto);
		System.out.println("할일이 추가되었습니다.");
	};
	
	public List<TaskResponseDto> getAllTasks() {
		return service.findAllTasks();
	};
	
	public TaskResponseDto getTaskByAuthor(String author) {
		return service.findTaskByAuthor(author);
	};
	
	public void updateTask(int todoId, TaskRequestDto dto) {
		service.updateTask(todoId, dto);
		System.out.println("할일이 수정되었습니다.");
	};
	
	public void deleteTask(int todoId) {
		service.deleteTask(todoId);
		System.out.println("할일이 삭제되었습니다.");
	};
	
//	public void checkUncompletedTask () {
//		List<Task> tasks = service.checkUncompletedTask();
//		tasks.stream()
//		.forEach(System.out::println);
//	};
//	
//	public  void completeTask(int todoId) {
//		service.completeTask(todoId);
//	}
}

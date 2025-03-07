package todo_app.controller;

import java.util.List;

import todo_app.dto.request.TaskRequestDto;
import todo_app.dto.response.TaskResponseDto;
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
	
	public TaskResponseDto getTaskByContent(String content) {
		return service.findTaskByContent(content);
	};
	
	public void updateTask(int todoId, TaskRequestDto dto) {
		service.updateTask(todoId, dto);
		System.out.println("할일이 수정되었습니다: [" + todoId + "] 할일 : " + dto.getContent() + " " + dto.getDeadline() + "까지");
	}
	
	public void deleteTask(int todoId) {
		service.deleteTask(todoId);
		System.out.println("할일이 삭제되었습니다.");
	};
	
	public void checkUncompletedTask () {
		System.out.println("미완료된 할일 :");
		List<TaskResponseDto> tasks = service.checkUncompletedTask();
		tasks.stream()
		.forEach(System.out::println);
	};
	
	public void completeTask(String content) {
		service.completeTask(content);
		System.out.println(content + " 을(를) 완료했습니다.");
	}
}

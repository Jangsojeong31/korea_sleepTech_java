package todo_app.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import todo_app.dto.request.TaskRequestDto;
import todo_app.dto.response.TaskResponseDto;
import todo_app.entity.Task;
import todo_app.repository.TaskRepository;
import todo_app.service.TaskService;

public class TaskServiceImpl implements TaskService{
	
	private final TaskRepository repository;
	
	public TaskServiceImpl() {
		this.repository = new TaskRepository();
	}

	@Override
	public void createTask(TaskRequestDto dto) {
		// TODO Auto-generated method stub
		Task task = dto.toEntity();
		repository.save(task);
		
	}

	@Override
	public List<TaskResponseDto> findAllTasks() {
		// TODO Auto-generated method stub
		List<Task> tasks = repository.findAll();
		List<TaskResponseDto> reponseDtos = tasks.stream()
				.map(TaskResponseDto::fromEntity)
				.collect(Collectors.toList());
		return reponseDtos;
	}

	@Override
	public TaskResponseDto findTaskByContent(String content) {
		// TODO Auto-generated method stub
		Task task = repository.findByContent(content);
		TaskResponseDto responseDto = TaskResponseDto.fromEntity(task);
		return responseDto;
	}

	@Override
	public void updateTask(int todoId, TaskRequestDto dto) {
		// TODO Auto-generated method stub
		repository.update(todoId, dto.getDeadline(), dto.getContent());
		
	}

	@Override
	public void deleteTask(int todoId) {
		// TODO Auto-generated method stub
		repository.delete(todoId);
		
	}
	
	

	@Override
	public List<TaskResponseDto> checkUncompletedTask() {
		// TODO Auto-generated method stub
		
		List<TaskResponseDto> uncompletedTask = repository.findAll().stream()
				.filter(task -> task.isDone() == false)
				.map(TaskResponseDto::fromEntity)
				.collect(Collectors.toList());
		
		return uncompletedTask;
		
		
	}
	
	public void completeTask(String content) {
		Task task = repository.findByContent(content);
		task.completeTask();
		
	}
	
	
}

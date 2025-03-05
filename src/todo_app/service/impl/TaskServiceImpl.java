package todo_app.service.impl;

import java.util.List;
import java.util.Optional;
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
	public TaskResponseDto findTaskByAuthor(String author) {
		// TODO Auto-generated method stub
		Optional<Task> task = repository.findByAuthor(author);
		TaskResponseDto responseDto = task.map(TaskResponseDto::fromEntity)
				.orElseThrow(() -> new IllegalArgumentException("게시글을 찾을 수 없습니다."));
		return responseDto;
	}

	@Override
	public void updateTask(int todoId, TaskRequestDto dto) {
		// TODO Auto-generated method stub
		repository.update(todoId, dto.getContent());
		
	}

	@Override
	public void deleteTask(int todoId) {
		// TODO Auto-generated method stub
		repository.delete(todoId);
		
	}
	
	

//	@Override
//	public List<Task> checkUncompletedTask() {
//		// TODO Auto-generated method stub
//		
//		List<Task> uncompletedTask = repository.findAll().stream()
//				.filter(task -> task.isDone())
//				.collect(Collectors.toList());
//		
//		return uncompletedTask;
//		
//	}
//	
//	public void completeTask(int todoId) {
//		Task task = repository.findTaskById(todoId);
//		task.isDone = true;
//		System.out.println("할일을 완료했습니다.");
//	}
	
	
}

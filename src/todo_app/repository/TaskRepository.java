package todo_app.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import chapter015.boardApp.entity.Board;
import todo_app.entity.Task;

public class TaskRepository {

	private final List<Task> taskList	= new ArrayList<>();
	private int todoIdSequence = 1;
	
	public void save(Task newtask) {  // 추가
		newtask.setTodoId(todoIdSequence++);
		taskList.add(newtask);
	};
	
	public List<Task> findAll() { // 전체 조회
		return taskList;
	};
	
	public Task findByContent (String content)
	{  // 단건 조회
		for(Task task: taskList) {
			if (task.getContent().equals(content)) {
				return task;
			}
		}
		return null;
	};
	
	public void update (int todoId, String deadline,String content) {  // 수정
		for(Task task: taskList) {
			if(task.getTodoId() == todoId) {
				task.setDeadline(deadline);
				task.setContent(content);
			}
		}
	}
	
	public void delete (int id) { // 삭제
		taskList.removeIf(task -> task.getTodoId() == id);
	};
}

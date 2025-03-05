package todo_app.entity;

import lombok.Data;


@Data

public class Task {
	private int todoId;
	private String author;
	private String content;

	public boolean isDone;  // 할일 완료 -> true
	
	public Task( String content, String author) {
		this.content = content;
		this.author = author;
	}
	
	@Override
	public String toString() {
		return "todoId: " + todoId + ", 작성자: " + author
				+ ", 할일 : " + content;
	}
	
	
}

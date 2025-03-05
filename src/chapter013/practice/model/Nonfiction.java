package chapter013.practice.model;

public class Nonfiction extends Book {
	private String field; // 분야
	
	public Nonfiction(int id, String title, String author, String field) {
		super(id, title, author);
		this.field = field;
	}
	
	public String getField() { return field;}
		
	@Override
	public String toString() {
		return super.toString() + ", Field: " + field;
	}
}

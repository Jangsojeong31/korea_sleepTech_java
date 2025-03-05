package chapter016.practice.entity;

public enum Category {
	FICTION, NONFICTION, SCIENCE, HISTORY, FANTASY;
	
	public static Category fromString(String value) {
		try {
			return Category.valueOf(value);
			// 3) valueOf(String name) : 문자열로 Enum 상수(0부터 시작) 반환
			// : 잘못된 문자열을 보낼 경우 IllegalArgumentException 발생
		}catch(IllegalArgumentException e) {
			throw new IllegalArgumentException("Invalid category: "+ value);
		}
	}
	
	
}

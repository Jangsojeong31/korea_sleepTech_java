package chapter016.practice.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public abstract class Item {
	private String id;
	private String name;
	
	public abstract void display(); // Item을 상속하면 반드시 재정의

}

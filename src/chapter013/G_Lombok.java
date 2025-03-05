package chapter013;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter


class LombokExample {
	private String name;
	private int age;
	
	// Getter / Setter 자동 생성
}

public class G_Lombok {
	public static void main(String[] args) {
		LombokExample lombokExample = new LombokExample();
		lombokExample.setName("이승아");
		lombokExample.setAge(123);
		
		System.out.println(lombokExample.getName());
		System.out.println(lombokExample.getAge());
		
	}

}

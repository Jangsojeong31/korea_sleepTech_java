package chapter007.animalApp;

import java.util.ArrayList;

// 동물 관리 시스템
public class MainApp {
	public static void main(String[] args) {
		// 서비스 계층(실행) 생성
		// : service 객체의 handleAnimal 메서드는 Animal 타입의 객체를 인자로 받음
		AnimalService service = new AnimalService();
		
		// 동물을 관리하는 List 생성
		ArrayList<Animal> animals = new ArrayList<>();
		
		// 동적 배열에 객체 추가(Animal 타입의 객체)
		animals.add(new Cat()); // : 업캐스팅 (Cat 타입 -> Animal 타입)
		animals.add(new Dog());
		animals.add(new Cat());
		animals.add(new Dog());
		animals.add(new Animal());
		
		// 배열의 모든 동물을 service에 전달하여 출력
		for(Animal animal : animals) {
			service.handleAnimal(animal);
		}
//		야옹
//		멍멍
//		야옹
//		멍멍
//		동물이 소리를 냅니다.
		
		// 객체 생성 및 처리
		Animal cat = new Cat();
		Animal dog = new Dog();
		
		service.handleAnimal(cat); // 야용
		service.handleAnimal(dog); // 멍멍
		
//		 cat.eat(); => 오류
		
		if(cat instanceof Cat) {  // true
			Cat onlycat = (Cat) cat; // 다운 캐스팅(Animal -> Cat)
			onlycat.eat(); // 츄르
		}
		
		if(dog instanceof Cat) { // false
			Cat dogCat = (Cat) dog;
			dogCat.eat();
		}
		
		
		
	}
}

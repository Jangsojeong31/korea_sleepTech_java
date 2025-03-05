package otherPackage;

// 부모 클래스
public class OtherClass {
	// protected 필드
	protected String otherField = "다른 패키지의 필드";
	// protected 메서드
	protected void otherMethod () {
		System.out.println("다른 패키지의 메서드");
	}
	
	public static void main(String[] args) {
		
		PublicClass publicClass = new PublicClass();  // 같은 패키지 내 PublicClass 접근
		System.out.println(publicClass.publicField);  //어디서든지 접근 가능한 필드
		publicClass.publicMethod(); //어디서든지 접근 가능한 메서드
	}

}

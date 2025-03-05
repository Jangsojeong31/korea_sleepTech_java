package sjs01;
/*
 * 배열 - 배열의 개념 / 1차 배열
 * 배열 : 같은 타입의 데이터를 하나의 변수에 여러개 담을 수 있는 '자료구조' / 참조형 변수(주소 -> 참조 -> 접근)
 * 형태 : [] 
 * ex) int[] arr(변수명) = new int(타입)[4](사이즈); 네 개의 데이터 저장 공간(메모리) 생성 -> arr에 위치(주소) 대입
 */
public class Chapter12_array_1 {
	public static void main(String[] arg) {
		
//		int[] apple = null; //배열을 이름만 만들어놓음(배열 선언?)
//		
//		int[] arr = new int[4];
//		int[] arr01 = {1, 2, 3, 4}; //크기가 4인 배열, 값과 함께 부여
		/* 
		 * 위 형태는 배열 선언 시에만 가능
		 * 배열의 특징
		 * 1) 선언 시 공간의 크기를 지정
		 * 2) 크기는 늘거나 줄어들지 않는다.
		 */
		
		/*
		 * 1) 인덱스(index) : 방의 번호, 배열이 지닌 값이 존재하는 위치정보; 0부터 시작
		 * 배열의 값 도출 : arr[index]
		 */
		
		//5개의 공간을 가지는 배열 선언
		int[] inArray = new int[5];
		//문자열 5개 저장 배열
		String[] strArray = new String[5];
		
		//값과 공간을 가지는 배열
		int[] varArray = {1, 2, 3, 4, 5};
		
		//배열자체를 출력 -> 주소
		System.out.println(inArray);
		
		//배열의 값 출력 : 값을 넣지 않았기 떄문에 0으로 초기화되어 있음
		System.out.println(inArray[0]); //0
		System.out.println(inArray[2]); //0
		
		System.out.println(varArray[2]); //3
		
		inArray[0] = 10; //배열에 값을 대입
		inArray[2] = 32;
		
		System.out.println(inArray[0]); //10
		System.out.println(inArray[2]); //32
		
		/*
		 * 배열의 초기 값
		 * 정수 : 0
		 * 실수 : 0.0
		 * 문자 : ' '
		 * 객체 : null  //null은 참조형 변수에 주로 사용됨
		 */
		
		
		
		
	}
}

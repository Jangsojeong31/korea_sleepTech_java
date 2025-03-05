package todo_app;

import java.util.Scanner;

import todo_app.controller.TaskController;
import todo_app.controller.UserController;
import todo_app.dto.request.TaskRequestDto;
import todo_app.dto.request.UserSignInRequestDto;
import todo_app.dto.request.UserSignUpRequestDto;
import todo_app.entity.Task;

/*
 * === TODO(할 일) 프로그램 ===
 * 
 * 1. 프로젝트 개요
 * : 할 일(Todo)에 대한 콘솔 기반 응용 프로그램
 * - 두 도메인(사용자, 할일)을 대상으로 회원가입, 로그인, 로그아웃, 회원 탈퇴 기능
 * 		할일에 대한 추가, 조회(단건/전체), 수정, 삭제 기능을 제공
 * 
 * +) 할일의 활성화 여부(할일 완료 여부)에 따른 필터링
 * 
 * 2. 주요 기능 및 비즈니스 로직
 * : 회원 정보 관리 - CR(단건)D (+ 로그인, 로그아웃)
 * : 할일 기록 관리 - CR(단건/전체)UD (+ 필터링)
 * 
 * 3. 비즈니스 로직 구조
 * - Controller: 사용자의 입력을 처리하고 적절한 서비스 메소드를 호출
 * - Service: 핵심 비즈니스 로직을 수행
 * - Repository: 데이터 저장소와의 상호 작용을 담당
 * - DTO: 계층 간 데이터 전송을 위한 객체
 * - Entity: 데이터베이스 테이블과 매핑되는 도메인 객체
 *
 * 4. 실행 및 관리
 * - Main Class (App.java): 프로그램의 실행 진입점, 사용자와의 상호작용을 관리하고 전체 흐름을 제어
 *
 */
/*
===== 로직 작성 순서 =====
	Entity (데이터 정의)
		- User(사용자 객체)
		- Task(할일 객체)
	
	DTO (데이터 전송 객체 정의)
		request
		- UserSignUpRequestDto(회원가입 요청 데이터)
		- UserSignInRequestDto(로그인 요청 데이터)
		- TaskRequestDto(할일 생성/수정 요청 데이터)
			>> 분리 가능
		response
		- UserResponseDto(회원가입, 로그인 시 반환)
		- TaskResponseDto(할일 응답 반환)
		
	Repository(메모리 기반 데이터 저장소 구현)
		- UserRepository
			cf) User 데이터에 대한 List 컬렉션 저장소 정의
				사용자 등록(save), 사용자 단건 조회(findById), 사용자 전체 조회(findAll), 사용자 삭제(deleteById)
		- TaskRepository
			cf) Task 데이터에 대한 List 컬렉션 저장소 정의
				할일 등록(save), 할일 단건 조회, 할일 전체 조회, 할일 수정, 할일 삭제
	Service(비즈니스 로직 구현)
		- UserService / UserServiceImpl
		- TaskService / TaskServiceImpl
		
	Controller(각 데이터 관련 요청을 처리)
		- UserController
		- TaskController
	
*/

public class App {
	
		private static final Scanner sc = new Scanner(System.in);
		private static final UserController userController = new UserController();
		private static final TaskController taskController = new TaskController();
		
		private static UserSignUpRequestDto createUserSignUpRequest() {
			
			System.out.println("회원 이름: ");
			String name = sc.nextLine();
			System.out.println("회원 ID: ");
			String userId = sc.nextLine();
			System.out.println("회원 password: ");
			String password = sc.nextLine();
			System.out.println("회원 email: ");
			String email = sc.nextLine();
			
			UserSignUpRequestDto dto = new UserSignUpRequestDto(userId, password, name, email);
			
			return dto;
		}
		
		private static UserSignInRequestDto createUserSignInRequest() {
			
			System.out.println("회원 ID: ");
			String userId = sc.nextLine();
			System.out.println("회원 password: ");
			String password = sc.nextLine();
			
			UserSignInRequestDto dto = new UserSignInRequestDto(userId, password);
			
			return dto;
		}
		
//		private static TaskRequestDto createTaskRequest() {
//			
//			System.out.println("todoId: ");
//			int todoId = sc.nextInt();
//			sc.nextLine();
//			System.out.println("회원 Id: ");
//			String userId = sc.nextLine();
//			System.out.println("할일 내용: ");
//			String content = sc.nextLine();
//			
//			TaskRequestDto dto = new TaskRequestDto(todoId, userId, content);
//			
//			return dto;
//		}
		
		public static void main(String[] args) {
			
		while(true) {
			System.out.println("1. 회원가입");
			System.out.println("2. 로그인");
//			System.out.println("3. 회원 조회");
			System.out.println("4. 로그아웃");
			System.out.println("5. 회원탈퇴");

			System.out.println("6. 할일 추가");
			System.out.println("7. 할일 전체 조회");
			System.out.println("8. 할일 단건 조회");
			System.out.println("9. 할일 수정");
			System.out.println("10. 할일 삭제");
			System.out.println("11. 할일 완료");
			System.out.println("12. 미완료된 할일");

			System.out.println("0. 프로그램 종료");
			System.out.print("메뉴를 선택하세요: ");
			
			int choice = sc.nextInt();
			sc.nextLine(); // 버퍼 처리
		
			switch(choice) {
			case 1:
				UserSignUpRequestDto signUpDto = createUserSignUpRequest();
				userController.signUp(signUpDto);
				break;
			case 2:
				UserSignInRequestDto signInDto = createUserSignInRequest();
				userController.signIn(signInDto);
				break;
			case 3:
//				userController
				break;
			case 4:
				userController.logout();
				break;
			case 5:{
				System.out.println("ID를 입력하세요 : ");
				String userId = sc.nextLine();
				userController.withdraw(userId);
				break;
				}
			case 6:{
				System.out.print("작성자: ");
				String author = sc.nextLine();
				System.out.print("할일 내용: ");
				String content = sc.nextLine();
				
				taskController.creatTask(new TaskRequestDto(author, content));
				break;
			}
			case 7:{
				taskController.getAllTasks().forEach(System.out::println);
				break;
			}
			case 8:{
				System.out.print("작성자 : ");
				String author = sc.nextLine();
				System.out.println(taskController.getTaskByAuthor(author));
				
				break;
			}
			case 9:{
				System.out.println("todoId: ");
				int todoId = sc.nextInt();
				sc.nextLine();
				System.out.println("새로운 내용");
				String newContent = sc.nextLine();
				taskController.updateTask(todoId, new TaskRequestDto("author", newContent));
				
			break;
			}
			case 10:{
				System.out.println("todoId: ");
				int todoId = sc.nextInt();
				sc.nextLine();
				taskController.deleteTask(todoId);
				break;
				}
//			case 11:
//				TASK_CONTROLLER.checkUncompletedTask();
//				break;
//			case 12: {
//				int todoId = sc.nextInt();
//				sc.nextLine();
//				TASK_CONTROLLER.completeTask(todoId);
//				break;
//				}
			case 0:
				System.out.println("프로그램을 종료합니다.");
				sc.close();
				return;
			
			}
		}
		}
			
			
			
	
		
		
			
		
}



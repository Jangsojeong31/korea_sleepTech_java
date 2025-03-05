package chapter014.practice;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

// == 직원 관리 시스템 == //
// 직원 데이터 정의
@AllArgsConstructor // Setter 역할 (객체 생성할 때 초기화)
@Getter
@ToString
class Employee {
	private String department; // 부서
	private String name;
	private int salary;
}

public class Practice02 {
	public static void main(String[] args) {
		List<Employee> employees = Arrays.asList(
				new Employee("IT", "이승아", 300),
				new Employee("HR", "조승원", 500),
				new Employee("IT", "김준일", 400),
				new Employee("OT", "전예찬", 350),
				new Employee("HR", "윤대휘", 380));
		
		// 1. 급여가 400 이상인 직원 필터링
		List<Employee> highSalaryEmployees = employees.stream()
				.filter(e -> e.getSalary() >= 400) // filter : 조건을 검사해서 true인 요소만 반환
				.collect(Collectors.toList());
		
		highSalaryEmployees.forEach(System.out::println);
//		Employee(department=HR, name=조승원, salary=500)
//		Employee(department=IT, name=김준일, salary=400)
		
		//2. IT 부서 직원의 이름만 추출
		// 1) department가 'IT'인 직원을 필터링 - filter 
		// 2) department가 'IT'인 직원 목록을 순회하여 이름만 추출 - map 
		List<String> itEmployeeNames = employees.stream() // 이름 리스트 추출 -> 반환값은 String
				.filter(employee -> "IT".equals(employee.getDepartment())) // 매개변수 이름은 임의로 작성 가능 - 가독성 높이기 위해 employee로
//				.map(employee -> employee.getName())
				.map(Employee::getName) // 임의 객체 인스턴스 메서드 참조(객체클래스타입::인스턴스메서드)
				.collect(Collectors.toList());
		
		itEmployeeNames.forEach(System.out::println);
//		이승아
//		김준일
		
		//3. 특정 부서(HR) 직원 중 이름에 '조'가 포함된 직원 필터링
		List<Employee> hrEmployeeWithJo = employees.stream()
			.filter(employee -> employee.getDepartment().equals("HR"))
			.filter(employee -> employee.getName().contains("조"))
			.collect(Collectors.toList());
		
		hrEmployeeWithJo.forEach(System.out::println);
		// Employee(department=HR, name=조승원, salary=500)
		
		// 4. 부서별 직원 그룹화
		// Collectors 클래스 - groupingBy
		Map<String, List<Employee>> groupedByDepartment = employees.stream()
//				.collect(Collectors.groupingBy(employee -> employee.getDepartment()));
				.collect(Collectors.groupingBy(Employee::getDepartment));

		System.out.println(groupedByDepartment);
		// {OT=[Employee(department=OT, name=전예찬, salary=350)], HR=[Employee(department=HR, name=조승원, salary=500), Employee(department=HR, name=윤대휘, salary=380)], IT=[Employee(department=IT, name=이승아, salary=300), Employee(department=IT, name=김준일, salary=400)]}

		// 5. 부서별 평균 급여 계산
		// Collectors 클래스 - groupingBy, averagingInt(각 직원의 급여를 전달)
		Map<String, Double> avgSalaryByDepartment = employees.stream()
				.collect(Collectors.groupingBy(Employee::getDepartment,
						Collectors.averagingInt(Employee::getSalary)));
				
		System.out.println(avgSalaryByDepartment);
		// {OT=350.0, HR=440.0, IT=350.0}

		

	}

}

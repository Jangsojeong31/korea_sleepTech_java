package chapter012.model;

//Model(Student)
//* @Field : 이름(name), 나이(age), 학번(studentId)
//* @Method : getter/setter, toString 

public class Student {
	private String name;
	private int age;
	private String studentId;
	
	public Student(String name, int age, String studentId) {
		this.name = name;
		this.age = age;
		this.studentId = studentId;
	}
	
	public String getName() {return name;}
	public int getAge() {return age;}
	public String getstudentId() {return studentId;}
	
	public void setName(String name) {	this.name = name; }
	public void setAge(int age) { this.age = age; }
	public void setStudentId(String studentId) { this.studentId = studentId; }
	
	@Override
	public String toString() {
		return "Student [Name : " + name + ", Age : " + age + ", StudentId : " + studentId + "]";	
	}
	

}

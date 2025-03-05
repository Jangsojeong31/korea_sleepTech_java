package sjs01;


/*
 * 대입 연산자 : =, +=(더하고 대입), -=, *=, /=, %=
 * 비교 연산자 : ==, !=, >, <, instanceof 등
 * 논리 : &&(논리곱, AND), ||(논리합, OR)
 * 
 * 사칙연산 : 사칙연산 대상들의 data type이 int 이하일 경우 결과의 data type은 무조건 int
 * ex) 5(byte) + 7(byte) + 2(byte) = 12(int) 
 * int 이상인 대상이 있을 경우, 대상들 중 가장 큰 타입이 결과의 data type 
 * ex) 5(long) + 7(int) + 2(byte) = 14(long)
 */
public class Chapter05 {

public static void main(String[] args) {
	
	int num01 = 100;
	byte byNum01 = 10;
	long lyNum01 = 20;
	double dyNum = 33.333;
	
	//byte byResult = byNum01 + byNum01; :오류, byte끼리 더하면 int로 나옴
	int intResult = byNum01 + byNum01; //결과가 int

	long lnResult = lyNum01 + num01; //결과가 long
	
	intResult = byNum01 + num01; //결과가 int
	
	int target = 10;
	System.out.println(target % 3);
	
	//증감 연산자 : ++, -- ; 변수 앞, 뒤에 붙임(붙이는 위치가 중요)
	//ex) a-- ; a=a-1
	
	int num = 10;
	int sum = 0;
	
	sum = num++; //연산 후 증가(sum에 대입 후 num에 +1)
	
	System.out.println("sum = " + sum + ", num : " + num);
	
	sum = ++num; //연산 전 증가
	
	System.out.println("sum = " + sum + ", num : " + num);
	
	//비교 연산자
	
	int a = 10;
	int b = 15;
	int c = 12;
	System.out.println(a >= b); //false
	System.out.println(a < b);  //true
	System.out.println(c == b); //false
	System.out.println(a != b); //true
	
	System.out.println("====================================");
	
	//논리연산 : &&(AND), ||(OR)
	System.out.println((a < b) && (b > c)); //a가 b보다 작고, b는 c보다 크다.
	System.out.println((a > b) && (b > c)); //a가 b보다 크고, b는 c보다 크다.
	System.out.println((a > b) || (b > c)); //a가 b보다 크거나, b는 c보다 크다.

}

	

}

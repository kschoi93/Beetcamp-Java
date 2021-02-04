package Test;

import java.util.Scanner;

public class TestClass {
	 int num = 500;
	 String username = "홍길동";

	 Scanner scan = new Scanner(System.in);
	 
	public TestClass(int num, String name) {
		//지역변수와 멤버변수가 같을때 멤버변수를 지정하는 키워드
		this.num = num;
		username = name;

	}
	
	// 생성자 메소드
	// 1. 생성자 메소드는 클래스명 생성자 메소드명이 같다.
	//2. 메소드는 반드시()있다.
	//3, 생성자 메소드는 반환값이 없다.
	//4. 생성자 메소드는 반환값이 없다.
	// 5. 생성자 메소드는 객체 생성시 한번만 실행된다
	// 6. 객체 생성시 여러개의 생성자 메소드 호출하는 방법
	public TestClass() {
		System.out.println("테스트 클래스 1");
	}
	
	public TestClass(int a) {
		int sum=0;
		for(int i=1; i<100; i++) {
			sum+= i;
		}
		System.out.println("테스트 클래스 2 : " + sum);		
		
	}
	
	public TestClass(int b,int c) {
		System.out.println("테스트 클래스 3");
		total(); // 메소드 호출
	}
	
	public TestClass(int d,int e, String f) {
		//this : 다른 생성자 호출실행
		// 반드시 첫번째 실행문으로 처리해야 한다.
		this();
		System.out.println("테스트 클래스 4");
		
	}
	
	
	
	
	//		반환형 메소드는 소문자로 시작한다.
	public void total() {
		//구현
		int tot=0;
		for(int i=1; i<=100; i++) {
			tot +=i;
		}
		System.out.printf("tot=%d\n",tot);
	}
	
	public int sum(int max) {
		int sum = 0 ;
		for(int i =1; i<=max; i++) {
			sum+=i;
		}
		return max;
	}
	
	public int sum() {
		return 1234;
	}
	
	
}


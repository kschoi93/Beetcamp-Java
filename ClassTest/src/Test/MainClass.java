package Test;
//팩키지


/* 
//클래스
대문자로 시작한다

//클래스를 다른 패키지에서 사용하려면 import 해야한다.

//멤버 변수
 int num = 500;
 String username = "홍길동";
 AAA a = new AAA();
 멤버변수 = 전체를 아우르는 것이고 지역변수 = 본인이 속한 공간만 해당하는 변수

//생성자 메소드
	A를 B에서 사용하기 위해 객체를 만든다
	객체 만드는법 = new A()
	
//메소드
  호출 해줘야지 실행되는 메소드

//메인메소드

//내부 클래스


*/
public class MainClass {
	// 멤버영역 - 실행문을 구현할 수 없다.
	
	
	public static void main(String[] args) {
		// 내부 클래스
		
		//다른 클래스에서 구현한 기능을 사용할때
		//1. 객체(new):생성자 메소드      2. 상속
		//  레퍼런스 변수
		 TestClass tc = new TestClass();
		 TestClass tc1 = new TestClass(1);
		 TestClass tc2 = new TestClass(1,2);
		 TestClass tc3 = new TestClass(10,10,"하이");
		 
		 // 객체 내의 메소드 호출
		 int result = tc2.sum(100);
		 System.out.println("result = " + result);
	}
}

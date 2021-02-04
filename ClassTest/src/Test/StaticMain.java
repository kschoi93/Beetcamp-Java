package Test;

public class StaticMain {

	public static void main(String[] args) {
		/*
		//클래스 내의 메소드를 호출하기 위해 객체를 생성했다
		StaticTest st = new StaticTest();
		st.prn();
		*/
		
		//멤버변수에 static 키워드 사용하면 클래스를 객체생성하지 않고 사용 할 수 있다.
		// 클래스명.static멤버변수
		System.out.println("num-->"+ StaticTest.num);
		
		//메소드 또한 static을 붙이면 객체를 생성하지 않고 사용가능하다
		// 클래스명.static메소드
		StaticTest.prn();
		
		//static 멤버변수는 객체를 생성시 공통변수로 사용된다.
		StaticTest st = new StaticTest();
		StaticTest st2 = new StaticTest();
		StaticTest st3 = new StaticTest();
		
		System.out.println(st.num);
		System.out.println(st2.num);
		System.out.println(st3.name);
		
		// 값변경 
		st.num = 1234;
		st.name = "이순신";
		
		st2.prn();
		
	}

}

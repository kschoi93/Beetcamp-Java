package Test;

public class StaticTest {
	// 멤버 변수
	// 초기값을 설정하지 않은 경우
	// 정수 0, 실수 0.0 , 논리형 false, 객체형 null
	static int num = 100;
	static String name = "세종대왕";
	
	public StaticTest() {}
	
	public static void prn() {
		System.out.println("num="+num);
		System.out.println("nam="+name);
	}
}

package Test;

public class VariableTest {

	public static void main(String[] args) {
		TestClass aaa = new TestClass(100,"안녕");
	
		// 객체내의 num와 username 이 변경이 되었는지 확인한다
		// 객체명.변수명
		System.out.println("aaa.num->" +aaa.num);
		System.out.println("aaa.username->" +aaa.username);
		
		
		TestClass bbb = new TestClass();
		
		System.out.println("bbb.num->" + bbb.num);
		System.out.println("bbb.username" + bbb.username);
	}

}

package pac;

public class ProtectedTest {

	protected String username = "세종대왕";
	protected ProtectedTest() {
		System.out.println("생성자 실행됨..");
	}
	protected void print() {
		System.out.println("username="+username);
	}
}

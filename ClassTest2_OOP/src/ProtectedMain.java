import pac.ProtectedTest;

public class ProtectedMain extends ProtectedTest {

	public ProtectedMain() {
		
	}
	public void start() {
		// protected 접근제한자는 같은 팩키지일 경우 접근허용
		//                    다른 팩키지일 경우 상속받아 접근허용
		ProtectedEx pe = new ProtectedEx();
		System.out.println("------"+ pe.username);
		pe.print();
		
		//extends 하면 다른 패키지의 값을 상속받을 수 있다
		System.out.println("이름="+username);
		print();
	}
	
	public static void main(String[] args) {	
		new ProtectedMain().start();
	}

}

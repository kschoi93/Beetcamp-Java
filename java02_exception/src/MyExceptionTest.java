import java.util.Scanner;

public class MyExceptionTest extends Exception {
	Scanner scan = new Scanner(System.in);
	
	public MyExceptionTest(){
		try {
			System.out.print("1~10������ ���� �Է�=");
			int data = scan.nextInt();
			if(data <1 || data>10) {
				// throw : ���� ���ܹ߻�
				throw new MyException();
//				throw new MyException("1���� 10���� ������ ����");
			} else {
				// ����ó��
				sum(data);
			}
		} catch(MyException e) {
			e.printStackTrace();
		}
		start();
		
	}
	
	public void sum(int m) {
		int s = 0;
		for(int i=1; i < m; i++) {
			s += i;
		}
		System.out.println("s->"+s);
	}
	
	
	public void start() {
		
	}
	
	public static void main(String[] args) {
		new MyExceptionTest();
	}

}

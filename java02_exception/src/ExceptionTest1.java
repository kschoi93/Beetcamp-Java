import java.util.InputMismatchException;
import java.util.Scanner;

public class ExceptionTest1 {
	public ExceptionTest1() {
		try {
			// ����ó���ϱ�
			// ���ܹ߻� ������ �ڵ�� ���� �߻� ���ɼ��� ���� �ڵ嵵 ��ð� �����ϴ�
			Scanner scan = new Scanner(System.in);
			System.out.println("������ �Է��ϼ���...");
			int n = scan.nextInt();
			
			System.out.println("n-->"+n);
		} catch(InputMismatchException ime) {
			//try������ �ڵ尡 ���ܰ� �߻��ϸ� ����� ����
//			ime.printStackTrace();
			
//			System.out.println(ime.getMessage());
//			
			System.out.println("���ڸ� �߸��Է��Ͽ����ϴ�..");
		}
		System.out.println("���α׷��� ����Ǿ����ϴ�.");
	}
	
	public static void main(String[] args) {
		new ExceptionTest1();
	}
}

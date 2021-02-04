import java.util.Scanner;

public class ExceptionEx2 {
	Scanner scan = new Scanner(System.in);
	
	public ExceptionEx2() {}
	
	public void start() {
		try {
			
			System.out.print("ù��° ��->");
			// �ܼ��� ���ڿ� �Է¹޴´�.
			int num1 = Integer.parseInt(scan.nextLine());
			System.out.print("�ι�° ��->");
			int num2 = scan.nextInt();
			
			int result = num1 * num2;
			int result2 = num1 / num2;
			System.out.println(num1+"*"+num2+"="+result);
			System.out.printf("%d/%d=%d\n",num1,num2,result2);
			
			String names[] = {"�������","�̼���"};
			for(int i=0; i<=names.length; i++) {
				System.out.println("names["+i+"]="+names[i]);
			}
		} catch(ArrayIndexOutOfBoundsException aoe) {
			System.out.println("�迭���� ���ܹ߻�...");
		} catch(Exception e) {
			System.out.println("0�� ������ ���� �Է��ϼ���.. --->"+ e.getMessage());
		}
	}
	public static void main(String[] args) {
		new ExceptionEx2().start();

	}

}

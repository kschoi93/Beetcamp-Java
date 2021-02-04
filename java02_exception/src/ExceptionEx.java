import java.util.InputMismatchException;
import java.util.Scanner;

public class ExceptionEx {

		public ExceptionEx() {
			
		}
		
		public void start() {
			
			Scanner scan = new Scanner(System.in);
			do {
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
					}catch(NumberFormatException nfe) {
						System.out.println(" ���ڸ� �Է��ϼ���....");
//					} catch(InputMismatchException ime) {
//						System.out.println("���ڸ� �Է��ϼ���");
					} catch(ArithmeticException ae) {
						System.out.println("�ι�° ���� 0���� ���� �Է��ؾ� �մϴ�.");
					} catch(ArrayIndexOutOfBoundsException ai) {
						System.out.println("������ index�� �߸�����Ͽ����ϴ�..."+ai.getMessage());
					}
			}while(true);	
		}
		public static void main(String[] args) {
			new ExceptionEx().start();
		}
}

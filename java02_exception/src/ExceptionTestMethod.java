
public class ExceptionTestMethod {
	public ExceptionTestMethod() throws ArithmeticException, NumberFormatException,ArrayIndexOutOfBoundsException {
		method1();
	}
	void method1()  throws ArithmeticException, NumberFormatException,ArrayIndexOutOfBoundsException {
		int a = 100, b=10;
		int c = a/b;
		System.out.println("c="+c);
		method2();
		
	}
	
	public void method2() throws NumberFormatException,ArrayIndexOutOfBoundsException {
		String numStr = "123";
		int num = Integer.parseInt(numStr);
		System.out.println("num="+num);
		method3();
	}
	
	public void method3() throws ArrayIndexOutOfBoundsException {
		int num[] = {10,20,30};
			System.out.println(num[num.length]);
	}
	
	public static void main(String args[]) {
		try {
			ExceptionTestMethod et = new ExceptionTestMethod();
		} catch(ArithmeticException ae){
			System.out.println("0���� ���� �� �����ϴ�-->" +  ae.getMessage());
		} catch(NumberFormatException e) {
			System.out.println("���ڸ� ������ ���ڰ� �Էµ� �� �����ϴ�.--->"+ e.getMessage());
		} catch(Exception e) {
			System.out.println("�ε��� ��ȣ�� �߸� �Է��Ͽ����ϴ�.--->"+ e.getMessage());
			e.printStackTrace();
		} finally{
			System.out.println("�̰Ž� ������ ����Ǵ°�");
		}
		System.out.println("���α׷� ����......");
	}

}

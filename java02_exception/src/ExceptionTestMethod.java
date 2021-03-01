
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
			System.out.println("0으로 나눌 수 없습니다-->" +  ae.getMessage());
		} catch(NumberFormatException e) {
			System.out.println("숫자를 제외한 문자가 입력될 수 없습니다.--->"+ e.getMessage());
		} catch(Exception e) {
			System.out.println("인덱스 번호를 잘못 입력하였습니다.--->"+ e.getMessage());
			e.printStackTrace();
		} finally{
			System.out.println("이거슨 무조건 실행되는겨");
		}
		System.out.println("프로그램 종료......");
	}

}

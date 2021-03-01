import java.util.Scanner;

public class ExceptionEx2 {
	Scanner scan = new Scanner(System.in);
	
	public ExceptionEx2() {}
	
	public void start() {
		try {
			
			System.out.print("첫번째 수->");
			// 콘솔의 문자열 입력받는다.
			int num1 = Integer.parseInt(scan.nextLine());
			System.out.print("두번째 수->");
			int num2 = scan.nextInt();
			
			int result = num1 * num2;
			int result2 = num1 / num2;
			System.out.println(num1+"*"+num2+"="+result);
			System.out.printf("%d/%d=%d\n",num1,num2,result2);
			
			String names[] = {"세종대왕","이순신"};
			for(int i=0; i<=names.length; i++) {
				System.out.println("names["+i+"]="+names[i]);
			}
		} catch(ArrayIndexOutOfBoundsException aoe) {
			System.out.println("배열에서 예외발생...");
		} catch(Exception e) {
			System.out.println("0을 제외한 점수 입력하세요.. --->"+ e.getMessage());
		}
	}
	public static void main(String[] args) {
		new ExceptionEx2().start();

	}

}

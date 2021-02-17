import java.util.Scanner;

public class Square {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("사각형을 출력합니다.");
		System.out.print("단 수 :");
		int line = scan.nextInt();
		
		for(int i=0; i<line; i++) {
			System.out.println("*****");
		}
	}
}

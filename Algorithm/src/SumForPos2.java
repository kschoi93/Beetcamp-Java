import java.util.Scanner;

public class SumForPos2 {
	
	public static void main(String[]args) {
		Scanner scan = new Scanner(System.in);
		int a,b;
		System.out.print("a의 값 : "); a= scan.nextInt();	
		System.out.print("b의 값 : "); b= scan.nextInt();
		
		while(true) {
			if(!(a<b)) {
				System.out.println("a보다 큰 값을 입력하세요!");
				System.out.print("b의 값 : "); b = scan.nextInt();
			} else {
				System.out.printf("b - a는 %d입니다.", b-a);
				break;
			}
		}
		
		
	}
}

import java.util.Scanner;

public class Triangle {

	static void triangleLB(int n) {
		System.out.println("test1");
		for(int i =0; i<n;i++) {
			System.out.print("*");
			for(int j=0; j<i;j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
	static void triangleLU(int n) {
		System.out.println("\n\ntest2");
		for(int i=0; i<n; i++) {
			System.out.print("*");
			for(int j=n-1;j>i;j--) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
	static void triangleRU(int n) {
		System.out.println("\n\ntest3");
		for(int i=0; i<n; i++) {
			for(int p=0; p<i;p++) {
				System.out.print(" ");
			}
			for(int j=n-i;j>0;j--) {	
				System.out.print("*");
			}
			System.out.println();
		}
	}
	static void triangleRB(int n) {
		System.out.println("\n\ntest4");
		for(int i=0; i<n; i++) {
			for(int p=n-i; p>1;p--) {
				System.out.print(" ");
			}
			for(int j=0; j<i+1;j++) {	
				System.out.print("*");
			}
			System.out.println();
		}
	}
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("이등변 삼각형 만들 크기를 정해주세요=");
		int n = 0;
		do {
			n = scan.nextInt();
		}while(n<0);
		triangleLB(n);
		triangleLU(n);
		triangleRU(n);
		triangleRB(n);
	}

}

import java.util.Scanner;

public class Diamond2 {

	void diamond(int max){
		//출력할 문자의 초기값
		char txt = 'A';
		int step = 2;
		//행
		for(int row=1; row>0; row+=step) { // row = 1,3,5,7,9....
			//공백
			for(int space=1;space<=(max-row)/2;space++) { // space = 1,2,3,4 ....
				System.out.print(" ");
			}
			//문자출력
			for(int col=1;col<=row;col++) {
				// 알파벳 출력
				System.out.print(txt++);
				if(txt>'Z') txt = 'A';
			}
			System.out.println();
			if(row>=max) step = -2;
		}		
	}
	
	public int getInput() {
		Scanner scan = new Scanner(System.in);
		System.out.print("임의의 홀수 입력(1~49)=");
		int max;
		
		
		while(true) {
			max = scan.nextInt();
			if(max%2 == 1 && (max > 0 && max < 50)) break;
			else System.out.println("다시입력해주세요");
		}
		
		return max;
	}
	
	public Diamond2() {
		int max = getInput();
		diamond(max);
	}
	
	
	
	
	
	//////////////////////////
	public static void main(String[] args) {
		new Diamond2();
	}
}

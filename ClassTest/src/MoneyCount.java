//최경식

import java.util.Scanner;

public class MoneyCount {

	public void getInput() {
		Scanner scan = new Scanner(System.in);
		int money = scan.nextInt();
		int Calculator = 0;

		int mNum[] = { 50000, 1000, 500, 100, 10, 1 };

		for(int i =0; i < mNum.length; i++) {
			if(i<2) {
				if(mNum[i]<money) {
					Calculator = money/mNum[i];
					System.out.println(mNum[i] + "원="+ Calculator +"장");
					money = money % mNum[i];
				}
			} else {
				if(mNum[i]<money) {
					Calculator = money/mNum[i];
					System.out.println(mNum[i] + "원="+ Calculator +"개");
					money = money % mNum[i];
				}
			}
		}
	}

	public MoneyCount(){
		System.out.print("금액을 입력하세요?=");
		getInput();

	}





	//////////////////////////////////////////
	public static void main(String[] args) {
		new MoneyCount();

	}

}

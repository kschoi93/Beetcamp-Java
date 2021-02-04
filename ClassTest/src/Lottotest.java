import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Lottotest {
	Scanner scan = new Scanner(System.in);
	Random ran = new Random();

	public Lottotest() {}
	
	public void start() {
		do {
			System.out.print("게임수=");
			int game = scan.nextInt();
			
			
			//입력받은 게임수 만큼 로또번호 처리
			for(int cnt =1; cnt <= game; cnt++) {
				System.out.print(cnt+"게임=");
				//로또 1게임....
				int lotto[] = new int[7];
				for(int i =0; i<lotto.length; i++) {
					lotto[i] = ran.nextInt(45)+1; // 1 ~ 45
					//중복검사
					for(int check=0; check<i; check++) {
						if(lotto[check] == lotto[i]) { // 중복값일때
							i--;
						}
					}
				}
				/*
				//정렬
				for(int j=0; j<lotto.length-2; j++) { // 0,1,2,3,4
					for(int i=0; i<lotto.length-2-j;i++) { // 0,1,2,3,4
						if(lotto[i] > lotto[i+1]) { // i+1로 인해 6번지까지 반복된다 , 고로 마지막것부터 정렬한다
							int temp = lotto[i];//교환한다 
							lotto[i] = lotto[i+1];
							lotto[i+1] = temp;
						}
					}
				}
				//출력
				System.out.print(cnt+"게임=[");
				for(int i = 0; i <lotto.length-1 ; i++) {
					System.out.print(lotto[i]);
						if(i==5) {
							System.out.print("], ");
						} else {
							System.out.print(", ");
						}
				}
				//보너스
				System.out.println("bonus="+lotto[lotto.length-1]);
				*/
				// 정렬 출력 간소화 .. 거 너무한거 아니오?
				int lottoSort[] = Arrays.copyOf(lotto, 6);
				Arrays.sort(lottoSort,0,6);
				System.out.print(Arrays.toString(lottoSort));
				System.out.println(", bonus="+lotto[6]);
				
			}
			//계속여부 확인
			System.out.print("계속하시겠습니까(1:예,2:아니오)?");
			int que = scan.nextInt();
			if(que==2) break;
		}while(true);
		System.out.println("프로그래임 종료되었습니다..");
	}
	
	
	public static void main(String[] args) {
		new Lottotest().start();
	}
}



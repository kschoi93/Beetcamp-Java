// 최경식
import java.util.Scanner;

public class AlphabetDiamond {
	// 알파벳 다이아몬드 계산
	void diamond(int num){
		// 알파벳 배열 새성
		String alphabet[] = {"A","B","C","D","E","F","G"
				,"H","I","J","K","L","M","N","O","P","Q"
				,"R","S","T","U","V","W","X","Y","Z"};
		// loop = if문에서 구문의 첫 번째 시작할때 && 중앙기준 크고 작음에 따라 빈공간을 더할지 줄일지 실행되도록 조건생성
		int loop = 0;
		// t = while 문에서 구문마다 빈 공간의 갯수를 더해주는 값
		int t = 0;
		// sum = while 문에서 중앙 기준으로 몇번을 계산해야 t가 나오는지 계산해주는 값.. sum이 중앙 값 기준으로 계속해서 줄고 && 늘어난다 
		int sum = num/2;
		// n = 구문마다 문자가 늘어나는 갯수를 표현하는 것으로 계산 후 +2를 해준다
		int n = 1;
		// i = 알파벳이 26개가 있는데 Z 이후에는 존재하지 않기 때문에 z까지 계산 후 다시 처음으로 돌려주는 수
		int i = 0;
		// a 값이 어디까지 돌았을 때 n값( 구문마다 문자가 늘어나는) 기준을 만들어준다
		int center = num/2;
		
		
		// 입력받은 횟수만큼 돌아간다
		for(int a = 0; a <= num; a++) {
			// 1횟수 증가시마다 2글자씩 늘어나는만큼 돌린다
			for(int j = 0; j < n;) {
				// 간격 넓히는 공백 만들기
				if(loop==0 && a < center) {
					while(t < sum) {
						System.out.print(" ");
						t++;
					}
					loop = 1 ;
					sum -= 1 ;
					t    = 0 ;
				} else if(loop==0 && a >= center) {
					while(t < sum) {
						System.out.print(" ");
						t++;
					}
					loop = 1 ;
					sum += 1 ;
					t    = 0 ;
				}
				
				// 알파벳 기준으로 z를 넘어가면 초기화되게 만든다
				if(i < alphabet.length) {
					// 알파벳[i]번째부터 소환된다.
					System.out.print(alphabet[i]);
					i++;
				} else {// 알파벳[i] 숫자가 최대수를 넘어가면 i는 0으로 초기화된다.
					i = 0 ;
					continue;
				}
				// 만약 알파벳이 z를 넘어가면 초기화를 해주기 때문에 continue; 하여 다시 계산 후 j++를 해준다
				j++;
			}
			// loop를 초기화 시켜 구문마다 첫번째가 실행시 if문을 지날 수 있도록 0으로 초기화 시킨다.
			loop=0;
			// println을 해줌으로서 구문이 끝날때마다 개행을 해준다
			System.out.println("");
			// 중앙번호 기준으로 늘어날지 줄어들지 바뀌는 턴을 구할 수 있다.
			if(a < center) n+=2;
			else     	   n-=2;
		}
			
	}

	// 홀수만 입력하도록 조건 만들기
	int getInput() {
		Scanner scan = new Scanner(System.in);
		int num;
		while(true) {
			System.out.print("임의의 홀수입력(1~49)=");
			num = scan.nextInt();
			// 짝수 == 0이 나온다
			int eNum = num%2; 
			// 홀수가 나오면 break 해서 빠져나오고 아니면 다시 입력시킨다.
			if(eNum == 1 && (num > 0 && num < 50) ) break;
			else System.out.println("1~49의 홀수를 입력해 주세요");
		}
		return num;
	}
	
	private AlphabetDiamond(){
		int num = getInput();
		diamond(num);
	}
	
	
	
	
	/////////////////////////////////////////////////
	public static void main(String[] args) {
		new AlphabetDiamond();

	}

}

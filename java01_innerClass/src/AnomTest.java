
public class AnomTest {
	public AnomTest() {
		start();
	}
	
	public void start() {
		// 익명의 내부 클래스
		new Sample() {
			public void oddSum(int max) {
				int s=0;
				for(int i=1; i<=max;i+=2) {
					s=s+i;
				}
				System.out.println("1~"+max+"까지의 홀수의 합은 " +  s);
			}
		}.oddSum(100);;
	
	}
	
	public static void main(String[] args) {
		AnomTest at = new AnomTest();
		at.start();
	}
}

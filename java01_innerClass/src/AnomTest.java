
public class AnomTest {
	public AnomTest() {
		start();
	}
	
	public void start() {
		// �͸��� ���� Ŭ����
		new Sample() {
			public void oddSum(int max) {
				int s=0;
				for(int i=1; i<=max;i+=2) {
					s=s+i;
				}
				System.out.println("1~"+max+"������ Ȧ���� ���� " +  s);
			}
		}.oddSum(100);;
	
	}
	
	public static void main(String[] args) {
		AnomTest at = new AnomTest();
		at.start();
	}
}

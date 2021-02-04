import java.util.Random;

public class RandomTest {

	public RandomTest() {
		start();
	}
	public void start() {
		//Random : 난수
		Random ran = new Random();
		for(int i = 1; i<1000; i ++) {
			//논리형 true, false
//			boolean result = ran.nextBoolean();
//			double result = ran.nextDouble();
			int result = ran.nextInt();
			result = ran.nextInt(100);
			
			System.out.print(result+"\t");
			if(i%10==0) System.out.println();
		}
	}
	
	public static void main(String[] args) {
		new RandomTest();
	}

}

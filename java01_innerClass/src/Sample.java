public class Sample implements SampleImp{

	public Sample() {}
	public void sum(int max)  {
		int sum = 0;
		for(int i =1; i<=max; i++) {
			sum += i;
		}
		System.out.println("1~"+max+"������ ���� " + sum);
	}
	public void oddSum(int max) {}
	public void evenSum(int max) {}
}

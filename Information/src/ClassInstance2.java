
public class ClassInstance2 {

	public static void avg(int left,int right) {
		System.out.println((left + right)/2);
	}
	
	public static void sum(int left,int right) {
		System.out.println(left + right);
	}
	
	// (3) 변수를 정의하고 메소드를 정의함으로서 필요에 따라 수정하여 사용 할 수 있다
	public static void main(String[] args) {
		int left, right;
		
		left = 10;
		right = 20;
		
		sum(left, right);
		avg(left, right);

		left = 20;
		right = 40;

		sum(left, right);
		avg(left, right);

	}

}

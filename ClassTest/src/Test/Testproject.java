package Test;

public class Testproject {

	public static void main(String[] args) {
		String data = "12341234@1234.com.123";
		int tmp;
		int tmp2;
		tmp = data.indexOf(".");
		tmp2 = data.lastIndexOf(".");
		System.out.println(tmp +"  " + tmp2);
		
		String test = "234324";
		int tmp3;
		tmp3 = test.indexOf("#");
		if(tmp3 == -1) {
			System.out.println("잘못입력했다.");
			System.out.println(tmp3);
		} else System.out.println("제대로 입력했다.");

	}

}

public class OuterTest {
	
	int num = 1234;
	String name = "세종대왕";
	
	public OuterTest() {
		System.out.println("OuterTest() 생성자 ...");
		
	}
	public void outerprint() {
		System.out.println(num + " ->" + name);
//		System.out.println("외부에서 내부를 사용할 수 있는가?" +no+username);
		InnerTest it2 = new InnerTest();
		System.out.println("@@@@@@@@@@@@@@@@@@@@");
		it2.innerPrint();
		System.out.println("@@@@@@@@@@@@@@@@@@@@");
		System.out.println("###################"+it2 + "################");
	}
	// 내부 클래스(멤버)
	class InnerTest{
		int no = 6789;
		String username = "이순신";
		InnerTest(){
			System.out.println("InnerTest() 생성자....");
		}
		public void innerPrint() {
			System.out.println(no + "=====>" + username);
			System.out.println("내부에서 외부를 사용할 수 있는가 ?"+num + name);
		}
	}
	
	public static void main(String[] args) {
		new OuterTest().outerprint();
		OuterTest ot = new OuterTest();
		ot.outerprint();
		
		// 외부에서 내부클래스 객체를 생성하기 위해서는 
		// 		  외부 클래스 객체를 이용하여 내부클래스 객체를 생성하여야 한다
		OuterTest ot2 = new OuterTest();
		OuterTest.InnerTest it = ot2.new InnerTest();
		it.innerPrint();
	}
}

public class OuterTest {
	
	int num = 1234;
	String name = "�������";
	
	public OuterTest() {
		System.out.println("OuterTest() ������ ...");
		
	}
	public void outerprint() {
		System.out.println(num + " ->" + name);
//		System.out.println("�ܺο��� ���θ� ����� �� �ִ°�?" +no+username);
		InnerTest it2 = new InnerTest();
		System.out.println("@@@@@@@@@@@@@@@@@@@@");
		it2.innerPrint();
		System.out.println("@@@@@@@@@@@@@@@@@@@@");
		System.out.println("###################"+it2 + "################");
	}
	// ���� Ŭ����(���)
	class InnerTest{
		int no = 6789;
		String username = "�̼���";
		InnerTest(){
			System.out.println("InnerTest() ������....");
		}
		public void innerPrint() {
			System.out.println(no + "=====>" + username);
			System.out.println("���ο��� �ܺθ� ����� �� �ִ°� ?"+num + name);
		}
	}
	
	public static void main(String[] args) {
		new OuterTest().outerprint();
		OuterTest ot = new OuterTest();
		ot.outerprint();
		
		// �ܺο��� ����Ŭ���� ��ü�� �����ϱ� ���ؼ��� 
		// 		  �ܺ� Ŭ���� ��ü�� �̿��Ͽ� ����Ŭ���� ��ü�� �����Ͽ��� �Ѵ�
		OuterTest ot2 = new OuterTest();
		OuterTest.InnerTest it = ot2.new InnerTest();
		it.innerPrint();
	}
}


public class MethodInnerClass {
	
	String email = "abcd@nvate.com";
	public MethodInnerClass(){
		
	}
	public void output() {
		System.out.println("�̸���==>"+ email);
	}
	public void innerClassMethod() {
		int num = 100;
		
		// �޼ҵ忡 ���ǵ� ���� Ŭ����
		class InnerCreate{
			String name = "ȫ�浿";
			 InnerCreate(){
				 
			 }
			 void innerPrint() {
				 System.out.println("name----->"+ name);
				 System.out.println("num------>"+ num);
				 System.out.println("email---->"+email);
			 }
		}

		//��ü ����
		InnerCreate ic = new InnerCreate();
		ic.innerPrint();
	}
	
	
	public static void main(String[] args) {
		new MethodInnerClass().innerClassMethod();
	}
}

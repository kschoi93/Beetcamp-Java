
public class ExceptionTest2 {

	ExceptionTest2(){
		
	}
	
	void start(){
		try {
			//�����
			int data[] = {10,8,95,32,65};
			System.out.println(data[data.length]);
		}catch(ArrayIndexOutOfBoundsException ae) {
			System.out.println("�迭�� �ε����� �߸� ����Ͽ����ϴ�...>>>"+ae.getMessage());

			
		}finally {
			System.out.println("finally : ������ �ѹ��� �����.....");
		}
	}
	
	public static void main(String[] args) {
		new ExceptionTest2().start();
	}

}

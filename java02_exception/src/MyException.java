
public class MyException extends Exception{
	// 1`10������ ���� ��ȿ�� ���̴�. ���� �޽����� ����
	public MyException() {
		super("1~10������ ���� ��ȿ�� ���̴�.");
	}
	// �Ű������� ���� ���� �޽����� ����
	public MyException(String message) {
		super(message);
	}
	
}

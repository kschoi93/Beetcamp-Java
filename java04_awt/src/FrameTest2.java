import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;

public class FrameTest2 extends Frame {

	public FrameTest2() {
		super("��ӹ��� ������");	//â ���� ����
		
		// ���̾ƿ� ���� BorderLayout -> FlowLayout���� ����
		setLayout(new FlowLayout());
		
		Button btn = new Button("���̾ƿ� �����");
		add(btn);
		
		setSize(500,500);
		setVisible(true);
		
	}
	
	public static void main(String[] args) {
		new FrameTest2();
	}
}

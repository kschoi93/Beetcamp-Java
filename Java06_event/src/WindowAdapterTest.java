import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

public class WindowAdapterTest extends WindowAdapter{
	JFrame frm = new JFrame("WindowAdapter �׽�Ʈ");
	
	public WindowAdapterTest() {
		frm.setSize(500,500);
		frm.setVisible(true);
		frm.setDefaultCloseOperation(frm.DO_NOTHING_ON_CLOSE);
		
		frm.addWindowListener(this);
	
	}
	// �� �������̵�
	public void windowClosing(WindowEvent we) {
		System.out.println("������ �̺�Ʈ �߻���");
		frm.dispose();//�ڿ� �����ϴ� �޼ҵ�
		System.exit(0);
	}
	
	
	public static void main(String[] args) {
		new WindowAdapterTest();
	}
}

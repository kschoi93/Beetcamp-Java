import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class WindowAdapterInnerTest extends JFrame{
	JLabel lbl = new JLabel("WindowAdapter �׽�Ʈ��...");
	public WindowAdapterInnerTest() {
		add(lbl);
		setSize(500,500);
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		AdapterInner ai = new AdapterInner();
		addWindowListener(ai);
	}
	// ����Ŭ�������� window �̺�Ʈ ó���ϱ�
	class AdapterInner extends WindowAdapter{
		// �ٽ� �������̵�
		public void windowClosing(WindowEvent we) {
			lbl.setText("������ �̺�Ʈ ó����");
			System.exit(0);
		}
		
	}
	public static void main(String[] args) {
		new WindowAdapterInnerTest();
	}
	
}

import java.awt.BorderLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JTextField;

public class WindowAdapterInnerTest2 extends JFrame{
// �͸��� ���� Ŭ������ �̺�Ʈ ó��
	JTextField tf = new JTextField("�͸��� ���� Ŭ������ �̺�Ʈ ó���ϱ�");
	public WindowAdapterInnerTest2() {
		add(BorderLayout.SOUTH,tf);
		setSize(500,500);
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		
		//�̺�Ʈ �߻������ 1���϶� ����Ѵ�.
		addWindowListener(new WindowAdapter() {
			// �͸��� ���� Ŭ�������� �޼ҵ带 �ٽ� �������̵� �Ѵ�.
			public void windowClosing(WindowEvent we) {
				tf.setText("������ �̺�Ʈ ó����..");
				System.exit(0);
			}
		});
	}

	public static void main(String[] args) {
		new WindowAdapterInnerTest2();

	}

}

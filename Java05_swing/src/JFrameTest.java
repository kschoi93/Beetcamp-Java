
import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class JFrameTest extends JFrame{

	public JFrameTest() {
		super("Swing �׽�Ʈ��");
		
		JButton btn = new JButton("Swing��ư");
		add(BorderLayout.NORTH,btn);
		
		//�׵θ��� ���� �����̳� : JPanel -> default : flowLayout
		JPanel pane = new JPanel();
		//�ٵ��ǽ� ���̾ƿ�
		//                            �� �� ���� �స
		pane.setLayout(new GridLayout(2,2,20,20));
		
		
		JButton btn2 = new JButton("��ư2");
		JButton btn3 = new JButton("��ư3");
		JButton btn4 = new JButton("��ư4");
		JButton btn5 = new JButton("��ư5");
		pane.add(btn2);
		pane.add(btn3);
		pane.add(btn4);
		pane.add(btn5);
		add(BorderLayout.CENTER,pane);
		
		setSize(500,500);
		setVisible(true);
		//���Ϸ� ����� �ڿ�������Ű�� ����
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
	}

	public static void main(String[] args) {
		new JFrameTest();
	}
}

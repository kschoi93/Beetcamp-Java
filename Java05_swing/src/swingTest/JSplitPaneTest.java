package swingTest;

import javax.swing.JFrame;
import javax.swing.JSplitPane;
import javax.swing.JTextArea;

public class JSplitPaneTest extends JFrame{
	JSplitPane sp1, sp2;
	
	DigitalClock dc = new DigitalClock();
	CalendarSwing cs = new CalendarSwing();
	
	JTextArea ta = new JTextArea();
	
	public JSplitPaneTest() {
		//Vertical									   ���� ����
		sp2 = new JSplitPane(JSplitPane.VERTICAL_SPLIT, dc, cs);
		
		//Horizontal �¿�� ������							 ���� ������
		sp1 = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, sp2, ta);
		
		add(sp1);
		
		// sp2�� �� ������Ʈ ���� ���ϱ�
		sp2.setDividerLocation(300);
		sp1.setDividerLocation(600);
		// split ��輱 �β�
		sp2.setDividerSize(20);
		
		sp1.setOneTouchExpandable(true);
		sp1.setDividerSize(20);
		
		setSize(1200,700);
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		Thread t1 = new Thread(dc);
		t1.start();
	}

	public static void main(String[] args) {
		new JSplitPaneTest();

	}

}

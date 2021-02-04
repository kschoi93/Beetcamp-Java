package swingTest;

import javax.swing.JFrame;
import javax.swing.JSplitPane;
import javax.swing.JTextArea;

public class JSplitPaneTest2 extends JFrame{
	JSplitPane sp1, sp2;
	
	CalendarSwing cs = new CalendarSwing();
	Calculator cal = new Calculator();
	PackMan pack = new PackMan();
	
	JTextArea ta = new JTextArea();
	
	public JSplitPaneTest2() {
		//									  왼쪽 오른쪽
		sp2 = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, cal, cs);
		//							 북쪽 남쪽
		sp1 = new JSplitPane(JSplitPane.VERTICAL_SPLIT, pack, sp2);
		
		add(sp1);
		
		// sp2의 윗 컴포넌트 높이 정하기
		sp2.setDividerLocation(600);
		sp1.setDividerLocation(300);
		// split 경계선 두께
		sp2.setDividerSize(20);
		
		sp1.setOneTouchExpandable(true);
		sp1.setDividerSize(20);
		
		setSize(1200,700);
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		pack.getPackManSize();
		Thread t1 = new Thread(pack);
		t1.start();
	}

	public static void main(String[] args) {
		new JSplitPaneTest2();

	}

}

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
		//Vertical									   북쪽 남쪽
		sp2 = new JSplitPane(JSplitPane.VERTICAL_SPLIT, dc, cs);
		
		//Horizontal 좌우로 나누기							 왼쪽 오른쪽
		sp1 = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, sp2, ta);
		
		add(sp1);
		
		// sp2의 윗 컴포넌트 높이 정하기
		sp2.setDividerLocation(300);
		sp1.setDividerLocation(600);
		// split 경계선 두께
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

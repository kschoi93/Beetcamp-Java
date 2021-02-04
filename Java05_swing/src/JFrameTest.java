
import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class JFrameTest extends JFrame{

	public JFrameTest() {
		super("Swing 테스트중");
		
		JButton btn = new JButton("Swing버튼");
		add(BorderLayout.NORTH,btn);
		
		//테두리가 없는 컨테이너 : JPanel -> default : flowLayout
		JPanel pane = new JPanel();
		//바둑판식 레이아웃
		//                            열 행 열갭 행갭
		pane.setLayout(new GridLayout(2,2,20,20));
		
		
		JButton btn2 = new JButton("버튼2");
		JButton btn3 = new JButton("버튼3");
		JButton btn4 = new JButton("버튼4");
		JButton btn5 = new JButton("버튼5");
		pane.add(btn2);
		pane.add(btn3);
		pane.add(btn4);
		pane.add(btn5);
		add(BorderLayout.CENTER,pane);
		
		setSize(500,500);
		setVisible(true);
		//프록램 종료시 자원해제시키는 설정
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
	}

	public static void main(String[] args) {
		new JFrameTest();
	}
}

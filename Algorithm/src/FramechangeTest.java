import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class FramechangeTest extends JFrame implements ActionListener{
	JPanel p1 = new JPanel();
	JPanel p2 = new JPanel();
	JPanel p3 = new JPanel();
	JButton btn = new JButton("버튼 체인지");
	JButton btn2 = new JButton("두번째");
	JPanel pane = new JPanel();
	int a=0;
	public FramechangeTest() {
		add(pane);
		

		p1.add(new JButton("p1"));
		p1.setVisible(true);
		p2.add(new JButton("p2"));
		p3.add(new JButton("p3"));
		p2.add(btn2);
		add("South",btn);
		
		setSize(500,500);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setVisible(true);
		btn.addActionListener(this);
		btn2.addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent ae) {
		Object obj = ae.getSource();
		String test = ae.getActionCommand();
		if(test.equals("버튼 체인지")) {
			if(a==5) a=0;
			System.out.println(a);

			changeMethod(a);
			a++;
			System.out.println(a);
		}else if(test.equals("두번째")) {
			System.out.println("Test");
			a++;
			p2.setVisible(false);
			p3.setVisible(true);
			pane.add(p3);
			
		}
		
	}
	
	public void changeMethod(int a) {
		if(a==1) {

			p3.setVisible(false);
			pane.add(p1);
			
		}else if(a==2) {
			p1.setVisible(false);
			p2.setVisible(true);
			pane.add(p2);
		}else if(a==3) {
			p2.setVisible(false);
			p3.setVisible(true);
			pane.add(p3);
		}
	}

	public static void main(String[] args) {
		new FramechangeTest();

	}

}

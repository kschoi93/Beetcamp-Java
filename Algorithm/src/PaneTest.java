import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class PaneTest extends JFrame implements ActionListener{
	JPanel pane2 = new JPanel();
		JButton btn3 = new JButton("btn3");
		JButton btn4 = new JButton("btn4");
	JPanel pane1 = new JPanel();
		JButton btn1 = new JButton("btn1");
		JButton btn2 = new JButton("btn2");
		String test = "pane1";
	CardLayout card = new CardLayout();
	CardLayout card2 = new CardLayout();
	public PaneTest() {
		pane1.setLayout(card);
		pane1.add(btn1,"btn1");
		pane1.add(btn2,"btn2");
		card.show(pane1, "btn1");
		
		
		add("Center",pane1);
		
		
		
		
		add("South",btn3);
		
		setSize(500,500);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setVisible(true);
		
		btn3.addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent ae) {
		Object obj = ae.getActionCommand();
		if(obj.equals("btn3")||obj.equals("btn4")) {
			if(test.equals("pane1")) {
				card.show(pane1, "btn2");
				btn2.setVisible(false);
				btn2.setText("교환되나");
				test="";
			} else {
				card.show(pane1, "btn1");
				test="pane1";
			}
		} else if(obj.equals("btn2") || obj.equals("btn1")) {
			card2.show(pane2, "btn4");
		}
	}

	public static void main(String[] args) {
		new PaneTest();
	}
}

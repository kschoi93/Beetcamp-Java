

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class SwingTest extends JFrame{
	JPanel pane = new JPanel(new BorderLayout());
		JButton ebtn = new JButton("East");
		JButton wbtn = new JButton("West");
		JButton cbtn = new JButton("Center");
		JButton sbtn = new JButton("South");
		JButton nbtn = new JButton("North");
	JPanel flow = new JPanel(new FlowLayout());
		JTextField tf1 = new JTextField("이것은 Swing의");
		JTextField tf2 = new JTextField("간단한 예제");
		JTextField tf3 = new JTextField("입니다");
	JPanel southPane = new JPanel(new GridLayout(0,3));	
		JComboBox<String> cb1, cb2, cb3;
		DefaultComboBoxModel<String> model = new DefaultComboBoxModel<String>();
		String cbTest[] = {"콤보박스","는","이렇게","됩니당"};
	Vector<String> arr = new Vector<String>();
	
	public SwingTest() {
		add("North",pane);
		pane.add("East",ebtn);
		pane.add("West",wbtn);
		pane.add("Center",cbtn);
		pane.add("South",sbtn);
		pane.add("North",nbtn);
		
		add("Center",flow);
		flow.add(tf1);
		flow.add(tf2);
		flow.add(tf3);
		
		add("South",southPane);
		arr.add("이것은");
		arr.add("콤보박스");
		arr.add("이쥬");		
		cb1 = new JComboBox<String>(arr);
			southPane.add(cb1);
		cb2 = new JComboBox<String>(cbTest);
			southPane.add(cb2);
		
		model.addElement("모델");
		model.addElement("테스트");
		model.addElement("입니다.");
		cb3 = new JComboBox<String>(model);
			southPane.add(cb3);
		
		setSize(500, 500);
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}

	public static void main(String[] args) {
		new SwingTest();

	}

}

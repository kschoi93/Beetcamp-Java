

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
		JTextField tf1 = new JTextField("�̰��� Swing��");
		JTextField tf2 = new JTextField("������ ����");
		JTextField tf3 = new JTextField("�Դϴ�");
	JPanel southPane = new JPanel(new GridLayout(0,3));	
		JComboBox<String> cb1, cb2, cb3;
		DefaultComboBoxModel<String> model = new DefaultComboBoxModel<String>();
		String cbTest[] = {"�޺��ڽ�","��","�̷���","�˴ϴ�"};
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
		arr.add("�̰���");
		arr.add("�޺��ڽ�");
		arr.add("����");		
		cb1 = new JComboBox<String>(arr);
			southPane.add(cb1);
		cb2 = new JComboBox<String>(cbTest);
			southPane.add(cb2);
		
		model.addElement("��");
		model.addElement("�׽�Ʈ");
		model.addElement("�Դϴ�.");
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

import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.Iterator;
import java.util.Set;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import attach.DatabaseData;
import attach.DatabaseVO;


public class FrameMain extends JFrame implements ActionListener{
	Font font = new Font("����",Font.BOLD,10);
	JTextField numField = new JTextField(); // ��ȣ �Է�
	JTextField nameField = new JTextField(); // �̸� �Է�
	JTextField phoneField = new JTextField(); // ��ȭ��ȣ �Է�
	JTextField adressField = new JTextField(); // �ּ� �Է�
	JTextField rrNumField = new JTextField(); // �ֹι�ȣ �Է�
	JPanel pane = new JPanel();
	JPanel addPane = new JPanel();
	JButton memButton = new JButton("ȸ �� �� ��");
	static Object[][] x = {{"x1","X1","X1","X1","X1"},{"X2","X1","X1","X1","X1"}};
	static String y[] = {"��ȣ","�̸�","��ȭ��ȣ","�ּ�","�ֹι�ȣ"};
	JTable addTable = new JTable(x,y);
	JScrollPane jsp = new JScrollPane(addTable);
	
	JTextArea textArea = new JTextArea();
	public FrameMain(){
		setLayout(null);
		//////////////////// ȸ����� /////////////////////
		add(pane); //ȸ����� ����
		pane.setBounds(10,10,470,110);
		pane.setBorder(new TitledBorder(new LineBorder(Color.DARK_GRAY,3),"ȸ�����"));
		pane.setLayout(null);
		
		pane.add(new JLabel("��ȣ")).setBounds(25,20,50,30);
		pane.add(new JLabel("�̸�")).setBounds(75,20,50,30);
		pane.add(new JLabel("��ȭ��ȣ")).setBounds(140,20,50,30);
		pane.add(new JLabel("�ּ�")).setBounds(260,20,50,30);
		pane.add(new JLabel("�ֹι�ȣ")).setBounds(375,20,50,30);
		
		pane.add(numField); // ȸ����� �̸�
		numField.setBounds(20, 45, 40, 20);
		numField.setFont(font);
		
		pane.add(nameField); // ȸ����� �̸�
		nameField.setBounds(70, 45, 40, 20);
		nameField.setFont(font);
		
		pane.add(phoneField); // ȸ����� ��ȭ��ȣ
		phoneField.setBounds(120, 45, 90, 20);
		phoneField.setFont(font);
		
		pane.add(adressField); // ȸ�����  �ּ�
		adressField.setBounds(220, 45, 120, 20);
		adressField.setFont(font);
		
		pane.add(rrNumField); // ȸ����� �ֹι�ȣ
		rrNumField.setBounds(350, 45, 100, 20);
		rrNumField.setFont(font);
		
		pane.add(memButton).setBounds(20,73,430,20);
		memButton.addActionListener(this);
		///////////////////////////////////////////////////////
		//////////////////////ȸ�� ��� Ȯ��//////////////////////
//		DatabaseVO vo = new DatabaseVO();
//		Set<String> set= DatabaseData.hm.keySet();
//		Iterator<String> itr= set.iterator();
//		while(itr.hasNext()) {
//			String num = (String)itr.next();
//			int i = Integer.parseInt(num);
//			String x2[][] = (String)x[][];
//			String x[][] = {vo.getNumber(),vo.getName(),};
//		}
		
		add(addPane).setBounds(30,130,470,110);
		addPane.setLayout(null);
		addPane.add(jsp).setBounds(0,0, 440, 110);
		addPane.add(new JTextArea());
		addPane.add(textArea);
		
		
		setSize(510,500);
		setVisible(true);
		setResizable(false);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
	}
	
	public static void main(String[] args) {
		new FrameMain();
	}
	
	public void setTable() {
		
	}
	
	public void DatabasePrint(){
		Set<Integer> keyList = DatabaseData.hm.keySet();
		Iterator<Integer> i = keyList.iterator();
		while(i.hasNext()) {
			DatabaseVO vo = DatabaseData.hm.get(i.next());
			System.out.printf("|%s\t%s\t%s\t%s\t%s  |\n",vo.getNumber(),vo.getName(),
					vo.getTel(),vo.getAdress(),vo.getRrNum());
		}
	}
	// ȸ����� �̺�Ʈ
	@Override
	public void actionPerformed(ActionEvent ae) {
		String num = numField.getText();
		String name = nameField.getText();
		String phone = phoneField.getText();
		String adress = adressField.getText();
		String rrNum = rrNumField.getText();
		int number = Integer.parseInt(num);
		DatabaseData.hm.put(number, new DatabaseVO(number,name,phone,adress,rrNum));
	}
}

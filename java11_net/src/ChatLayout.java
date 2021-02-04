import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ChatLayout extends JFrame {
	JPanel center = new JPanel();
		JPanel centerE = new JPanel();
			JLabel list = new JLabel("접속자 리스트");
			String ac[] = { "" ,""};
			JList<String> acList = new JList<String>(ac);
			JLabel human = new JLabel("현재원 : 0명");
		
		JPanel centerC = new JPanel();
			JPanel centerCN = new JPanel();
				JTextField ipField = new JTextField(20);
				Button access = new Button("접속");
			JTextArea ta = new JTextArea();
			JPanel centerCS = new JPanel();
				JTextField msg = new JTextField(20);
				Button send = new Button("보내기");
		JScrollPane scTa = new JScrollPane(ta);
		JScrollPane scList = new JScrollPane(acList);
	public ChatLayout() {
		add("East",new JLabel("      "));
		add("West",new JLabel("      "));
		add("South",new JLabel("  "));
		add("North",new JLabel("  "));
			center.setLayout(new BorderLayout());
		add(center);
		centerC.setLayout(new BorderLayout());
			//center 북
			centerCN.setLayout(new BorderLayout());
			ipField.setBackground(new Color(50,150,180).brighter());
			ipField.setText("192.168.0.39");
			centerCN.add("Center",ipField);
			centerCN.add("East",access);
			centerC.add("North",centerCN);
			//center 중
			ta.setBackground(new Color(0,0,250).darker());
			scTa.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
			centerC.add("Center",scTa);
			//center 남
			centerCS.setLayout(new BorderLayout());
			msg.setBackground(new Color(50,150,180).brighter());
			centerCS.add("Center",msg);
			centerCS.add("East",send);
			centerC.add("South",centerCS);
		
		center.add("Center",centerC);			
		centerE.setLayout(new BorderLayout());
			//East 북
			list.setHorizontalAlignment(JLabel.CENTER);
			centerE.add("North",list);
			//East 중
			acList.setPreferredSize(new Dimension(150,MAXIMIZED_HORIZ));
			scList.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
			centerE.add("Center",scList);
			//East 남
			centerE.add("South",human);
			centerE.setBackground(Color.gray.brighter());
		center.add("East",centerE);
		
		setTitle("Chat Client");
		getContentPane().setBackground(Color.gray.brighter());
		setSize(500,300);
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		ipField.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				Object obj = e.getButton();
				if(obj.equals(1)) {
					if(ipField.getText().equals("192.168.0.39")) {
						ipField.setText("");
					}
				}
			}
		});
	}
	public static void main(String[] args) {
		new ChatLayout();
	}

}

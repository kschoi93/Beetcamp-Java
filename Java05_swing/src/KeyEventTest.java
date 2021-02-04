

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class KeyEventTest extends JFrame implements KeyListener, ActionListener{
	JPanel pane = new JPanel();
	JTextArea ta = new JTextArea();
	JScrollPane sp = new JScrollPane(ta);
	JButton btn = new JButton("������");
	JTextField tf = new JTextField(20);
	
	Font fnt = new Font("�ü�ü", Font.BOLD, 20);
	public KeyEventTest() {
		super("key�̺�Ʈ");
		
		add(sp);
		
		add(BorderLayout.SOUTH, pane);
		pane.add(tf);
		pane.add(btn);
		
		//ta�� Font��ü �����ϱ�
		ta.setFont(fnt);
		
		setSize(400, 500);
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		//�̺�Ʈ ���
		tf.addKeyListener(this);
		//�ٸ� Ŭ�������� �̺�Ʈ ó��
		//						��ư�� ����Ǹ� �Ʒ� Ŭ������ ����.
		btn.addActionListener(new SendButton(ta, tf));
	}
	//�������̽� �������̵�
	public void keyPressed(KeyEvent ke) {//Ű�� ���� ����
		
	}
	public void keyReleased(KeyEvent ke) {//Ű�� ���� �� ������
		//�̺�Ʈ�� �߻��� Ű���� ������
		char evtChar = ke.getKeyChar();
		int evtInt = ke.getKeyCode();
		System.out.println(evtChar+"->"+evtInt);
		
		if(evtInt == KeyEvent.VK_ENTER) {
			ta.append(tf.getText()+"\n");
			tf.setText("");
		}else if(evtInt == KeyEvent.VK_ESCAPE) {
			System.exit(0); //���α׷� ����
		}
	}
	public void keyTyped(KeyEvent ke) {//Ű�� ���� �� ������
		
	}
	public void actionPerformed(ActionEvent ae) {
		
	}
	public static void main(String[] args) {
		new KeyEventTest();

	}

}



import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class ActionEventTest implements ActionListener {
	JFrame frm = new JFrame("ActionEvent");
	JButton btn2 = new JButton("3��");
	JButton btn = new JButton("Ŭ��");
	JTextArea ta = new JTextArea("��ư�� Ŭ���ϼ���..");
	JScrollPane sp = new JScrollPane(ta);
	
	public ActionEventTest() {
		frm.add(BorderLayout.NORTH, btn);
		frm.add(BorderLayout.SOUTH, btn2);
		frm.add(sp);
		
		
		
		
		frm.setSize(500,500);
		frm.setVisible(true);
		frm.setDefaultCloseOperation(frm.DISPOSE_ON_CLOSE);
		
		
		
		// �̺�Ʈ ���
		btn.addActionListener(this);
		btn2.addActionListener(this);
	}

	// �߻�޼��� �������̵�
	public void actionPerformed(ActionEvent ae) {

//		ta.append("click\n");
		// setText() : ���ο� ���ڷ�
		// append() : �������� ���� �߰�
		// insert() : ���ϴ� ��ġ(index)�� �����߰�
		// 1. �̺�Ʈ�� �߻��� ��ư �˾Ƴ��� -> getActionCommand()
//		String evt = ae.getActionCommand();
//		if(evt.equals("Ŭ��")) {
//			ta.append(evt+"\n");
//		} else if(evt.equals("3��")) {
//			gugudan(3);
//		}
//		
		// 2. �̺�Ʈ�� �߻��� ��ü�� �̿��ؼ� �˾Ƴ���
		Object obj = ae.getSource();
		if(obj == btn) { // Ŭ����ư ���� ������
			ta.append("btn��ư Ŭ��");
		} else if(obj == btn2) {
			gugudan(9);
		}
		
	}
	public void gugudan(int dan) {
		for(int i=1; i<=9; i++) {
			ta.append(dan+"*"+i+" = "+(dan*i)+"\n");
		}
	}
	
	public static void main(String[] args) {
		new ActionEventTest();
	}

}

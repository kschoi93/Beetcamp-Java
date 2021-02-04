

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
	JButton btn2 = new JButton("3단");
	JButton btn = new JButton("클릭");
	JTextArea ta = new JTextArea("버튼을 클릭하세요..");
	JScrollPane sp = new JScrollPane(ta);
	
	public ActionEventTest() {
		frm.add(BorderLayout.NORTH, btn);
		frm.add(BorderLayout.SOUTH, btn2);
		frm.add(sp);
		
		
		
		
		frm.setSize(500,500);
		frm.setVisible(true);
		frm.setDefaultCloseOperation(frm.DISPOSE_ON_CLOSE);
		
		
		
		// 이벤트 등록
		btn.addActionListener(this);
		btn2.addActionListener(this);
	}

	// 추상메서드 오버라이딩
	public void actionPerformed(ActionEvent ae) {

//		ta.append("click\n");
		// setText() : 새로운 문자로
		// append() : 마지막에 문자 추가
		// insert() : 원하는 위치(index)에 문자추가
		// 1. 이벤트가 발생한 버튼 알아내기 -> getActionCommand()
//		String evt = ae.getActionCommand();
//		if(evt.equals("클릭")) {
//			ta.append(evt+"\n");
//		} else if(evt.equals("3단")) {
//			gugudan(3);
//		}
//		
		// 2. 이벤트가 발생한 객체를 이용해서 알아내기
		Object obj = ae.getSource();
		if(obj == btn) { // 클릭버튼 선택 했을때
			ta.append("btn버튼 클릭");
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

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class CustomRevise extends JPanel implements ActionListener{
	Font fnt = new Font("굴림체",Font.BOLD,14);
	Font titleFnt = new Font("굴림체",Font.BOLD,24);
	JPanel main = new JPanel();
	JPanel lblPane= new JPanel();
		JLabel titleLbl = new JLabel("회원정보수정");
		JPanel hanPane = new JPanel();
			JLabel hanLbl = new JLabel("이름(한글)");
			JTextField hanField = new JTextField(30);
		JPanel engPane = new JPanel();
			JLabel engLbl = new JLabel("이름(영문) ex) kyung sik choi");
			JTextField engField = new JTextField(30);
		JPanel pwdPane = new JPanel();
			JLabel pwdLbl = new JLabel("비밀번호");
			JTextField pwdField = new JTextField(30);
		JPanel telPane = new JPanel();
			JLabel telLbl = new JLabel("연락처");
			JTextField telField = new JTextField(30);
		JPanel birthPane = new JPanel();
			JLabel birthLbl = new JLabel("생년월일");
			JTextField birthField = new JTextField(30);
		JPanel nationPane = new JPanel();
			JLabel nationLbl = new JLabel("국적");
			JTextField nationField = new JTextField(30);
		JPanel emailPane = new JPanel();
			JLabel emailLbl = new JLabel("이메일");
			JTextField emailField = new JTextField(30);
		
		JPanel buttonPane = new JPanel();
			JButton saveBtn = new JButton("저장");
			JButton cancelBtn = new JButton("취소");
			JButton withdrawalBtn = new JButton("회원탈퇴");
		JPanel[] pane = {hanPane,engPane,pwdPane,telPane,birthPane,nationPane,emailPane};
		JLabel[] lbl = {hanLbl,engLbl,pwdLbl,telLbl,birthLbl,nationLbl,emailLbl};
		JTextField[] tf = {hanField,engField,pwdField,telField,birthField,nationField,emailField};
		
	public CustomRevise() {
		setLayout(new BorderLayout(250,50));
		add("North",new JLabel());
		add("East",new JLabel());
		add("West",new JLabel());
		add("South",new JLabel());
		add(main);
		main.setBackground(Color.white);
		main.setLayout(new GridLayout(9,1));
		main.add(titleLbl);
			titleLbl.setHorizontalAlignment(JLabel.CENTER);
			titleLbl.setOpaque(true);
			titleLbl.setBackground(Color.white);
			titleLbl.setFont(titleFnt);
		
		for(int i=0; i<pane.length;i++) {
			main.add(pane[i]);
			pane[i].setLayout(new BorderLayout(0,15));
			pane[i].setBackground(Color.white);
			pane[i].add("North",new JLabel());
			pane[i].add("East",new JLabel());
			pane[i].add("West",new JLabel());
			pane[i].add("South",new JLabel());
			pane[i].add("West", lbl[i]);
			pane[i].add("East", tf[i]);
			lbl[i].setOpaque(true);
			lbl[i].setFont(fnt);
			lbl[i].setBackground(Color.white);
			lbl[i].setHorizontalAlignment(JLabel.CENTER);
			tf[i].setFont(fnt);
		}
		main.add(buttonPane);
		buttonPane.setBackground(Color.white);
			buttonPane.add(saveBtn);
				saveBtn.setFont(fnt);
				saveBtn.setForeground(Color.white);
				saveBtn.setBackground(new Color(0,130,255));
			buttonPane.add(cancelBtn);
				cancelBtn.setFont(fnt);
				cancelBtn.setForeground(Color.white);
				cancelBtn.setBackground(new Color(0,130,255));
			buttonPane.add(withdrawalBtn);
				withdrawalBtn.setFont(fnt);
				withdrawalBtn.setForeground(Color.white);
				withdrawalBtn.setBackground(new Color(0,130,255));
		
		setBackground(Color.white);
		setSize(1000,800);
		setVisible(true);
		
		saveBtn.addActionListener(this);
		cancelBtn.addActionListener(this);
		withdrawalBtn.addActionListener(this);
	}
	// 이벤트 등록
	public void actionPerformed(ActionEvent ae) {
		Object obj = ae.getSource();
		if(obj instanceof JButton) {
			String btn = ae.getActionCommand();
			if(btn.equals("저장")) {
				
			} else if(btn.equals("취소")) {
				this.setVisible(false);
				CustomFrame.plan.setVisible(true);
			} else if(btn.equals("회원탈퇴")) {
				String msg = "마일리지를 포함한\n고객의 모든 정보가 삭제됩니다.\n탈퇴하시겠습니까?";
				int state = JOptionPane.showOptionDialog(this, msg, "회원탈퇴", JOptionPane.YES_NO_OPTION,JOptionPane.PLAIN_MESSAGE, null,null, obj);
				// yes 누르면 0 no 누르면 1 리턴
				if(state==0) {
					// db 연결하여 삭제
					JOptionPane.showMessageDialog(this, "회원탈퇴 되었습니다\n이용해주셔서 감사합니다");
					System.exit(0);
				}
			}
		}
	}
}

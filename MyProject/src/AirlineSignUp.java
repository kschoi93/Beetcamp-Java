
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class AirlineSignUp extends JFrame implements ActionListener{
	Font fnt = new Font("굴림체",Font.BOLD,14);
	Font titleFnt = new Font("굴림체",Font.BOLD,32);
	JLabel titleLbl = new JLabel("회 원 가 입");
	JLabel idLbl = new JLabel("아이디");
	JTextField idField = new JTextField(30);
	JButton duplicateBtn = new JButton("중복 확인");
	JLabel pwdLbl = new JLabel("비밀번호");
	JPasswordField pwdField = new JPasswordField(30);
	JLabel pwdcheckLbl = new JLabel("비밀번호 확인");
	JPasswordField pwdcheckField = new JPasswordField(30);
	JLabel nameLbl = new JLabel("이름(한글)");
	JTextField nameField = new JTextField(30);
	JLabel nameCheckLbl = new JLabel("이름(영문)");
	JTextField nameCheckField = new JTextField(30);
	JLabel telLbl = new JLabel("연락처");
	JTextField telField = new JTextField(30);
	JLabel emailLbl = new JLabel("이메일");
	JTextField emailField = new JTextField(30);

	JButton saveBtn = new JButton("회원가입");
	JButton cancelBtn = new JButton("취소");
	public AirlineSignUp() {
		setLayout(null);
		int x=300;
		int x1=410;
		add(titleLbl).setBounds(450,100,200,30);
		titleLbl.setFont(titleFnt);
		add(idLbl).setBounds(x,200,100,30); add(idField).setBounds(x1,200,250,30); add(duplicateBtn).setBounds(670,200,110,30);
		idLbl.setFont(fnt);
		idField.setFont(fnt);
		duplicateBtn.setFont(fnt);
		duplicateBtn.setBackground(new Color(0,130,255));
		duplicateBtn.setForeground(Color.white);
		add(pwdLbl).setBounds(x,250,100,30); add(pwdField).setBounds(x1,250,250,30); 
		pwdLbl.setFont(fnt);
		pwdField.setFont(fnt);
		add(pwdcheckLbl).setBounds(x,300,100,30); add(pwdcheckField).setBounds(x1, 300, 250, 30); 
		pwdcheckLbl.setFont(fnt);
		pwdcheckField.setFont(fnt);
		add(nameLbl).setBounds(x,350,100,30); add(nameField).setBounds(x1,350,250,30);
		nameLbl.setFont(fnt);
		nameField.setFont(fnt);
		add(nameCheckLbl).setBounds(x,400,100,30); add(nameCheckField).setBounds(x1,400,250,30);
		nameCheckLbl.setFont(fnt);
		nameCheckField.setFont(fnt);
		add(telLbl).setBounds(x,450,100,30); add(telField).setBounds(x1,450,250,30);
		telLbl.setFont(fnt);
		telField.setFont(fnt);
		add(emailLbl).setBounds(x,500,100,30); add(emailField).setBounds(x1,500,250,30);
		emailLbl.setFont(fnt);
		emailField.setFont(fnt);
		
		
		add(saveBtn).setBounds(400,600,100,30); add(cancelBtn).setBounds(530,600,100,30);
		saveBtn.setFont(fnt);
		saveBtn.setBackground(new Color(0,130,255));
		saveBtn.setForeground(Color.white);
		cancelBtn.setFont(fnt);
		cancelBtn.setBackground(new Color(0,130,255));
		cancelBtn.setForeground(Color.white);
		
		setBackground(Color.white);
		setSize(1000,800);
		setVisible(true);
		
		duplicateBtn.addActionListener(this);
		saveBtn.addActionListener(this);
		cancelBtn.addActionListener(this);
	}
	// 이벤트 등록
	public void actionPerformed(ActionEvent ae) {
		Object obj = ae.getSource();
		if(obj instanceof JButton) {
			String btn = ae.getActionCommand();
			if(btn.equals("회원가입")) {
				String password = pwdField.getText();
				String pwdCheck = pwdcheckField.getText();
				if(idField.getText().equals("")) {
					JOptionPane.showMessageDialog(this, "아이디를 입력하셔야 합니다");
				} else if(idField.getText().length()<6) {
					JOptionPane.showMessageDialog(this, "아이디는 6자리 이상이어야 합니다.");
				}  
//				String [] =
//				for(int i=0; i<) // 아이디 비밀번호 / 숫자, 영어를 제외한 문자 입럭하지 못하게 
				else if(password.equals("")) {
					JOptionPane.showMessageDialog(this, "비밀번호를 입력하셔야 합니다");
				} else if(pwdCheck.equals("")) {
					JOptionPane.showMessageDialog(this, "비교할 비밀번호를 입력해 주시기 바랍니다");
				} else if(!password.equals(pwdCheck)) {
					JOptionPane.showMessageDialog(this, "비밀번호가 일치하지 않습니다");
				} else if(nameField.getText().equals("")) {
					JOptionPane.showMessageDialog(this, "이름(한글)을 입력하셔야 합니다");
				} else if(nameCheckField.getText().equals("")) {
					JOptionPane.showMessageDialog(this, "이름(영문)을 입력하셔야 합니다");
				} else if(telField.getText().equals("")) {
					JOptionPane.showMessageDialog(this, "연락처를 입력하셔야 합니다");
				} else if(emailField.getText().equals("")){
					JOptionPane.showMessageDialog(this, "이메일을 입력하셔야 합니다");
				} else {
					
					JOptionPane.showMessageDialog(this, "회원가입에 성공하였습니다\n원활한 이용을 위하여\n로그인 해주시기 바랍니다");
					// 회원 db에 데이터 넣는거 만들어야함
					dispose();
					new AirlineMain();
				}
			} else if(btn.equals("취소")) {
				dispose();
				new AirlineMain();
				
			} else if(btn.equals("중복 확인")) {
				//db 연결
			}
		}
	}
	
}

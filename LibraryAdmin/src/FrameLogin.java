

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class FrameLogin extends JFrame implements ActionListener{
	public static final String System = null;
	private final String IDTEST = "admin";
	private final String PWDTEST = "1234";

	Font titleFont = new Font("바탕",Font.BOLD,24);
	Font bodyFont = new Font("바탕",Font.BOLD,14);
	JTextField idField = new JTextField(10);
	JPasswordField pwdField = new JPasswordField(15);
	JLabel titleLbl = new JLabel("관리자 프로그램 로그인");
	JLabel idLbl = new JLabel("ID");
	JLabel pwdLbl = new JLabel("Password");
	JButton loginButton = new JButton("로그인");
	JDialog dialog = new JDialog();
	JPanel pane = new JPanel();
	
	
	public FrameLogin() {
		super("도서관리 프로그램");
		setLayout(null);
		
		// 제목라벨
		add(titleLbl).setBounds(55,30,300,100);
		titleLbl.setFont(titleFont);
		
		// 아이디 라벨
		add(idLbl).setBounds(30,120,240,30);
		idLbl.setFont(bodyFont);
		
		// 아이디 로그인
		add(idField).setBounds(30,150,240,30);
		idField.setFont(bodyFont);
		
		// 패스워드 라벨
		add(pwdLbl).setBounds(30,190,240,30);
		pwdLbl.setFont(bodyFont);;
		
		// 패스워드 로그인
		add(pwdField).setBounds(30,220,240,30);
		pwdField.setFont(bodyFont);
		
		// 로그인 버튼
		add(loginButton).setBounds(280,150,80,100);
		loginButton.setFont(bodyFont);
		
		loginButton.addActionListener(this);
		setResizable(false);
		setSize(400, 400);
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
	}
	
	public static void main(String[] args) {
		
		new FrameLogin();
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		String id = idField.getText();
		String pwd = pwdField.getText();
		if(id.equals(IDTEST) && pwd.equals(PWDTEST)) {
			setVisible(false);
			dispose();
			new FrameMain();
			
		} else { 
			dialog.setVisible(true);
			dialog.setSize(200,100);
			dialog.setModal(true);
			dialog.add(new JLabel("아이디/비밀번호가 틀렸습니다."));
			
		}
	}
}

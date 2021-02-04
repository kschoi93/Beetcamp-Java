import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class SourceView extends JFrame implements ActionListener{
	// 폰트는 모두 이것으로
	Font fnt = new Font("휴면편지체", Font.BOLD, 20);
	// 탑패널은 url, 텍스트필드, 버튼이 들어간다
	JPanel topPane = new JPanel();
		JTextField tf = new JTextField();
		JButton btn = new JButton("클릭");
	// 중앙 패널은 
		JTextArea ta = new JTextArea();
		// 탭 패널 객체 생성
		JTabbedPane tap = new JTabbedPane(); // 탭에 ta를 넣을거다
		JScrollPane sp = new JScrollPane(tap);
	public SourceView() {
		//기본 레이아웃은 보더로
		setLayout(new BorderLayout());
		// 탑 패널 레이아웃은 동 서 중앙으로 3개로 나눈다
		topPane.setLayout(new BorderLayout());
		// 폰트지정 텍스트 필드와 에어리어
		tf.setFont(fnt);
		ta.setFont(fnt);
		// 탑패널에 추가 3가지
		topPane.add("West",new JLabel("URL"));
		topPane.add("Center",tf);
		topPane.add("East",btn);
		add("North",topPane);
		add("Center",sp);
		
		
		setSize(1000,800);
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		// 키 어댑터, tf에서 엔터를 누를경우 메소드 실행
		tf.addKeyListener(new KeyAdapter() {
			public void keyReleased(KeyEvent ke) {
				int key = ke.getKeyCode();
				if(key == ke.VK_ENTER) {
					checkUrl();
				}
			}
		});
		// 버튼 누를경우 이벤트 실행
		btn.addActionListener(this);
	}
	// 액션이벤트
	public void actionPerformed(ActionEvent ae) {
		Object obj = ae.getActionCommand();
		if(obj.equals("클릭")) {
			checkUrl();
		}
	}
	// 버튼과 키를 눌렀을 때 메소드 실행
	public void checkUrl() {
		try{
			URL url = new URL(tf.getText());
			InputStream is = url.openStream();
			InputStreamReader isr = new InputStreamReader(is);
			BufferedReader br = new BufferedReader(isr);
			
//			URLConnection con = url.openConnection();
//			con.connect();
//			String contentType = con.getContentType();
//			String encoding = contentType.substring(contentType.indexOf("=")+1);
//			
//			BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream(),encoding));

			while(true) {
				String line = br.readLine();
				if(line==null)break;
				ta.append(line+"\n");
			}
			tap.add(tf.getText(),ta);
			tf.setText("");
		}catch(Exception e) {
			JOptionPane.showMessageDialog(this, "주소를 잘못 입력하셨습니다");
		}
	}
	

	public static void main(String[] args) {
		new SourceView();

	}

}

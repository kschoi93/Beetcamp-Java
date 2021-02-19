

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Component;
import java.awt.ComponentOrientation;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.GridLayout;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.plaf.basic.BasicSplitPaneUI.BasicVerticalLayoutManager;
import javax.swing.table.DefaultTableModel;

public class MemberLayout extends JFrame{
	Font fnt = new Font("굴림체",Font.BOLD,12);
	
	// 상단패널
	JPanel northPane = new JPanel();
		JPanel boxPane = new JPanel();
			JPanel numPane = new JPanel(); JTextField numField = new JTextField(5);
			JPanel namePane = new JPanel(); JTextField nameField = new JTextField(10);
			JPanel telPane = new JPanel(); JTextField telField = new JTextField(30);
			JPanel emailPane = new JPanel(); JTextField emailField = new JTextField(30);
			JPanel addrPane = new JPanel(); JTextField addrField = new JTextField(50);
			JPanel datePane = new JPanel(); JTextField dateField = new JTextField(50);
		String[] northStr = {"번호","이름","전화번호","이메일","주소","등록일"};
		int[] northY = {5,35,70,105,140,175};
		
		
	// 중앙패널	
	JPanel centerPanel= new JPanel();
		//버튼
		JPanel grid = new JPanel(new GridLayout(1,7));
		String[] gridButtonStr = {"추가","수정","삭제","지우기","종료","엑셀로저장","엑셀불러오기"};
	
		// 테이블
		String header[] = {"번호","이름","전화번호","이메일","주소","등록일"};
		String contents[][]={
				{"","","","","",""}
		};

	
	// 하단패널
	JPanel searchPanel=new JPanel();
		JPanel searchPane = new JPanel(new FlowLayout());
			JTextField searchTextField = new JTextField(20);
			JButton searchBtn = new JButton("Serach");
	public MemberLayout() {

		// 상단 패널
		add(northPane);
		northPane.setLayout(null);
		northPane.setBounds(0,0,800,200);
		
			// 라벨 설정
			for(int i =0; i<northStr.length;i++) {
				JLabel str = new JLabel(northStr[i]);
				northPane.add(str).setBounds(5, northY[i], 70, 25);
				str.setFont(fnt);
			}	
			// 텍스트 필드 설정
			northPane.add(numField); numField.setBounds(70, 5, 30, 25);
			northPane.add(nameField); nameField.setBounds(70, 35, 100, 25);
			northPane.add(telField); telField.setBounds(70, 70, 200, 25);
			northPane.add(emailField); emailField.setBounds(70, 105, 200, 25);
			northPane.add(addrField); addrField.setBounds(70, 140, 400, 25);
			northPane.add(dateField); dateField.setBounds(70, 175, 400, 25);
			
		// 중앙패널
		add(centerPanel);
			centerPanel.setLayout(null);
			centerPanel.setBounds(0,205,800,210);
			
			// 버튼패널
			centerPanel.add(grid);
			grid.setBounds(0,0,800,30);
			for(int i=0;i<gridButtonStr.length;i++) {
				JButton btn = new JButton();
				grid.add(btn);
				btn.setText(gridButtonStr[i]);
				btn.setFont(fnt);
			}
				
			DefaultTableModel model = new DefaultTableModel(contents,header);
			JTable table = new JTable(model);
			JScrollPane scrollPane = new JScrollPane(table);
			centerPanel.add(scrollPane).setBounds(0,30,800,180);
			
		add(searchPanel);
			searchPanel.setLayout(null);
			searchPanel.add(searchPane).setBounds(0,420,800,30);;
				searchPane.add(searchTextField).setBounds(0,0,800,30);
				searchPane.add(searchBtn).setBounds(0,0,800,30);
				
			
		
		setTitle("회원관리");
		setSize(800,500);
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}

	public static void main(String[]args) {
		new MemberLayout();
	}
}

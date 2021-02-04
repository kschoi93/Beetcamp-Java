

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JToolBar;
import javax.swing.KeyStroke;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

public class MenuTest extends JFrame implements ActionListener{
	JTextArea ta = new JTextArea();
	JScrollPane sp = new JScrollPane(ta);
	JMenuBar mb = new JMenuBar();
		JMenu fileMenu = new JMenu("파일");
			JMenuItem newMenuItem = new JMenuItem("새문서");
			JMenuItem openMenuItem = new JMenuItem("열기");
			JMenuItem saveMenuItem = new JMenuItem("저장");
			JMenuItem endMenuItem = new JMenuItem("종료");
		JMenu editMenu = new JMenu("편집");
			JMenuItem cutMenuItem = new JMenuItem("오려두기");
			JMenuItem copyMenuItem = new JMenuItem("복사하기");
			JMenuItem pasteMenuItem = new JMenuItem("붙여넣기");
		JMenu runMenu = new JMenu("실행");
			JMenuItem chromeMenuItem = new JMenuItem("크롬");
			JMenu editor = new JMenu("편집기");
				JMenuItem memoMenuItem = new JMenuItem("메모장");
				JMenuItem editplusMenuItem = new JMenuItem("에디트플러스");
			JMenuItem compileMenuItem = new JMenuItem("컴파일");
			
		////툴바/////////////////////////////////
		JToolBar tb = new JToolBar();
		//새문서
		ImageIcon newIcon = new ImageIcon("icon/new01.gif"); JButton newBtn = new JButton(newIcon);
		//저장
		ImageIcon saveIcon = new ImageIcon("icon/save01.gif"); JButton saveBtn = new JButton(saveIcon);
		//열기
		ImageIcon openIcon = new ImageIcon("icon/open01.gif"); JButton openBtn = new JButton(openIcon);
		//진하게
		ImageIcon boldIcon = new ImageIcon("icon/bold01.gif"); 
		JButton boldBtn = new JButton(boldIcon);
		//이탤릭
		ImageIcon italicIcon = new ImageIcon("icon/italic01.gif"); JButton italicBtn = new JButton(italicIcon);
		//글자크기
		JComboBox<Integer> fontSize = new JComboBox<Integer>();
		DefaultComboBoxModel<Integer> fontSizeModel = new DefaultComboBoxModel<Integer>();		
		//글꼴
		JComboBox<String> fontName;
		/////////////////////////////
		String textBuffer;
		
		//Font 관련기능
		int bold = 0, italic = 0;
		Font fnt = new Font("굴림체",0,14);
		
	public MenuTest() {
		super("메모장");
		add(sp);
		setJMenuBar(mb);
		// fileMenu
		fileMenu.add(newMenuItem);
		fileMenu.add(openMenuItem);
		fileMenu.add(saveMenuItem);
		fileMenu.addSeparator();//경계선
		fileMenu.add(endMenuItem);
		mb.add(fileMenu);
		
		
		// editMenu
		editMenu.add(cutMenuItem);
		editMenu.add(copyMenuItem);
		editMenu.add(pasteMenuItem);
		mb.add(editMenu);

		
		// runMenu
		runMenu.add(chromeMenuItem);
		runMenu.add(editor);
			editor.add(memoMenuItem);
			editor.add(editplusMenuItem);
		runMenu.add(compileMenuItem);
		mb.add(runMenu);
		
		/////////////툴바/////////////////
		tb.add(newBtn);
		tb.add(openBtn);
		tb.add(saveBtn);
		tb.addSeparator();
		tb.add(boldBtn);
		tb.add(italicBtn);
		add(BorderLayout.NORTH,tb);
		
		for(int i=8; i<=70; i+=2) {
			fontSizeModel.addElement(i);
		}
		fontSize.setModel(fontSizeModel);
		fontSize.setSelectedItem(14); // 초기 글자 크기 설정
		tb.add(fontSize);
		add(BorderLayout.NORTH,tb);

		//////////// 윈도우 운영체제의 글꼴 얻어오기
		GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
		String [] fntList = ge.getAvailableFontFamilyNames();
		fontName = new JComboBox<String>(fntList);
		fontName.setSelectedItem("굴림체");
		tb.add(fontName);
		
		ta.setFont(fnt);
		
		/////////////////////////////
		
		//단축키 설정
		setShortCut();

		
		
		//
		setSize(1000,500);
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		
		// 메뉴 이벤트 발생
		newMenuItem.addActionListener(this);
		openMenuItem.addActionListener(this);
		saveMenuItem.addActionListener(this);
		endMenuItem.addActionListener(this);
		
		cutMenuItem.addActionListener(this);
		copyMenuItem.addActionListener(this);
		pasteMenuItem.addActionListener(this);
		
		chromeMenuItem.addActionListener(this);
		memoMenuItem.addActionListener(this);
		editplusMenuItem.addActionListener(this);
		compileMenuItem.addActionListener(this);
		
		
		//툴바 이벤트 발생
		newBtn.addActionListener(this);
		openBtn.addActionListener(this);
		saveBtn.addActionListener(this);
		boldBtn.addActionListener(this);
		italicBtn.addActionListener(this);
		fontSize.addActionListener(this);
		fontName.addActionListener(this);
		
	}

	// 이벤트 메소드 JMenu, JButton, JComboBox
	@Override
	public void actionPerformed(ActionEvent ae) {
		Object eventObj = ae.getSource();
		//이벤트가 발생한 객체가 어떤 클래스로 생성된 것인지 확인 객체 instanceof 클래스
		if(eventObj instanceof JMenuItem) {
			String eventMenu = ae.getActionCommand();		
			if(eventMenu.equals("열기")) {
				fileOpen();
			} else if(eventMenu.equals("종료")) {
				System.exit(0);
			} else if(eventMenu.equals("오려두기")) {
				setCut();
			} else if(eventMenu.equals("복사하기")) {
				setCopy();
			} else if(eventMenu.equals("붙여넣기")) {
				setPaste();
			} else if(eventMenu.equals("메모장")) {
				startRuntime("notepad.exe");
			} else if(eventMenu.equals("크롬")) {
				startRuntime("C://Program Files (x86)/Google/Chrome/Application/chrome.exe https://www.nate.com");
			} else if(eventMenu.equals("에디트플러스")) {
				startRuntime("C:/Program Files/EditPlus/editplus.exe");
			} else if(eventMenu.equals("컴파일")) {
				
			}
		} else if(eventObj instanceof JButton) {
			if(eventObj == boldBtn) {
				if(bold == 0) {
					bold = 1;
				} else {
					bold = 0;
				}
				Font fnt = new Font((String)fontName.getSelectedItem(),bold+italic,(Integer)fontSize.getSelectedItem());
				ta.setFont(fnt);
			} else if(eventObj == italicBtn) {
				if(italic==0) italic = 2;
				else italic = 0;
				Font fnt = new Font((String)fontName.getSelectedItem(),bold+italic,(Integer)fontSize.getSelectedItem());
				ta.setFont(fnt);
			} else if(eventObj == openBtn) {
				fileOpen();
			}
		} else if(eventObj instanceof JComboBox) {
			if(eventObj == fontSize || eventObj == fontName) {
				Font fnt = new Font((String)fontName.getSelectedItem(),bold+italic,(Integer)fontSize.getSelectedItem());
				ta.setFont(fnt);
			}
		}
	}
	//파일열기
	public void fileOpen() {
		File f = new File("D://io"); // 기본 위치
		JFileChooser fc = new JFileChooser(f); // 파일탐색기
		//여러파일을 선택할수 있도록 설정
		fc.setMultiSelectionEnabled(true); // true:다중선택, false: 단일선택
		
		//필터 설정 ( 파일열기에서 이미지를 볼거냐, 자바 파일을 볼거냐 확장자 선택하는거다.)
		FileFilter ff1 = new FileNameExtensionFilter("이미지", "jpg","jpeg","gif","png","bmp");
		fc.addChoosableFileFilter(ff1);
		
		FileFilter ff2 = new FileNameExtensionFilter("Java","java","JAVA");
		fc.addChoosableFileFilter(ff2);
		
		// 0: 열기, 1: 취소
		int state = fc.showOpenDialog(this);// 파일 탐색기 열린다
		if(state==0) {
			try {
				ta.setText("");// textArea의 원래 있는 컨텐츠 지우기
//				File selFile = fc.getSelectedFile();
				File selFile[] = fc.getSelectedFiles(); // 여러개의 파일을 열도록 한다.
				
				for(File s: selFile) {
					FileReader fr = new FileReader(s); // 파일을 문자로 읽어온다
					BufferedReader br = new BufferedReader(fr); // 라인 출력할수 있게 해준다
				
				
					while(true) {
						String inData = br.readLine();
						if(inData == null) {
							break;
						}
						ta.append(inData+"\n");
					}//while
					ta.append("------------------------------------\n");
				} // for
			} catch(Exception e) {
				System.out.println("파일열기 에러 발생....");
				e.printStackTrace();
			}
		}
	}

	// 파일 실행
	public void startRuntime(String process) {
		Runtime run = Runtime.getRuntime();
		try{
			run.exec(process);
		} catch(IOException ie) {
			ie.getStackTrace();
		}
	}
	// 복사하기
	public void setCopy() {
		textBuffer = ta.getSelectedText();
	}
	// 붙여넣기
	public void setPaste() {
		if(textBuffer!=null && !textBuffer.equals("")) {
			ta.replaceSelection(textBuffer);
		}
	}
	// 오려내기
	public void setCut() {
		textBuffer = ta.getSelectedText();
		ta.replaceSelection("");
	}
	// 단축키
	public void setShortCut() {
		// 종료 : ctrl + e
		//1. e단축키를 무엇으로 할것인지 설정
//		endMenuItem.setMnemonic(KeyEvent.VK_E); ??? 뭐지?
		//2. ctrl 단축키의 mask설정
		endMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E,ActionEvent.CTRL_MASK));
		
		//새문서 ctrl +n
		newMenuItem.setMnemonic(KeyEvent.VK_N);
		newMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N,ActionEvent.CTRL_MASK));
		
		//열기 alt + o
		openMenuItem.setMnemonic(KeyEvent.VK_O);
		openMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O,ActionEvent.ALT_MASK));
		
		//저장 ctrl + s
		saveMenuItem.setMnemonic(KeyEvent.VK_S);
		saveMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S,ActionEvent.CTRL_MASK));
		
	}
	
	// 메인메소드
	public static void main(String[] args) {
		new MenuTest();
	}
}

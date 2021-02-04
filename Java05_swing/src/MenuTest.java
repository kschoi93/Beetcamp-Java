

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
		JMenu fileMenu = new JMenu("����");
			JMenuItem newMenuItem = new JMenuItem("������");
			JMenuItem openMenuItem = new JMenuItem("����");
			JMenuItem saveMenuItem = new JMenuItem("����");
			JMenuItem endMenuItem = new JMenuItem("����");
		JMenu editMenu = new JMenu("����");
			JMenuItem cutMenuItem = new JMenuItem("�����α�");
			JMenuItem copyMenuItem = new JMenuItem("�����ϱ�");
			JMenuItem pasteMenuItem = new JMenuItem("�ٿ��ֱ�");
		JMenu runMenu = new JMenu("����");
			JMenuItem chromeMenuItem = new JMenuItem("ũ��");
			JMenu editor = new JMenu("������");
				JMenuItem memoMenuItem = new JMenuItem("�޸���");
				JMenuItem editplusMenuItem = new JMenuItem("����Ʈ�÷���");
			JMenuItem compileMenuItem = new JMenuItem("������");
			
		////����/////////////////////////////////
		JToolBar tb = new JToolBar();
		//������
		ImageIcon newIcon = new ImageIcon("icon/new01.gif"); JButton newBtn = new JButton(newIcon);
		//����
		ImageIcon saveIcon = new ImageIcon("icon/save01.gif"); JButton saveBtn = new JButton(saveIcon);
		//����
		ImageIcon openIcon = new ImageIcon("icon/open01.gif"); JButton openBtn = new JButton(openIcon);
		//���ϰ�
		ImageIcon boldIcon = new ImageIcon("icon/bold01.gif"); 
		JButton boldBtn = new JButton(boldIcon);
		//���Ÿ�
		ImageIcon italicIcon = new ImageIcon("icon/italic01.gif"); JButton italicBtn = new JButton(italicIcon);
		//����ũ��
		JComboBox<Integer> fontSize = new JComboBox<Integer>();
		DefaultComboBoxModel<Integer> fontSizeModel = new DefaultComboBoxModel<Integer>();		
		//�۲�
		JComboBox<String> fontName;
		/////////////////////////////
		String textBuffer;
		
		//Font ���ñ��
		int bold = 0, italic = 0;
		Font fnt = new Font("����ü",0,14);
		
	public MenuTest() {
		super("�޸���");
		add(sp);
		setJMenuBar(mb);
		// fileMenu
		fileMenu.add(newMenuItem);
		fileMenu.add(openMenuItem);
		fileMenu.add(saveMenuItem);
		fileMenu.addSeparator();//��輱
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
		
		/////////////����/////////////////
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
		fontSize.setSelectedItem(14); // �ʱ� ���� ũ�� ����
		tb.add(fontSize);
		add(BorderLayout.NORTH,tb);

		//////////// ������ �ü���� �۲� ������
		GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
		String [] fntList = ge.getAvailableFontFamilyNames();
		fontName = new JComboBox<String>(fntList);
		fontName.setSelectedItem("����ü");
		tb.add(fontName);
		
		ta.setFont(fnt);
		
		/////////////////////////////
		
		//����Ű ����
		setShortCut();

		
		
		//
		setSize(1000,500);
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		
		// �޴� �̺�Ʈ �߻�
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
		
		
		//���� �̺�Ʈ �߻�
		newBtn.addActionListener(this);
		openBtn.addActionListener(this);
		saveBtn.addActionListener(this);
		boldBtn.addActionListener(this);
		italicBtn.addActionListener(this);
		fontSize.addActionListener(this);
		fontName.addActionListener(this);
		
	}

	// �̺�Ʈ �޼ҵ� JMenu, JButton, JComboBox
	@Override
	public void actionPerformed(ActionEvent ae) {
		Object eventObj = ae.getSource();
		//�̺�Ʈ�� �߻��� ��ü�� � Ŭ������ ������ ������ Ȯ�� ��ü instanceof Ŭ����
		if(eventObj instanceof JMenuItem) {
			String eventMenu = ae.getActionCommand();		
			if(eventMenu.equals("����")) {
				fileOpen();
			} else if(eventMenu.equals("����")) {
				System.exit(0);
			} else if(eventMenu.equals("�����α�")) {
				setCut();
			} else if(eventMenu.equals("�����ϱ�")) {
				setCopy();
			} else if(eventMenu.equals("�ٿ��ֱ�")) {
				setPaste();
			} else if(eventMenu.equals("�޸���")) {
				startRuntime("notepad.exe");
			} else if(eventMenu.equals("ũ��")) {
				startRuntime("C://Program Files (x86)/Google/Chrome/Application/chrome.exe https://www.nate.com");
			} else if(eventMenu.equals("����Ʈ�÷���")) {
				startRuntime("C:/Program Files/EditPlus/editplus.exe");
			} else if(eventMenu.equals("������")) {
				
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
	//���Ͽ���
	public void fileOpen() {
		File f = new File("D://io"); // �⺻ ��ġ
		JFileChooser fc = new JFileChooser(f); // ����Ž����
		//���������� �����Ҽ� �ֵ��� ����
		fc.setMultiSelectionEnabled(true); // true:���߼���, false: ���ϼ���
		
		//���� ���� ( ���Ͽ��⿡�� �̹����� ���ų�, �ڹ� ������ ���ų� Ȯ���� �����ϴ°Ŵ�.)
		FileFilter ff1 = new FileNameExtensionFilter("�̹���", "jpg","jpeg","gif","png","bmp");
		fc.addChoosableFileFilter(ff1);
		
		FileFilter ff2 = new FileNameExtensionFilter("Java","java","JAVA");
		fc.addChoosableFileFilter(ff2);
		
		// 0: ����, 1: ���
		int state = fc.showOpenDialog(this);// ���� Ž���� ������
		if(state==0) {
			try {
				ta.setText("");// textArea�� ���� �ִ� ������ �����
//				File selFile = fc.getSelectedFile();
				File selFile[] = fc.getSelectedFiles(); // �������� ������ ������ �Ѵ�.
				
				for(File s: selFile) {
					FileReader fr = new FileReader(s); // ������ ���ڷ� �о�´�
					BufferedReader br = new BufferedReader(fr); // ���� ����Ҽ� �ְ� ���ش�
				
				
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
				System.out.println("���Ͽ��� ���� �߻�....");
				e.printStackTrace();
			}
		}
	}

	// ���� ����
	public void startRuntime(String process) {
		Runtime run = Runtime.getRuntime();
		try{
			run.exec(process);
		} catch(IOException ie) {
			ie.getStackTrace();
		}
	}
	// �����ϱ�
	public void setCopy() {
		textBuffer = ta.getSelectedText();
	}
	// �ٿ��ֱ�
	public void setPaste() {
		if(textBuffer!=null && !textBuffer.equals("")) {
			ta.replaceSelection(textBuffer);
		}
	}
	// ��������
	public void setCut() {
		textBuffer = ta.getSelectedText();
		ta.replaceSelection("");
	}
	// ����Ű
	public void setShortCut() {
		// ���� : ctrl + e
		//1. e����Ű�� �������� �Ұ����� ����
//		endMenuItem.setMnemonic(KeyEvent.VK_E); ??? ����?
		//2. ctrl ����Ű�� mask����
		endMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E,ActionEvent.CTRL_MASK));
		
		//������ ctrl +n
		newMenuItem.setMnemonic(KeyEvent.VK_N);
		newMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N,ActionEvent.CTRL_MASK));
		
		//���� alt + o
		openMenuItem.setMnemonic(KeyEvent.VK_O);
		openMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O,ActionEvent.ALT_MASK));
		
		//���� ctrl + s
		saveMenuItem.setMnemonic(KeyEvent.VK_S);
		saveMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S,ActionEvent.CTRL_MASK));
		
	}
	
	// ���θ޼ҵ�
	public static void main(String[] args) {
		new MenuTest();
	}
}

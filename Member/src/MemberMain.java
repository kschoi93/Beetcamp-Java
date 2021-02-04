import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;


public class MemberMain extends JFrame implements ActionListener{
	//JFrame - North -회원입력폼
	JPanel mainNorthPane = new JPanel(new BorderLayout());
		JPanel formLabelPane = new JPanel(new GridLayout(6,1));
			String lbl [] = {"번호","이름","전화번호","이메일","주소","등록일"};
		JPanel formCenterPane = new JPanel(new GridLayout(6,1));
			//							번호[0]				이름[1]			전화번호[2]
			JTextField tf[] = {new JTextField(4), new JTextField(10),new JTextField(20),
					//		이메일[3]				주소[4]				등록일[5]
					new JTextField(30),new JTextField(50), new JTextField(15)};
	//JFrame - Center - 버튼, JTable, 검색
	JPanel mainCenterPane = new JPanel(new BorderLayout());
		//버튼들
		JPanel buttonPane = new JPanel(new GridLayout(1,0));
			String btnLbl[] = {"전체목록","추가","수정","삭제","지우기","종료","엑셀로쓰기","엑셀에서가져오기"};
		//JTable
		JTable table = new JTable();
			JScrollPane sp;
			DefaultTableModel model;
			
			JPanel searchPane = new JPanel();
			JTextField searchTf;
			JButton searchBtn;
			
	Font font = new Font("휴먼편지체",Font.BOLD,14);
			
	public MemberMain() {
		super("회원관리");
		//JFrame - North - 회원입력폼
		add("North",mainNorthPane);
			for(int idx = 0; idx < lbl.length; idx++) {//폼의 라벨
				JLabel formLabel = new JLabel(lbl[idx]);
				formLabelPane.add(formLabel);
				formLabel.setFont(font);
			}
			mainNorthPane.add("West",formLabelPane);
			
			//TextField
			for(int idx=0;idx < tf.length;idx++) {
				JPanel p = new JPanel();
				p.setLayout(new FlowLayout(FlowLayout.LEFT));
				p.add(tf[idx]);
				formCenterPane.add(p);
			}
			mainNorthPane.add("Center",formCenterPane);
		//JFrame - Center - 버튼, JTable, 검색
		add("Center",mainCenterPane);
			//버튼
			for(int idx=0; idx<btnLbl.length; idx++) {
				JButton btn = new JButton(btnLbl[idx]);
				buttonPane.add(btn);
				btn.setBackground(new Color(255,150,0));
				btn.setFont(font);
				
				//이벤트 등록
				btn.addActionListener(this);
			}
			mainCenterPane.add("North",buttonPane);
			//JTable 객체 생성
			model = new DefaultTableModel(lbl,0);
			table = new JTable(model);
			sp = new JScrollPane(table);
			mainCenterPane.add("Center",sp);
		//JFrame South - 검색
		searchPane = new JPanel();
			searchTf = new JTextField(20);
			searchBtn = new JButton("Search");
			searchBtn.setBorderPainted(false);
			searchBtn.setContentAreaFilled(true);
//			searchBtn.setForeground(Color.darkGray);
			searchBtn.setBackground(new Color(255,150,0));
			searchBtn.setFont(font);
			
		// 검색
		add("South",searchPane);
			searchPane.add(searchTf);
			searchPane.add(searchBtn);
		setSize(1100,600);
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		searchBtn.addActionListener(this);
		table.addMouseListener(new MouseAdapter() {
			public void mouseReleased(MouseEvent me) {
				if(me.getButton()==1) {
					int row = table.getSelectedRow();
					int col = table.getColumnCount();
					for(int c=0; c<col; c++) {
						if(c==0) { // 숫자일때
							tf[c].setText(String.valueOf(model.getValueAt(row, c)));
						} else { // 문자일때
							tf[c].setText((String)model.getValueAt(row, c));
						}
					}
				}
			}
		});
		/////test
		//초기화면에 회원전체 목록 보여야 함
		getMemberAll();
	}
	
	public void actionPerformed(ActionEvent ae) {
		String eventBtn = ae.getActionCommand();
		if(eventBtn.equals("Search")){
			memberSearch();
		} else if(eventBtn.equals("전체목록")) {
			getMemberAll();
		} else if(eventBtn.equals("추가")) {
			setMember();
		} else if(eventBtn.equals("지우기")) {
			setFormClear();
		} else if(eventBtn.equals("종료")) {
			System.exit(0);
			dispose();
		} else if(eventBtn.equals("수정")) {
			setMemberUpdate();
		} else if(eventBtn.equals("삭제")) {
			setMemberDelete();
		} else if(eventBtn.equals("엑셀로쓰기")) {
			setMemberExcelSave();
		} else if(eventBtn.equals("엑셀에서가져오기")) {
			getMemberExcelOpen();
		}
	}
	// 엑셀에서가져오기
	public void getMemberExcelOpen() {
		try {
//			JFileChooser fc = new JFileChooser();
//			FileFilter ff = new FileNameExtensionFilter("*.xls","xls","XLS");
//			fc.setFileFilter(ff);
//			
//			//0:열기 , 1:취소
//			int state = fc.showOpenDialog(this);
//			
//			if(state==0) {
//				//선택해 놓은 파일명
//				File selectFileName = fc.getSelectedFile();
//				
//				FileInputStream fis = new FileInputStream(selectFileName);
//				
//				//엑셀에서 파일 사용할 수 있는 객체를 생성한다
//				POIFSFileSystem poi = new POIFSFileSystem(fis);
//				//워크북
//				HSSFWorkbook workbook = new HSSFWorkbook(poi);
//				//시트
//				HSSFSheet sheet = workbook.getSheet("회원정보");
//				//행
//				int rowCount = sheet.getPhysicalNumberOfRows();
//
//				List<MemberVO> lst = new ArrayList<MemberVO>();
//				for(int row=1; row<rowCount; row++) {//1,2,3,4
//					//셀
//					MemberVO vo = new MemberVO();
//					HSSFRow rowData = sheet.getRow(row);
//					
//					//번호
//					vo.setNum((int)rowData.getCell(0).getNumericCellValue());
//					vo.setUsername(rowData.getCell(1).getStringCellValue());
//					vo.setTel(rowData.getCell(2).getStringCellValue());
//					vo.setEmail(rowData.getCell(3).getStringCellValue());
//					vo.setAddr(rowData.getCell(4).getStringCellValue());
//					vo.setWritedate(rowData.getCell(5).getStringCellValue());
//					lst.add(vo);
//				}
//				///////////
//				setNewTableList(lst);
//			}
			
			
			//불러오기
		JFileChooser fc = new JFileChooser();
		// 불러오기에서 선택
		fc.setMultiSelectionEnabled(true);
		// 다이어로그에서 확인을 누르면 int 0이 넘어온다
		int state = fc.showOpenDialog(this);
		// 만약 state가 0이면~
		if(state==0) {
			// 불러오기에서 선택된 파일을 객체에 넣어둔다
			File selfile = fc.getSelectedFile();
			// 인풋스트림에 넣고
			FileInputStream fis = new FileInputStream(selfile);
			// POIFS파일시스템에 넣고
			POIFSFileSystem pfs = new POIFSFileSystem(fis);
			// 워크북 객체생성
			HSSFWorkbook workbook = new HSSFWorkbook(pfs);
			// 워크북의 시트번호를 구하고
//			int sheetCount = workbook.getNumberOfSheets();
			// 워크북의 시트 회원정보를 시트 객체생성하고
			HSSFSheet sheet = workbook.getSheet("회원정보");
			
			// 시트에서 행의 수를 구한다
			int rowCount = sheet.getPhysicalNumberOfRows();
			
			model.setNumRows(0); // model 화면 초기화
			
			for(int row=1; row<rowCount; row++) {
				HSSFRow memRow = sheet.getRow(row);
				Object[] test = new Object[lbl.length];
				int colCount = memRow.getPhysicalNumberOfCells();
				for(int col = 0; col < colCount; col++) {
					HSSFCell cell = memRow.getCell(col);
					if(row>0 && col==0){//숫자로 읽기
						int data = (int)cell.getNumericCellValue();
						test[col] = data;
					} else {
						String data = cell.getStringCellValue();
						test[col] = data;
					}
				}
				model.addRow(test); // model에 불러온 col1, col2, col3 값을 행으로 넣는다
			}
			fis.close();
			pfs.close();
		}
		
		
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		
	}
	
	// 엑셀 파일로 쓰기
	public void setMemberExcelSave() {
		// 파일 탐색기
		JFileChooser fc = new JFileChooser();
		FileFilter ff = new FileNameExtensionFilter("*.xls","XLS");
		fc.setFileFilter(ff);
		
		int state = fc.showSaveDialog(this);
		
		if(state==0) {// 파일 탐색기에서 저장버튼을 선택시
			//선택한 위치와 파일명을 얻어오기
			File selFile = fc.getSelectedFile();
			
			//엑셀 객체만들기
			HSSFWorkbook workbook = new HSSFWorkbook();
			HSSFSheet sheet = workbook.createSheet("회원정보");
			
			//제목
			HSSFRow row = sheet.createRow(0);
//			row.createCell(0).setCellValue("번호");
//			row.createCell(1).setCellValue("이름");
//			row.createCell(2).setCellValue("연락처");
			for(int i=0; i<lbl.length; i++) {
				row.createCell(i).setCellValue(lbl[i]);
			}
			//JTable의 행의 수
			int rowCount = table.getRowCount();
			for(int i=0;i<rowCount;i++) {
				HSSFRow r = sheet.createRow(i+1);
				//칸수
				int c =table.getColumnCount();
				for(int j = 0; j < c; j++) {
					if(j==0) {//번호일때
						r.createCell(j).setCellValue((int)model.getValueAt(i, j));
					}else {//번호 아닐때
						r.createCell(j).setCellValue((String)table.getValueAt(i, j));
					}
				}
			}
			//////파일로 쓰기/////////////////////////////////////////
			try {
				FileOutputStream fos = new FileOutputStream(selFile);
				workbook.write(fos);
				if(fos!=null) fos.close();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	}
	
	//  회원정보 삭제
	public void setMemberDelete() {
		int num = Integer.parseInt(tf[0].getText());
		MemberDAO dao = new MemberDAO();
		int result = dao.memberDelete(num);
		String msg = "회원정보가 삭제되었습니다.";
		if(result>0) {
			getMemberAll();
		} else {
			msg = "회원정보가 삭제 실패하였습니다."; 
			System.out.println(msg);
		}
		setFormClear();	
		JOptionPane.showMessageDialog(this, msg);
		
	}
	
	// 회원 정보 수정
	public void setMemberUpdate() {
		MemberVO vo = new MemberVO();
		vo.setNum(Integer.parseInt(tf[0].getText()));
		vo.setTel(tf[2].getText());
		vo.setEmail(tf[3].getText());
		vo.setAddr(tf[4].getText());
		
		MemberDAO dao = new MemberDAO();
		int result = dao.memberUpdate(vo);
		if(result>0) { // 수정
			JOptionPane.showMessageDialog(this, "회원정보 수정하였습니다");
			getMemberAll();
			setFormClear();
		}else { //수정안됨
			JOptionPane.showMessageDialog(this,"회원정보 수정실패하였습니다");
		}
		
	}
	
	// 폼의 값 초기화
	public void setFormClear() {
		for(int i=0; i<tf.length; i++) {
			tf[i].setText("");
		}
	}
	//회원등록
	public void setMember() {
		//폼의 데이터를 VO에 셋팅
		MemberVO vo = new MemberVO(tf[1].getText(),tf[2].getText(),tf[3].getText(),tf[4].getText());

		//이름과 연락처가 있을때만 데이터베이스에 추가한다.
		if(vo.getUsername().equals("")||vo.getTel().equals("")) {
			JOptionPane.showMessageDialog(this, "이름과 연락처는 반드시 입력하여야 합니다");
		} else if(vo.getUsername().length()>4){
			JOptionPane.showMessageDialog(this, "이름은 4글자 이하로 등록이 가능합니다");
		} else { 
			MemberDAO dao = new MemberDAO();
			int result = dao.memberInsert(vo);
			if(result>0) {// 회원등록됨
				JOptionPane.showMessageDialog(this, "회원이 등록되었습니다");
				getMemberAll(); // 테이블에 다시 써준다
				setFormClear(); // 폼 초기화
			} else { //회원등록 실패함
				JOptionPane.showMessageDialog(this, "회원등록이 실패하였습니다");
			}
		}
		
	}
	
	//회원 검색
	public void memberSearch() {
		// 검색어에 입력된 데이터
		String searchWord = searchTf.getText();
		if(searchWord.equals("")) { // 검색어가 없을때
			JOptionPane.showMessageDialog(this, "검색어를 입력후 검색하세요");
		} else {// 검색어가 있을때
			MemberDAO dao = new MemberDAO();
			List<MemberVO> searchList = dao.getSearchRecord(searchWord);
			
			if(searchList.size()==0) {// 검색 조건의 회원이 없을 경우
				JOptionPane.showMessageDialog(this, searchWord+"의 검색 결과가 존재하지 않습니다");
			}else {// 있을경우
				setNewTableList(searchList);
			}
			searchTf.setText("");
		}
	}
	
	//회원 전체 선택
	public void getMemberAll() {
		//데이터 베이스의 모든 회원을 선택해서 JTable에 표시한다
		MemberDAO dao = new MemberDAO();
		List<MemberVO> lst = dao.memberAllSelect();
		
		setNewTableList(lst);
	}
	public void setNewTableList(List<MemberVO> lst) {
		model.setRowCount(0);
		for(int i = 0; i<lst.size();i++) {
			MemberVO vo = lst.get(i);
			Object[] data = {vo.getNum(),vo.getUsername(),vo.getTel(),vo.getEmail(),vo.getAddr(),vo.getWritedate()};
			model.addRow(data);
		}
	}
	public static void main(String[] args) {
		new MemberMain();

	}

}

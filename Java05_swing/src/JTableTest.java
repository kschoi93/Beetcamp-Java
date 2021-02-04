import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class JTableTest extends JFrame{
	JTable table;
		//제목
		String title[] = {"번호","이름","연락처","이메일"};
		Object data[][] = {
				{1,"홍길동","010-2525-9999","abcde@nate.com"},
				{2,"이순신","010-1111-9999","zyz@nate.com"},
				{3,"세종대왕","010-6666-1111","ccccc@nate.com"},
				{4,"장영실","010-3232-8888","ggggg@nate.com"},
				{5,"유승룡","010-5656-3333","kkkkk@nate.com"}
				
		};
		DefaultTableModel model;
		JScrollPane sp;
	JLabel lbl = new JLabel("선택한 정보가 표시되는 곳");
	
	public JTableTest() {
		model = new DefaultTableModel(data,title);
		table = new JTable(model);
		sp = new JScrollPane(table);
		
		add(sp);
		add("South", lbl);
		
		setSize(600,500);
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		//익명의 내부 클래스
		table.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent me) {
				//마우스의 버튼 종류 알아내기
				int clickBtn = me.getButton(); // 1:왼쪽버튼 2:휠, 3: 오른쪽 버튼
				if(clickBtn==1) {
					//선택한 행의 데이터 가져오기
					int row = table.getSelectedRow();
					String txt = "";
					for(int c=0; c<table.getColumnCount();c++) {
						Object obj = table.getValueAt(row, c);
						txt += obj+", ";
					}
					lbl.setText(txt);
				}
				
			}
		});
		
		tableSet();
	}
	public void tableSet() {
		try {Thread.sleep(2000);}catch(Exception e) {}
		//행추가 - 마지막행
		Object[] d = {6,"강감찬","010-8888-1111","kkkkk@naver.com"};
		model.addRow(d);
		
		try {Thread.sleep(2000);}catch(Exception e) {}
		//행삽입 - 원하는 index 위치에 목록 추가
		Object[] d2 = {7,"광개토대왕","010-2222-1111","zzzzzzz@naver.com"};
		model.insertRow(2, d2);
		
		try {Thread.sleep(2000);}catch(Exception e) {}
		//행이동 - 원하는 위치 여러행 이동
		model.moveRow(3, 5, 1);
		
		try {Thread.sleep(2000);}catch(Exception e) {}
		//컬럼추가
		model.addColumn("비고");
		
		try {Thread.sleep(2000);}catch(Exception e) {}
		//행삭제
		model.removeRow(2);
		
		try {Thread.sleep(2000);}catch(Exception e) {}
		//컬럼삭제
		table.removeColumn(table.getColumn("비고"));
	}

	public static void main(String[] args) {
		new JTableTest();

	}

}

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class JTableTest extends JFrame{
	JTable table;
		//����
		String title[] = {"��ȣ","�̸�","����ó","�̸���"};
		Object data[][] = {
				{1,"ȫ�浿","010-2525-9999","abcde@nate.com"},
				{2,"�̼���","010-1111-9999","zyz@nate.com"},
				{3,"�������","010-6666-1111","ccccc@nate.com"},
				{4,"�念��","010-3232-8888","ggggg@nate.com"},
				{5,"���·�","010-5656-3333","kkkkk@nate.com"}
				
		};
		DefaultTableModel model;
		JScrollPane sp;
	JLabel lbl = new JLabel("������ ������ ǥ�õǴ� ��");
	
	public JTableTest() {
		model = new DefaultTableModel(data,title);
		table = new JTable(model);
		sp = new JScrollPane(table);
		
		add(sp);
		add("South", lbl);
		
		setSize(600,500);
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		//�͸��� ���� Ŭ����
		table.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent me) {
				//���콺�� ��ư ���� �˾Ƴ���
				int clickBtn = me.getButton(); // 1:���ʹ�ư 2:��, 3: ������ ��ư
				if(clickBtn==1) {
					//������ ���� ������ ��������
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
		//���߰� - ��������
		Object[] d = {6,"������","010-8888-1111","kkkkk@naver.com"};
		model.addRow(d);
		
		try {Thread.sleep(2000);}catch(Exception e) {}
		//����� - ���ϴ� index ��ġ�� ��� �߰�
		Object[] d2 = {7,"��������","010-2222-1111","zzzzzzz@naver.com"};
		model.insertRow(2, d2);
		
		try {Thread.sleep(2000);}catch(Exception e) {}
		//���̵� - ���ϴ� ��ġ ������ �̵�
		model.moveRow(3, 5, 1);
		
		try {Thread.sleep(2000);}catch(Exception e) {}
		//�÷��߰�
		model.addColumn("���");
		
		try {Thread.sleep(2000);}catch(Exception e) {}
		//�����
		model.removeRow(2);
		
		try {Thread.sleep(2000);}catch(Exception e) {}
		//�÷�����
		table.removeColumn(table.getColumn("���"));
	}

	public static void main(String[] args) {
		new JTableTest();

	}

}

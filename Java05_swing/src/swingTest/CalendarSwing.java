package swingTest;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Calendar;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
								// ������ ���			//������ ������, �׼� ������ �������̽�
public class CalendarSwing extends JPanel implements ItemListener, ActionListener{
	// ��Ʈ����
	Font fnt = new Font("����ü",Font.BOLD,20);
	
	// ��� ������
	JPanel selectPane = new JPanel();
		JButton prevBtn = new JButton("��");
		JButton nextBtn = new JButton("��");
		JComboBox<Integer> yearCombo = new JComboBox<Integer>();
		JComboBox<Integer> monthCombo = new JComboBox<Integer>();
		JLabel yearLbl = new JLabel("��");
		JLabel monthLbl = new JLabel("��");
	
	// ��� ������
	JPanel centerPane = new JPanel(new BorderLayout());
									// �޷��� Ÿ��Ʋ 1�� 7��
		JPanel titlePane = new JPanel(new GridLayout(1,7));		
			String[] title = {"��","��","ȭ","��","��","��","��"};
									// �޷��� ������ 4��,5��,6�� �޿����� �޶����� ������ 0���� ����
		JPanel dayPane = new JPanel(new GridLayout(0,7));
		
	//�޷� ���� ������
	Calendar date;
	int year;
	int month;
	
	public CalendarSwing(){
		setLayout(new BorderLayout());
		// ������ Ÿ��Ʋ ����
//		super("�޷�");
		date = Calendar.getInstance(); // ������ ��¥ �ð� ��ü ����
		year = date.get(Calendar.YEAR); // ������ ��¥ �⵵
		month = date.get(Calendar.MONTH)+1; // ������ ��¥ ��
		
		//��� ������
		// ��׶��� ���� ����
		selectPane.setBackground(new Color(150,200,200));
		// ��Ʈ ����
		selectPane.add(prevBtn);	prevBtn.setFont(fnt);
		selectPane.add(yearCombo);	yearCombo.setFont(fnt);
		selectPane.add(yearLbl);	yearLbl.setFont(fnt);
		selectPane.add(monthCombo);	monthCombo.setFont(fnt);
		selectPane.add(monthLbl);	monthLbl.setFont(fnt);
		selectPane.add(nextBtn);	nextBtn.setFont(fnt);
		
		// �����ӿ� �г� ����
		add(BorderLayout.NORTH,selectPane);
		// JComboBox�� ��, �� ǥ�� �޼ҵ�
		setMonth();
		setYear();
	
		// ��� ������ ��� Ÿ��Ʋ ���� ǥ�� �޼ҵ�
		setCalendarTitle();
		// ���� �гο� Ÿ��Ʋ �г� ����
		centerPane.add(BorderLayout.NORTH,titlePane);
		add(centerPane);
		
		// ��¥ �����
		centerPane.add(dayPane);
		//��¥ �����Ͽ� ȭ�鿡 ǥ�����ش�.
		setDay();
		
//		//������ ������
//		setSize(400,300);
//		//������ ������ ����
//		setVisible(true);
//		//����
//		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		// �����϶�. ������ �����ʴ� ������ ������Ʈ�� �����ٰ� ����ؼ� �̺�Ʈ�� ó������ �ʴ´�.
		yearCombo.addItemListener(this);
		monthCombo.addItemListener(this);
		prevBtn.addActionListener(this);
		nextBtn.addActionListener(this);
	}
	
	// �׼� �̺�Ʈ 
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object obj = e.getSource();
		if(obj == prevBtn) { // ������ �޼ҵ�
			prevMonth();
		} else if(obj == nextBtn) {// ������ �޼ҵ�
			nextMonth();
		}
	}
	
	public void setDayReset(){
		//��� �̺�Ʈ��� ����
		// ������ ����
		yearCombo.removeItemListener(this);
		monthCombo.removeItemListener(this);
		// �����ۿ� ��� ���� �ִ´�
		yearCombo.setSelectedItem(year);
		monthCombo.setSelectedItem(month);
		// ȭ���� �����
		dayPane.setVisible(false);
		// ������ �����Ѵ�
		dayPane.removeAll();
		//��¥ ����
		setDay();
		// ��¥ ���� �� ȭ���� �ٽ� ���̰� �Ѵ�
		dayPane.setVisible(true);
		
		//��� �̺�Ʈ ��� �ٽõ��
		yearCombo.addItemListener(this);
		monthCombo.addItemListener(this);
	}
	// ���� �̵� ��ư
	public void prevMonth() {
		// ���� 1�� ��� �� -- �� 12�� ����
		if(month==1) {
			year--;
			month=12;
		} else { // �� �ܴ� ���� --
			month--;
		}
		// �޷³�¥ �缼��
		setDayReset();
	}
	// ������ �̵� ��ư
	public void nextMonth() {
		// ���� 12�� ��� ���� ++ �� 1�� ����
		if(month==12) {
			year++;
			month=1;
		} else { // �׿ܴ� ���� ++
			month++;
		}
		// �޷³�¥ �缼��
		setDayReset();
	}
	
	// �޺��ڽ��� �������� ����ɰ��....
	public void itemStateChanged(ItemEvent ie) {
		year = (int)yearCombo.getSelectedItem();
		month = (int)monthCombo.getSelectedItem();
		
		// �г��� ������ ��� ������� �ٽ� ������ �� �г��������ش�
		dayPane.setVisible(false);
		dayPane.removeAll();
		setDay();//��¥ ó�� �Լ� ȣ��
		dayPane.setVisible(true);
	}
	
	//��¥ ����
	public void setDay() {
		//����
		date.set(year, month-1,1);
		int week = date.get(Calendar.DAY_OF_WEEK);
		//��������
		int lastDay = date.getActualMaximum(Calendar.DATE);
		
		// ����
		for(int s = 1; s<week; s+=1) {
			JLabel lbl = new JLabel(" ");
			dayPane.add(lbl);
		}
		// ��¥���
		for(int day=1; day<=lastDay; day++) {
			JLabel lbl = new JLabel(String.valueOf(day),JLabel.CENTER);
			lbl.setFont(fnt);
			//����ϴ� ��¥�� ���� ����
			date.set(Calendar.DATE, day);
			int w = date.get(Calendar.DAY_OF_WEEK);
			if(w==1) lbl.setForeground(Color.red);
			if(w==7) lbl.setForeground(Color.blue);
			dayPane.add(lbl);
		}
	}
	
	//�⵵ ����
	public void setYear() {
		// -50�����~ +20����� �����Ͽ� �����ۿ� �ִ´�.
		for(int i=year-50; i<year+20; i++) {
			yearCombo.addItem(i);
		}
		// �⵵�� ���� ��¥�� �����Ѵ�
		yearCombo.setSelectedItem(year);
	}
	//�� ����
	public void setMonth() {
		// 1�� ���� ~ 12������ �����Ͽ� �����ۿ� �ִ´�.
		for(int i=1; i<=12; i++) {
			monthCombo.addItem(i);
		}
		// ���� ���� ���� �����Ѵ�.
		monthCombo.setSelectedItem(month);
	}
	
	//��ȭ���� Ÿ��Ʋ ����
	public void setCalendarTitle() {
		for(int i=0; i<title.length; i++) {
			JLabel lbl = new JLabel(title[i],JLabel.CENTER);
			lbl.setFont(fnt);
			// 0��° �� ��� ���������� 6��° �� ��� �Ķ������� ǥ���Ѵ�
			if(i==0) lbl.setForeground(Color.red);
			if(i==6) lbl.setForeground(Color.blue);
			titlePane.add(lbl);
		}
	}
	
//	public static void main(String[] args) {
//		new CalendarSwing();
//	}

		
}

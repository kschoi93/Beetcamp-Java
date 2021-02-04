import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class FrameLayoutMain extends JFrame implements ActionListener {
	// ��� ����
	JPanel bar = new JPanel();
		JButton lastMonth = new JButton("��");
	
		JComboBox<Integer> yearCombo = new JComboBox<Integer>(); 
			DefaultComboBoxModel<Integer> yearModel = new DefaultComboBoxModel<Integer>();
		
		JLabel yLbl = new JLabel("�� ");
		
		JComboBox<Integer> monthCombo = new JComboBox<Integer>(); 
			DefaultComboBoxModel<Integer> monthModel = new DefaultComboBoxModel<Integer>();
		JLabel mLbl = new JLabel("��");
		JButton nextMonth = new JButton("��");
	// �߾� ����
	JPanel center = new JPanel(new BorderLayout());
		// �߾� ��� ����
		JPanel cntNorth = new JPanel(new GridLayout(0,7));
		// �߾� �߾� ����
		JPanel cntCenter = new JPanel(new GridLayout(0,7));
		
	// ���� �Է�
	String dw[] = {"��","��","ȭ","��","��","��","��"};
	
	
	Calendar now = Calendar.getInstance();
	int year, month, date;
	
	public FrameLayoutMain() {
		year = now.get(Calendar.YEAR);// 2021��
		month = now.get(Calendar.MONTH); // 0�� == 1��
		date = now.get(Calendar.DATE);
		for(int i=year-50; i<=year+50; i++){yearModel.addElement(i);}
		for(int i=1; i<=12; i++) { monthModel.addElement(i); }
		Random ran = new Random();
		//////////////////////////������///////////////////////////////////////////
		// ��� ����
		add("North", bar);
			bar.setLayout(new FlowLayout());
			bar.setSize(300,400);
			bar.add(lastMonth);
			//////////////////////////�޷�/////////////////////////////////////////////
			bar.add(yearCombo);
				yearCombo.setModel(yearModel);
				yearCombo.setSelectedItem(year);

			bar.add(yLbl);
			bar.add(monthCombo);
				monthCombo.setModel(monthModel);
				monthCombo.setSelectedItem(month);

			bar.add(mLbl);
			bar.add(nextMonth);
			bar.setBackground(new Color(0,210,180));

		// �߾� ����
		add("Center", center);
			// �߾� ��� ����
			center.add("North",cntNorth);
			for(int i=0; i<dw.length; i++) {
				JLabel dayOfWeek = new JLabel(dw[i],JLabel.CENTER);
				if(i==0) dayOfWeek.setForeground(Color.red);
				else if(i==6) dayOfWeek.setForeground(Color.blue);
				cntNorth.add(dayOfWeek);
			}

			// �߾� �߾� ����
			center.add("Center",cntCenter);
			dayPrint(year,month);
			
			
		// �̺�Ʈ
		yearCombo.addActionListener(this);
		monthCombo.addActionListener(this);
		lastMonth.addActionListener(this);
		nextMonth.addActionListener(this);
		
		// frame �⺻ ����
		setSize(400,300);
		setVisible(true);
		setResizable(false);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}	


	// �̺�Ʈ ó��
	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		System.out.println(obj);
		if(obj instanceof JButton){
			JButton eventBtn = (JButton)obj;
			int yy = (Integer)yearCombo.getSelectedItem();
			int mm = (Integer)monthCombo.getSelectedItem();
			if(eventBtn.equals(lastMonth)){	//����
				if(mm==1){
					yy--; mm=12;
				}else{
					mm--;
				}			
			}else if(eventBtn.equals(nextMonth)){	//������
				if(mm==12){
					yy++; mm=1;
				}else{
					mm++;
				}
			}
			yearCombo.setSelectedItem(yy);
			monthCombo.setSelectedItem(mm);
		}else if(obj instanceof JComboBox){	//�޺��ڽ� �̺�Ʈ �߻���
			createDayStart();
		}


	}

	private void createDayStart() {
		cntCenter.setVisible(false);	//�г� �����
		cntCenter.removeAll();	//��¥ ����� �� �����
		dayPrint((Integer)yearCombo.getSelectedItem(), (Integer)monthCombo.getSelectedItem());
		cntCenter.setVisible(true);	//�г� �����	

	}


	// ��¥ ���
	public void dayPrint(int y,int m) {
		Calendar cal = Calendar.getInstance();
		cal.set(y, m-1, 1);
		int week = cal.get(Calendar.DAY_OF_WEEK); // 1�Ͽ� ���� ����
		int lastDate = cal.getActualMaximum(Calendar.DAY_OF_MONTH); // 1���� ���� ������ ����
		for(int i =1; i<week; i++) { // 1�� 1�� ������ ������ ǥ���ض�
			cntCenter.add(new JLabel(""));
		}

		for(int i =0;i<=lastDate-1;i++) { // 1�� ������ ������ ���ڸ� �����, �׸��� ����� �Ͽ����� ������ ������
			if((week+i)%7==0) {
				cntCenter.add(new JLabel(1+i+"",JLabel.CENTER)).setForeground(Color.blue);
			} else if((week+i)%7==1) {
				cntCenter.add(new JLabel(1+i+"",JLabel.CENTER)).setForeground(Color.red);
			} else {
				cntCenter.add(new JLabel(1+i+"",JLabel.CENTER));
			}
		}
		

		
	}

	
	public static void main(String[] args) {
		new FrameLayoutMain();
	}

}

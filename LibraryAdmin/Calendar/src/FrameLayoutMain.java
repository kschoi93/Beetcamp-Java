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
	// 상단 지역
	JPanel bar = new JPanel();
		JButton lastMonth = new JButton("◀");
	
		JComboBox<Integer> yearCombo = new JComboBox<Integer>(); 
			DefaultComboBoxModel<Integer> yearModel = new DefaultComboBoxModel<Integer>();
		
		JLabel yLbl = new JLabel("년 ");
		
		JComboBox<Integer> monthCombo = new JComboBox<Integer>(); 
			DefaultComboBoxModel<Integer> monthModel = new DefaultComboBoxModel<Integer>();
		JLabel mLbl = new JLabel("월");
		JButton nextMonth = new JButton("▶");
	// 중앙 지역
	JPanel center = new JPanel(new BorderLayout());
		// 중앙 상단 지역
		JPanel cntNorth = new JPanel(new GridLayout(0,7));
		// 중앙 중앙 지역
		JPanel cntCenter = new JPanel(new GridLayout(0,7));
		
	// 요일 입력
	String dw[] = {"일","월","화","수","목","금","토"};
	
	
	Calendar now = Calendar.getInstance();
	int year, month, date;
	
	public FrameLayoutMain() {
		year = now.get(Calendar.YEAR);// 2021년
		month = now.get(Calendar.MONTH); // 0월 == 1월
		date = now.get(Calendar.DATE);
		for(int i=year-50; i<=year+50; i++){yearModel.addElement(i);}
		for(int i=1; i<=12; i++) { monthModel.addElement(i); }
		Random ran = new Random();
		//////////////////////////프레임///////////////////////////////////////////
		// 상단 지역
		add("North", bar);
			bar.setLayout(new FlowLayout());
			bar.setSize(300,400);
			bar.add(lastMonth);
			//////////////////////////달력/////////////////////////////////////////////
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

		// 중앙 지역
		add("Center", center);
			// 중앙 상단 지역
			center.add("North",cntNorth);
			for(int i=0; i<dw.length; i++) {
				JLabel dayOfWeek = new JLabel(dw[i],JLabel.CENTER);
				if(i==0) dayOfWeek.setForeground(Color.red);
				else if(i==6) dayOfWeek.setForeground(Color.blue);
				cntNorth.add(dayOfWeek);
			}

			// 중앙 중앙 지역
			center.add("Center",cntCenter);
			dayPrint(year,month);
			
			
		// 이벤트
		yearCombo.addActionListener(this);
		monthCombo.addActionListener(this);
		lastMonth.addActionListener(this);
		nextMonth.addActionListener(this);
		
		// frame 기본 셋팅
		setSize(400,300);
		setVisible(true);
		setResizable(false);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}	


	// 이벤트 처리
	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		System.out.println(obj);
		if(obj instanceof JButton){
			JButton eventBtn = (JButton)obj;
			int yy = (Integer)yearCombo.getSelectedItem();
			int mm = (Integer)monthCombo.getSelectedItem();
			if(eventBtn.equals(lastMonth)){	//전달
				if(mm==1){
					yy--; mm=12;
				}else{
					mm--;
				}			
			}else if(eventBtn.equals(nextMonth)){	//다음달
				if(mm==12){
					yy++; mm=1;
				}else{
					mm++;
				}
			}
			yearCombo.setSelectedItem(yy);
			monthCombo.setSelectedItem(mm);
		}else if(obj instanceof JComboBox){	//콤보박스 이벤트 발생시
			createDayStart();
		}


	}

	private void createDayStart() {
		cntCenter.setVisible(false);	//패널 숨기기
		cntCenter.removeAll();	//날짜 출력한 라벨 지우기
		dayPrint((Integer)yearCombo.getSelectedItem(), (Integer)monthCombo.getSelectedItem());
		cntCenter.setVisible(true);	//패널 재출력	

	}


	// 날짜 출력
	public void dayPrint(int y,int m) {
		Calendar cal = Calendar.getInstance();
		cal.set(y, m-1, 1);
		int week = cal.get(Calendar.DAY_OF_WEEK); // 1일에 대한 요일
		int lastDate = cal.getActualMaximum(Calendar.DAY_OF_MONTH); // 1월에 대한 마지막 요일
		for(int i =1; i<week; i++) { // 1월 1일 전까지 공백을 표시해라
			cntCenter.add(new JLabel(""));
		}

		for(int i =0;i<=lastDate-1;i++) { // 1월 마지막 날까지 숫자를 적어라, 그리고 토요일 일요일은 색깔을 입혀라
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

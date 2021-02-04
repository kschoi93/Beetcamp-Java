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
								// 프레임 상속			//아이템 리스너, 액션 리스너 인터페이스
public class CalendarSwing extends JPanel implements ItemListener, ActionListener{
	// 폰트설정
	Font fnt = new Font("굴림체",Font.BOLD,20);
	
	// 상단 프레임
	JPanel selectPane = new JPanel();
		JButton prevBtn = new JButton("◀");
		JButton nextBtn = new JButton("▶");
		JComboBox<Integer> yearCombo = new JComboBox<Integer>();
		JComboBox<Integer> monthCombo = new JComboBox<Integer>();
		JLabel yearLbl = new JLabel("년");
		JLabel monthLbl = new JLabel("월");
	
	// 가운데 프레임
	JPanel centerPane = new JPanel(new BorderLayout());
									// 달력의 타이틀 1행 7열
		JPanel titlePane = new JPanel(new GridLayout(1,7));		
			String[] title = {"일","월","화","수","목","금","토"};
									// 달력의 본문은 4행,5행,6행 달에따라 달라지기 때문에 0으로 지정
		JPanel dayPane = new JPanel(new GridLayout(0,7));
		
	//달력 관련 데이터
	Calendar date;
	int year;
	int month;
	
	public CalendarSwing(){
		setLayout(new BorderLayout());
		// 프레임 타이틀 설정
//		super("달력");
		date = Calendar.getInstance(); // 현재의 날짜 시간 객체 생성
		year = date.get(Calendar.YEAR); // 현재의 날짜 년도
		month = date.get(Calendar.MONTH)+1; // 현재의 날짜 월
		
		//상단 프레임
		// 백그라운드 배경색 설정
		selectPane.setBackground(new Color(150,200,200));
		// 폰트 적용
		selectPane.add(prevBtn);	prevBtn.setFont(fnt);
		selectPane.add(yearCombo);	yearCombo.setFont(fnt);
		selectPane.add(yearLbl);	yearLbl.setFont(fnt);
		selectPane.add(monthCombo);	monthCombo.setFont(fnt);
		selectPane.add(monthLbl);	monthLbl.setFont(fnt);
		selectPane.add(nextBtn);	nextBtn.setFont(fnt);
		
		// 프레임에 패널 삽입
		add(BorderLayout.NORTH,selectPane);
		// JComboBox에 년, 월 표시 메소드
		setMonth();
		setYear();
	
		// 가운데 프레임 상단 타이틀 요일 표시 메소드
		setCalendarTitle();
		// 센터 패널에 타이틀 패널 삽입
		centerPane.add(BorderLayout.NORTH,titlePane);
		add(centerPane);
		
		// 날짜 만들기
		centerPane.add(dayPane);
		//날짜 셋팅하여 화면에 표시해준다.
		setDay();
		
//		//프레임 사이즈
//		setSize(400,300);
//		//프레임 보일지 여부
//		setVisible(true);
//		//종료
//		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		// 유의하라. 아이템 리스너는 동일한 컴포넌트를 누른다고 계속해서 이벤트가 처리되지 않는다.
		yearCombo.addItemListener(this);
		monthCombo.addItemListener(this);
		prevBtn.addActionListener(this);
		nextBtn.addActionListener(this);
	}
	
	// 액션 이벤트 
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object obj = e.getSource();
		if(obj == prevBtn) { // 이전월 메소드
			prevMonth();
		} else if(obj == nextBtn) {// 다음월 메소드
			nextMonth();
		}
	}
	
	public void setDayReset(){
		//년월 이벤트등록 해제
		// 아이템 삭제
		yearCombo.removeItemListener(this);
		monthCombo.removeItemListener(this);
		// 아이템에 년과 월을 넣는다
		yearCombo.setSelectedItem(year);
		monthCombo.setSelectedItem(month);
		// 화면을 숨긴다
		dayPane.setVisible(false);
		// 모든것을 삭제한다
		dayPane.removeAll();
		//날짜 셋팅
		setDay();
		// 날짜 셋팅 후 화면을 다시 보이게 한다
		dayPane.setVisible(true);
		
		//년월 이벤트 등록 다시등록
		yearCombo.addItemListener(this);
		monthCombo.addItemListener(this);
	}
	// 전월 이동 버튼
	public void prevMonth() {
		// 월이 1일 경우 년 -- 월 12일 셋팅
		if(month==1) {
			year--;
			month=12;
		} else { // 그 외는 월만 --
			month--;
		}
		// 달력날짜 재세팅
		setDayReset();
	}
	// 다음달 이동 버튼
	public void nextMonth() {
		// 월이 12일 경우 년은 ++ 월 1일 셋팅
		if(month==12) {
			year++;
			month=1;
		} else { // 그외는 월만 ++
			month++;
		}
		// 달력날짜 재세팅
		setDayReset();
	}
	
	// 콤보박스의 아이템이 변경될경우....
	public void itemStateChanged(ItemEvent ie) {
		year = (int)yearCombo.getSelectedItem();
		month = (int)monthCombo.getSelectedItem();
		
		// 패널을 가리고 모두 지운다음 다시 셋팅한 후 패널을보여준다
		dayPane.setVisible(false);
		dayPane.removeAll();
		setDay();//날짜 처리 함수 호출
		dayPane.setVisible(true);
	}
	
	//날짜 셋팅
	public void setDay() {
		//요일
		date.set(year, month-1,1);
		int week = date.get(Calendar.DAY_OF_WEEK);
		//마지막날
		int lastDay = date.getActualMaximum(Calendar.DATE);
		
		// 공백
		for(int s = 1; s<week; s+=1) {
			JLabel lbl = new JLabel(" ");
			dayPane.add(lbl);
		}
		// 날짜출력
		for(int day=1; day<=lastDay; day++) {
			JLabel lbl = new JLabel(String.valueOf(day),JLabel.CENTER);
			lbl.setFont(fnt);
			//출력하는 날짜에 대한 요일
			date.set(Calendar.DATE, day);
			int w = date.get(Calendar.DAY_OF_WEEK);
			if(w==1) lbl.setForeground(Color.red);
			if(w==7) lbl.setForeground(Color.blue);
			dayPane.add(lbl);
		}
	}
	
	//년도 셋팅
	public void setYear() {
		// -50년부터~ +20년까지 세팅하여 아이템에 넣는다.
		for(int i=year-50; i<year+20; i++) {
			yearCombo.addItem(i);
		}
		// 년도를 현재 날짜로 세팅한다
		yearCombo.setSelectedItem(year);
	}
	//월 셋팅
	public void setMonth() {
		// 1월 부터 ~ 12월까지 세팅하여 아이템에 넣는다.
		for(int i=1; i<=12; i++) {
			monthCombo.addItem(i);
		}
		// 월을 현재 월로 세팅한다.
		monthCombo.setSelectedItem(month);
	}
	
	//월화수목 타이틀 설정
	public void setCalendarTitle() {
		for(int i=0; i<title.length; i++) {
			JLabel lbl = new JLabel(title[i],JLabel.CENTER);
			lbl.setFont(fnt);
			// 0번째 일 경우 빨간색으로 6번째 일 경우 파란색으로 표시한다
			if(i==0) lbl.setForeground(Color.red);
			if(i==6) lbl.setForeground(Color.blue);
			titlePane.add(lbl);
		}
	}
	
//	public static void main(String[] args) {
//		new CalendarSwing();
//	}

		
}

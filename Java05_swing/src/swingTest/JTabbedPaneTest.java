package swingTest;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTabbedPane;

public class JTabbedPaneTest extends JFrame {
	JTabbedPane tp = new JTabbedPane();
	Calculator cal = new Calculator();
	CalendarSwing dar = new CalendarSwing();
	DigitalClock clock = new DigitalClock();
	PackMan pack = new PackMan();
	
	ImageIcon ii1 = new ImageIcon("img/Lighthouse.jpg");
	ImageIcon ii2 = new ImageIcon("icon/save01.gif");
	ImageIcon ii3 = new ImageIcon("icon/new01.gif");
	ImageIcon ii4 = new ImageIcon("icon/cut01.gif");
	ImageIcon ii5 = new ImageIcon("icon/copy01.gif");
	
	JLabel lbl = new JLabel(ii1);
	public JTabbedPaneTest() {
		add(tp);
		
		// 탭패널에 컴퍼넌트 추가
		tp.addTab("하우스", lbl);
		tp.addTab("계산기", ii2,cal,"Calculator");
		tp.addTab("달력", ii3,dar);
		tp.addTab("시계", ii4,clock);
		tp.addTab("팩맨", ii5,pack);
		
		pack();
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		System.out.println("처음");
		
		
		
		
		try{Thread.sleep(3000);}catch(Exception e) {}
		//시계 스레드 시작
		Thread clockThread = new Thread(clock);
		clockThread.start();
		System.out.println("시작");
		try{Thread.sleep(3000);}catch(Exception e) {}
		//캔버스 크기 다시 셋팅
		pack.getPackManSize();
		Thread packThread = new Thread(pack);
		packThread.start();
		System.out.println("두번째");
		try{Thread.sleep(3000);}catch(Exception e) {}
		//중간에 탭메뉴 추가하기///////////////////////////////////////////
		tp.insertTab("버튼", ii2, new JButton("버튼"), "Tabbed테스트중", 2);
		//활성화 비활성화 하기
		// true : 활성화, false : 비활성화
//		tp.setEnabled(false);
		//비활성화 하고 싶은 인덱스 선정
//		tp.setEnabledAt(2, false);
		//탭메뉴 삭제
//		tp.removeTabAt(3);
		// 탭메뉴 위치 이동
		tp.setTabPlacement(JTabbedPane.LEFT);
	}
	
	public static void main(String[] args) {
		new JTabbedPaneTest();

	}

}

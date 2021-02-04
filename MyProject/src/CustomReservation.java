import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class CustomReservation extends JPanel implements ActionListener{
	Font fnt = new Font("굴림체",Font.BOLD,14);
	
	JPanel changePane = new JPanel();
	JLabel startLbl = new JLabel("출발지");
		JTextField startField = new JTextField(10);
		JButton startBtn = new JButton("검색");
	
	JLabel arriveLbl = new JLabel("도착지");
		JTextField arriveField = new JTextField(10);
		JButton arriveBtn = new JButton("검색");
	
	JLabel startDateLbl = new JLabel("출발 날짜");
		JTextField startDateField = new JTextField(10);
		ImageIcon icon = new ImageIcon("img/calendar.png");
		Image im = icon.getImage();
		Image im2 = im.getScaledInstance(30, 30, Image.SCALE_DEFAULT);
		ImageIcon icon2 = new ImageIcon(im2);
		JLabel startCalendar = new JLabel(icon2);
	JLabel arriveDateLbl = new JLabel("도착 날짜");
		JTextField arriveDateField = new JTextField(10);
		JLabel arriveCalendar = new JLabel(icon2);
	JLabel roundDateLbl = new JLabel("왕복");
		JRadioButton roundBtn = new JRadioButton();
		JLabel oneway = new JLabel("편도");
		JRadioButton onewayBtn = new JRadioButton();	
		
	JLabel humanLbl = new JLabel("인원수");
		JLabel audultLbl = new JLabel("어른");
		JComboBox<Integer> audultAge = new JComboBox<Integer>();
		JLabel babyLbl = new JLabel("소아");
		JComboBox<Integer> babyAge = new JComboBox<Integer>();
	
	JPanel btnMainPane = new JPanel();
		JPanel btnPane = new JPanel();
		JButton nextBtn = new JButton("다음");
		JButton cancelBtn = new JButton("예약취소");

	
	JPanel main = new JPanel();
	CustomReservation2 reservation2 = new CustomReservation2();
	int x, x1;
	public CustomReservation() {
		setLayout(new BorderLayout());
		
		// 전환 페이지
		add("Center",changePane);
		changePane.setLayout(null);
		changePane.setBackground(Color.white);
		int x=300;
		int x1=380;
		changePane.add(startLbl).setBounds(x,150,70,30); 
		changePane.add(startField).setBounds(x1,150,150,30); 
		changePane.add(startBtn).setBounds(550,150,70,30);
		startLbl.setFont(fnt);
		startField.setFont(fnt);
		startBtn.setFont(fnt);
		startBtn.setBackground(new Color(0,130,255));
		startBtn.setForeground(Color.white);
		
		changePane.add(arriveLbl).setBounds(x,200,70,30); 
		changePane.add(arriveField).setBounds(x1,200,150,30); 
		changePane.add(arriveBtn).setBounds(550,200,70,30);
		arriveLbl.setFont(fnt);
		arriveField.setFont(fnt);
		arriveBtn.setFont(fnt);
		arriveBtn.setBackground(new Color(0,130,255));
		arriveBtn.setForeground(Color.white);
		
		changePane.add(startDateLbl).setBounds(x,250,70,30); 
		changePane.add(startDateField).setBounds(x1, 250, 150, 30); 
		changePane.add(startCalendar).setBounds(550,250,30,30);
		startDateLbl.setFont(fnt);
		startDateField.setFont(fnt);
		
		changePane.add(arriveDateLbl).setBounds(x,300,70,30); 
		changePane.add(arriveDateField).setBounds(x1,300,150,30); 
		changePane.add(arriveCalendar).setBounds(550,300,30,30);
		arriveDateLbl.setFont(fnt);
		arriveDateField.setFont(fnt);
		
		changePane.add(roundDateLbl).setBounds(x,350,70,30); 
		changePane.add(roundBtn).setBounds(x1,350,70,30); 
		changePane.add(oneway).setBounds(450,350,70,30); 
		changePane.add(onewayBtn).setBounds(520,350,70,30);
		roundDateLbl.setFont(fnt);
		oneway.setFont(fnt);
		roundBtn.setBackground(Color.white);
		onewayBtn.setBackground(Color.white);
		
		changePane.add(humanLbl).setBounds(x,400,70,30); 
		changePane.add(audultLbl).setBounds(x1,400,50,30); 
		changePane.add(audultAge).setBounds(450,400,70,30); 
		changePane.add(babyLbl).setBounds(550,400,50,30);
		changePane.add(babyAge).setBounds(610,400,70,30);
		humanLbl.setFont(fnt);
		audultLbl.setFont(fnt);
		audultAge.setFont(fnt);
		babyLbl.setFont(fnt);
		
		changePane.add(nextBtn).setBounds(400,500,100,30); 
		changePane.add(cancelBtn).setBounds(530,500,100,30);
		
		/// 버튼 패널 main으로 감싸고 아래 간격을 주고 그 안에 또 다른 btn 패널을 넣는다
		add("South", btnMainPane);
		btnMainPane.setLayout(new BorderLayout(0,30));
		btnMainPane.add("South",new JLabel());
		btnMainPane.add(btnPane);
		btnMainPane.setBackground(Color.white);
		
		btnPane.add(nextBtn);
		btnPane.add(cancelBtn);
		btnPane.setBackground(Color.white);
		
		nextBtn.setFont(fnt);
		nextBtn.setBackground(new Color(0,130,255));
		nextBtn.setForeground(Color.white);
		cancelBtn.setFont(fnt);
		cancelBtn.setBackground(new Color(0,130,255));
		cancelBtn.setForeground(Color.white);
		
		setBackground(Color.white);
		setSize(1000,800);
		setVisible(true);
		
		nextBtn.addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent ae) {
		Object obj = ae.getSource();
		if(obj instanceof JButton) {
			String btn = ae.getActionCommand();
			if(btn.equals("다음")) {
				removeAll();
				add("Center",reservation2.changePane);
				add("South",reservation2.btnMainPane);
				revalidate();
				repaint();
			}
		}
	}

}

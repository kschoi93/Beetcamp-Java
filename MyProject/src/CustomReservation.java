import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
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
	
	JButton cancelBtn = new JButton("예약취소");
	JButton nextBtn = new JButton("다음단계");
	
	JPanel main = new JPanel();
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
		
		changePane.add(cancelBtn).setBounds(400,500,100,30);
		changePane.add(nextBtn).setBounds(530,500,100,30); 
		
		cancelBtn.setFont(fnt);
		cancelBtn.setBackground(new Color(0,130,255));
		cancelBtn.setForeground(Color.white);
		nextBtn.setFont(fnt);
		nextBtn.setBackground(new Color(0,130,255));
		nextBtn.setForeground(Color.white);
			
		setBackground(Color.white);
		setSize(1000,800);
		setVisible(true);
		
		cancelBtn.addActionListener(this);
		nextBtn.addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent ae) {
		Object obj = ae.getSource();
		if(obj instanceof JButton) {
			String btn = ae.getActionCommand();
			if(btn.equals("예약취소")) {
				this.setVisible(false);
				CustomFrame.plan.setVisible(true);
			} else if(btn.equals("다음단계")) {
				this.setVisible(false);
				CustomFrame.reservation2.setVisible(true);
				CustomFrame.centerPane.add(CustomFrame.reservation2);
			}
		}
	}

}

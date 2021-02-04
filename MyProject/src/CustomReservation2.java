import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class CustomReservation2 extends JPanel{
	Font fnt = new Font("굴림체",Font.BOLD,14);
	JPanel changePane = new JPanel();
		JPanel centerPane = new JPanel();
			JPanel northPane = new JPanel();
				JPanel titlePane = new JPanel();
					JLabel titleLbl = new JLabel("항공편을 선택하세요");
				JPanel countryPane = new JPanel();
					JLabel startCountry = new JLabel("출발지");
					ImageIcon icon = new ImageIcon("img/arrow.png");
					Image im = icon.getImage();
					Image im2 = im.getScaledInstance(50, 30, Image.SCALE_DEFAULT);
					ImageIcon icon2 = new ImageIcon(im2);
					JLabel arriveCountry = new JLabel("도착지");
				JPanel datePane = new JPanel();
					JLabel startDate = new JLabel("2021/02/02");
					JLabel arriveDate = new JLabel("2021/02/08");
			JPanel tablePane = new JPanel();
				Object modelTitle[] = {"출발시간","도착시간","총 비행시간","비행편명","예약 상태","운임"};
				String str[][] = {
						{"x","x","x","x","x","x"}
				};
				DefaultTableModel model = new DefaultTableModel(str,modelTitle);
				JTable tbl = new JTable(model);
				JScrollPane sp = new JScrollPane(tbl);
			
	JPanel btnMainPane = new JPanel();
		JPanel btnPane = new JPanel();
			JButton nextBtn = new JButton("예약취소");
			JButton cancelBtn = new JButton("다음");
	public CustomReservation2() {
		setLayout(new BorderLayout());
		
		// 전환되는 패널
		add("North",changePane);
		changePane.setLayout(new BorderLayout(200,100));
		changePane.setBackground(Color.white);
		changePane.add("North",new JLabel());
		changePane.add("East",new JLabel());
		changePane.add("West",new JLabel());
		changePane.add("Center",centerPane);
			centerPane.setLayout(new BorderLayout());
			centerPane.setBackground(Color.white);
			centerPane.add("North",northPane);
				northPane.setLayout(new GridLayout(3,1));
				northPane.setBackground(Color.white);
					// 타이틀 라벨
					northPane.add(titleLbl);
						titleLbl.setHorizontalAlignment(JLabel.CENTER);
						titleLbl.setFont(new Font("굴림체",Font.BOLD,24));
						titleLbl.setBackground(Color.white);
					// 도시표시 패널
					northPane.add(countryPane);
						countryPane.setLayout(new FlowLayout(FlowLayout.CENTER,30,10));
						//출발지
						countryPane.add(startCountry);
						countryPane.setBackground(Color.white);
							startCountry.setFont(fnt);
							startCountry.setBackground(Color.white);
						//화살표
						countryPane.add(new JLabel(icon2));
						//도착지
						countryPane.add(arriveCountry);
							arriveCountry.setFont(fnt);
							arriveCountry.setBackground(Color.white);
					//날짜패널
					northPane.add(datePane);
					datePane.setBackground(Color.white);
						datePane.setLayout(new FlowLayout(FlowLayout.CENTER,80,0));
						datePane.setBackground(Color.white);
						// 출발 날짜
						datePane.add(startDate);
							startDate.setFont(fnt);
							startDate.setBackground(Color.white);
							// 복귀 날짜
						datePane.add(arriveDate);
							arriveDate.setFont(fnt);
							arriveDate.setBackground(Color.white);
			//테이블 패널
			centerPane.add("Center",tablePane);
			tablePane.setBackground(Color.white);
				tablePane.add(sp);
				sp.setFont(fnt);
		
		
		/// 버튼 패널 main으로 감싸고 아래 간격을 주고 그 안에 또 다른 btn 패널을 넣는다
		add("South", btnMainPane);
		btnMainPane.setBackground(Color.white);
		btnMainPane.setLayout(new BorderLayout(0,50));
		btnMainPane.add("North",new JLabel());
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
	}

}

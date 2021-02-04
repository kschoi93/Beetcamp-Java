import java.awt.Font;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class DigitalClock extends JFrame{
	Font fnt = new Font("±¼¸²Ã¼",Font.BOLD,100);
	JLabel timeView = new JLabel("00:00:00",JLabel.CENTER);	
	public DigitalClock() {
		add(timeView);		
		timeView.setFont(fnt);
		
		
		
		pack();
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		changeTime();
	}
	public void changeTime() {
		while(true) {
			Calendar now = Calendar.getInstance();
			SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");
			String txt = format.format(now.getTime());
			timeView.setText(txt);
			try {Thread.sleep(1000);}catch(Exception e) {}
		}
	}

	public static void main(String[] args) {
		new DigitalClock();

	}

}

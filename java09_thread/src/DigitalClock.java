import java.awt.Font;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class DigitalClock extends JFrame implements Runnable{
	Font fnt = new Font("±¼¸²Ã¼",Font.BOLD,100);
	JLabel timeView = new JLabel("00:00:00",JLabel.CENTER);	
	public DigitalClock() {}
	public DigitalClock(int x, int y,int w, int h) {
		add(timeView);		
		timeView.setFont(fnt);
		
		setBounds(x,y,w,h);
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
	}
	public void run() {	
		while(true) {
			Calendar now = Calendar.getInstance();
			SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");
			String txt = format.format(now.getTime());
			timeView.setText(txt);
			try {Thread.sleep(1000);}catch(Exception e) {}
		}
	}


}

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class ImageGraphics extends JFrame implements ActionListener{

	JPanel pane = new JPanel();
		JButton btn1 = new JButton("원본그리기");
		JButton btn2 = new JButton("축소그리기");
		JButton btn3 = new JButton("확대그리기");
		JButton btn4 = new JButton("좌우뒤집기");
		JButton btn5 = new JButton("상하뒤집기");
		JButton btn6 = new JButton("일부그리기");
		
	MyCanvas mc = new MyCanvas();
	String selBtn = ""; // 현재 선택된 버튼 라벨
	Image img;
	public ImageGraphics() {
		pane.add(btn1);
		pane.add(btn2);
		pane.add(btn3);
		pane.add(btn4);
		pane.add(btn5);
		pane.add(btn6);
		add("North",pane);
		add("Center",mc);
		
		
		
		setSize(1200,1200);
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		btn1.addActionListener(this);
		btn2.addActionListener(this);
		btn3.addActionListener(this);
		btn4.addActionListener(this);
		btn5.addActionListener(this);
		btn6.addActionListener(this);
		
	}
	
	public class MyCanvas extends Canvas{
		int w;
		int h;
		public MyCanvas() {
			img = Toolkit.getDefaultToolkit().getImage("img/Lighthouse.jpg");
		}
		public void paint(Graphics g) {
			// 이미지의 폭과 높이를 구한다
			// paint 메소드 내에서 구해야 한다.
			w = img.getWidth(this);
			h = img.getHeight(this);
						
			//이미지를 그림으로 그리기
			//				캔버스의 사이즈	img사이즈
			if(selBtn.equals("원본그리기")) {
				g.drawImage(img, 0, 0, w, h, 0, 0, w, h, this);
			} else if(selBtn.equals("축소그리기")) {
				g.drawImage(img, 0, 0, w/2, h/2, 0, 0, w, h, this);
			} else if(selBtn.equals("확대그리기")) {
				int cw = getWidth();
				int ch = getHeight();
				g.drawImage(img, 0, 0, cw, ch, 0, 0, w, h, this);
			} else if(selBtn.equals("좌우뒤집기")) {
				g.drawImage(img, w, 0, 0, h, 0, 0, w, h, this);
			} else if(selBtn.equals("상하뒤집기")) {
				g.drawImage(img, 0, 0, w, h, 0, h, w, 0, this);
			} else if(selBtn.equals("일부그리기")) {
				g.drawImage(img, 0, 0, 300, 300, 200, 200, 500, 500, this);
			}
		}
		
	}
	
	public static void main(String[] args) {
		new ImageGraphics();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		selBtn = e.getActionCommand();
		mc.repaint();//paint() 메소드 호출
		
		
	}
}

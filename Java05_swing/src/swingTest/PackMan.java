package swingTest;
import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JPanel;

public class PackMan  extends JPanel implements Runnable{
	Image img;
	MyCanvas mc;
	/////////////////////
	Dimension frameSize, canvasSize;
	int x, y;
	int p = 0;

	public PackMan() {
		img = Toolkit.getDefaultToolkit().getImage("img/packman.jpg");
		setLayout(new BorderLayout());
		
		mc = new MyCanvas();
		add(BorderLayout.CENTER, mc);
//		setBounds(x1,y2,w3,h4);
//		setVisible(true);
//		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		// mc에 이벤트가 생기면 캔버스 키이벤트에 가서 실행할거다
		mc.addKeyListener(new CanvasKeyEvent());
		mc.setFocusable(true);
	}
	
	public void run() {
		
		while(true) {
			
			try{Thread.sleep(200);}catch(Exception e) {}
			// 이미지 변환
			if(p%2==0) p++;
			else p--;
			
			// 방향바꾸기
			if(p==0 || p==1) {
				x-=5;
				if(x<=-50) x= (int)canvasSize.getWidth();
			} else if(p==2||p==3) {
				x+=5;
				if(x>=(int)canvasSize.getWidth()) x=-50;
			} else if(p==4||p==5) {
				y-=5;
				if(y<=-50) y= (int)canvasSize.getHeight();
			} else if(p==6||p==7) {
				y+=5;
				if(y>=(int)canvasSize.getHeight()) y=-50;
			}
			
			mc.repaint();
		}
		
	}
	
	public class MyCanvas extends Canvas{
		public void paint(Graphics g) {
			g.drawImage(img, x, y, x+50, y+50, p*50, 0, p*50+50, 50, this);
		}
	}
	
	public class CanvasKeyEvent extends KeyAdapter{
		public void keyReleased(KeyEvent ke) {
			int key = ke.getKeyCode();
			if(key==KeyEvent.VK_A || key==KeyEvent.VK_LEFT) {
				p=0;// 0 1
			} else if(key==KeyEvent.VK_D || key==KeyEvent.VK_RIGHT) {
				p=2;// 2 3
			} else if(key==KeyEvent.VK_W || key==KeyEvent.VK_UP) {
				p=4;// 4 5
			} else if(key==KeyEvent.VK_S || key==KeyEvent.VK_DOWN) {
				p=6;// 6 7
			}
		}
	}
	
	public void getPackManSize() {
		frameSize = getSize();
		canvasSize = mc.getSize();
		x = (int)canvasSize.getWidth()/2-25;
		y = (int)canvasSize.getHeight()/2-25;
	}
	

}

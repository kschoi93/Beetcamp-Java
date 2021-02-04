
import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class AirplaneMoving extends JFrame{
	MyCanvas mc = new MyCanvas();
	Image airplane, cloud1,cloud2;
	int airplaneX, airplaneY, checkY;
	int change = 0;
	Random ran = new Random();
	int[][] r = new int[20][20];
	Dimension frameSize, fullSize;
	public AirplaneMoving() {
		airplane = Toolkit.getDefaultToolkit().getImage("img/airplane.png");
		cloud1 = Toolkit.getDefaultToolkit().getImage("img/cloud1.png");
		cloud2 = Toolkit.getDefaultToolkit().getImage("img/cloud2.png");
		
		setLayout(new BorderLayout());
		setBackground(Color.white);
		setVisible(true);
		setSize(1000,800);
		add(mc);
		mc.setFocusable(true);
		while(true) {
			
			airplaneX-=5;
			if(airplaneX==-100) airplaneX = ( (int)fullSize.getWidth()/10 )*10;
			mc.repaint();
			try {Thread.sleep(100);}catch(Exception e) {e.printStackTrace();}

		}
	}
	public void run() {

	}
	class MyCanvas extends Canvas{
		public void paint(Graphics g) {
			g.drawImage(airplane, airplaneX, airplaneY, 100, 100, this);
			for(int i=0; i<r.length;i++) {
				if(i<4) g.drawImage(cloud1, r[i][0], r[i][1], 30, 30, this);
				else if(i>=4) g.drawImage(cloud2, r[i][0], r[i][1], 30, 30, this);
			}
		}
	}
	public void getFrameSize() {
		frameSize = getSize();
		fullSize = Toolkit.getDefaultToolkit().getScreenSize();
		airplaneSize();
		cloudSize();
		System.out.println("x= "+ airplaneX + ", y= " + airplaneY + ", check= " + checkY + ", r[0][1]= " + r[0][1]);
	}
	public void airplaneSize() {
		airplaneX = ( (int)fullSize.getWidth()/10 )*10;
		airplaneY = (( (int)frameSize.getHeight()/2 - 15) /10 ) *10;
		checkY = ( (int) frameSize.getHeight() /10 ) * 10 -30;
	}
	public void cloudSize(){
		for(int i =0; i<r.length;i++) {
			r[i][0] = ran.nextInt(((int)fullSize.getWidth()/10)*10);
			r[i][1] = ran.nextInt(((int)frameSize.getHeight()/10)*10);
		}
	}
	public static void main(String[]args) {
		new AirplaneMoving();
	}
}

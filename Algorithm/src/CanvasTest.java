import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class CanvasTest extends JFrame{
	JPanel pane = new JPanel();
	MyCanvas mc;
	Image img;
	int x,y;
	public CanvasTest() {
		img = Toolkit.getDefaultToolkit().getImage("img/airplane.png");
		mc = new MyCanvas();
		add(BorderLayout.CENTER,mc);
		getContentPane().setBackground(Color.white);
		setSize(800,800);
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		x=0;
		y=0;
		while(true) {
			x+=10;
			try{ Thread.sleep(200);}catch(Exception e) {e.printStackTrace();}
			mc.repaint();
			try{ Thread.sleep(200);}catch(Exception e) {e.printStackTrace();}
		}
	}
	public class MyCanvas extends Canvas{
		public void paint(Graphics g) {
			g.drawImage(img, x, y,200, 200, this);
		}
	}

	public static void main(String[] args) {
		new CanvasTest();

	}

}

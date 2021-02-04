import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JFrame;

public class GraphicTest extends JFrame{
	MyCanvas mc = new MyCanvas();
	
	
	public GraphicTest() {
		setTitle("그림판");
		add(BorderLayout.CENTER,mc);
		
		setSize(800,800);
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}
	
	// 그림 그리기
	// Canvas를 상속받아 Paint()를 Overring 하면 처음 객체 생성시 별도의 호출 없이
	// 			paint() 메소드는 1번 자동 호출된다.
	class MyCanvas extends Canvas{
		public MyCanvas() {}
		// 그림을 그리는 메소드를 오버라이딩 한다. --> 생성자 메소드 실행 후 자동 호출된다
		public void paint(Graphics g) {
			// 직선 그리기
			g.drawLine(50, 50, 300, 300);
			// 사각형 그리기
			g.drawRect(80, 50, 200, 300);
			//색상 변경
			g.setColor(Color.red);
			g.fillRect(400, 50, 200, 300);
			g.setColor(Color.getHSBColor(30, 50, 30));
			g.fillRect(50, 300, 200, 100);
			//글자 그리기
			g.setColor(Color.blue);
			g.setFont(new Font("굴림체",Font.BOLD,30));
			String str = "문자열을 그림으로";
			g.drawString(str, 50, 400);
			g.draw3DRect(100, 100, 100, 100, rootPaneCheckingEnabled);
			//원그리기
			g.drawOval(80, 50, 200, 300);
			g.fillOval(20, 500, 200, 200);
			
			//둥근원
			g.drawRoundRect(250, 250, 400, 400, 400, 200);
			
			//다각형
			g.setColor(Color.getHSBColor(110, 40, 20));
			int x[] = {500,600,550,300,310};
			int y[] = {300,380,600,800,500};
			g.fillPolygon(x, y, 5);
			
			
		}
	}

	public static void main(String[] args) {
		new GraphicTest();

	}

}

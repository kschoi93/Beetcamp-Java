import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JFrame;

public class GraphicTest extends JFrame{
	MyCanvas mc = new MyCanvas();
	
	
	public GraphicTest() {
		setTitle("�׸���");
		add(BorderLayout.CENTER,mc);
		
		setSize(800,800);
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}
	
	// �׸� �׸���
	// Canvas�� ��ӹ޾� Paint()�� Overring �ϸ� ó�� ��ü ������ ������ ȣ�� ����
	// 			paint() �޼ҵ�� 1�� �ڵ� ȣ��ȴ�.
	class MyCanvas extends Canvas{
		public MyCanvas() {}
		// �׸��� �׸��� �޼ҵ带 �������̵� �Ѵ�. --> ������ �޼ҵ� ���� �� �ڵ� ȣ��ȴ�
		public void paint(Graphics g) {
			// ���� �׸���
			g.drawLine(50, 50, 300, 300);
			// �簢�� �׸���
			g.drawRect(80, 50, 200, 300);
			//���� ����
			g.setColor(Color.red);
			g.fillRect(400, 50, 200, 300);
			g.setColor(Color.getHSBColor(30, 50, 30));
			g.fillRect(50, 300, 200, 100);
			//���� �׸���
			g.setColor(Color.blue);
			g.setFont(new Font("����ü",Font.BOLD,30));
			String str = "���ڿ��� �׸�����";
			g.drawString(str, 50, 400);
			g.draw3DRect(100, 100, 100, 100, rootPaneCheckingEnabled);
			//���׸���
			g.drawOval(80, 50, 200, 300);
			g.fillOval(20, 500, 200, 200);
			
			//�ձٿ�
			g.drawRoundRect(250, 250, 400, 400, 400, 200);
			
			//�ٰ���
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

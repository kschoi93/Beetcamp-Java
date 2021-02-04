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
		JButton btn1 = new JButton("�����׸���");
		JButton btn2 = new JButton("��ұ׸���");
		JButton btn3 = new JButton("Ȯ��׸���");
		JButton btn4 = new JButton("�¿������");
		JButton btn5 = new JButton("���ϵ�����");
		JButton btn6 = new JButton("�Ϻα׸���");
		
	MyCanvas mc = new MyCanvas();
	String selBtn = ""; // ���� ���õ� ��ư ��
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
			// �̹����� ���� ���̸� ���Ѵ�
			// paint �޼ҵ� ������ ���ؾ� �Ѵ�.
			w = img.getWidth(this);
			h = img.getHeight(this);
						
			//�̹����� �׸����� �׸���
			//				ĵ������ ������	img������
			if(selBtn.equals("�����׸���")) {
				g.drawImage(img, 0, 0, w, h, 0, 0, w, h, this);
			} else if(selBtn.equals("��ұ׸���")) {
				g.drawImage(img, 0, 0, w/2, h/2, 0, 0, w, h, this);
			} else if(selBtn.equals("Ȯ��׸���")) {
				int cw = getWidth();
				int ch = getHeight();
				g.drawImage(img, 0, 0, cw, ch, 0, 0, w, h, this);
			} else if(selBtn.equals("�¿������")) {
				g.drawImage(img, w, 0, 0, h, 0, 0, w, h, this);
			} else if(selBtn.equals("���ϵ�����")) {
				g.drawImage(img, 0, 0, w, h, 0, h, w, 0, this);
			} else if(selBtn.equals("�Ϻα׸���")) {
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
		mc.repaint();//paint() �޼ҵ� ȣ��
		
		
	}
}

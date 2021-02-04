import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Toolkit;

public class FrameTest {
	//��ü�� �̿��� frame ����
	Frame frm = new Frame();
	Dimension dim = new Dimension(400,300);
//	Rectangle rtg = new Rectangle(400,300,500,500);
	Point pnt = new Point(200,200);
	Rectangle rect = new Rectangle(pnt, dim);
	public FrameTest() {	
		frm.setTitle("������ Frame");
		
		
		// â�� ũ�� ����
//		frm.setSize(500, 500);
		//frm.setBounds(100, 100, 500, 500);
//		frm.setSize(dim);
//		frm.setBounds(rtg);
		frm.setBounds(rect);
		
		Button btn1 = new Button("��ư");
		frm.add(btn1);
		
		Button btn2 = new Button("��ư2");
		// borderLayout.north
		frm.add("North",btn2);
		frm.add(BorderLayout.EAST,new Button("��ư 3"));
		frm.add(BorderLayout.SOUTH,new Button("��ư 4"));
		frm.add(BorderLayout.WEST,new Button("��ư5"));
//		frm.pack();
		// â�� show
		frm.setVisible(true);
		
		// ������ �����
		Toolkit kit = Toolkit.getDefaultToolkit();
		Image img = kit.getImage("img/logo.png");
		frm.setIconImage(img);
		
	}

	public static void main(String[] args) {
		new FrameTest();
	}

}

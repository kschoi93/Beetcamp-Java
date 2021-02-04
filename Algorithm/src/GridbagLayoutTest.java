import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.Arrays;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class GridbagLayoutTest extends JFrame{
	JPanel pane = new JPanel();
	JButton btn1 = new JButton("1");
	JButton btn2 = new JButton("2");
	JButton btn3 = new JButton("3");
	JButton btn4 = new JButton("4");
	JButton btn5 = new JButton("5");
	JButton btn6 = new JButton("6");
	JButton btn7 = new JButton("7");
	GridBagLayout grid = new GridBagLayout();
	public GridbagLayoutTest() {
		pane.setLayout(grid);
		GridBagConstraints gbc = new GridBagConstraints();
		// x,y�� ��� ä��
		gbc.fill = GridBagConstraints.BOTH;
		
		gbc.weightx=1.0;
		gbc.weighty=1.0;
		gbc.gridx=0;
		gbc.gridy=0; // ��ư�� x y�� �������� ����
		pane.add(btn1,gbc);
		Dimension b = btn1.getSize();
		int c= btn1.getWidth();
		int [][] a = grid.getLayoutDimensions();
		System.out.println(grid.getLayoutAlignmentX(btn1));
		System.out.println(grid.getLayoutAlignmentY(btn1));
//		System.out.println(a[0][0]);
		System.out.println(b);
		System.out.println(Arrays.deepToString(a));
		System.out.println(c);

		
		
		gbc.weightx=1.0;
		gbc.weighty=1.0;
		gbc.gridx=1;
		gbc.gridy=0;
		pane.add(btn2,gbc);
		
		add(pane);
		
		setSize(500,500);
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		System.out.println(pane.getSize());
		System.out.println(pane.getAlignmentX());
	}

	public static void main(String[] args) {
		new GridbagLayoutTest();

	}

}

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.RenderingHints;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class DesignButtonTest extends JFrame {
	JPanel pane = new JPanel();
	RoundedButton btn = new RoundedButton();
	public DesignButtonTest() {
		
		add(pane);
		pane.add(btn);
		
		setSize(500,500);
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}
	
	class RoundedButton extends JButton{
		Font fnt = new Font("�޸�����ü",Font.BOLD,12);
		public RoundedButton() {
			super("�׽�Ʈ");
			setForeground(Color.white);
		}
		
		protected void decorate() {
			setBorderPainted(false);
			setOpaque(false);
		}
		protected void paintComponent(Graphics g) {
			int width = getWidth();
			int height = getHeight();
			
			Graphics2D graphics = (Graphics2D)g;
			//��������Ʈ�� ���� ����� �簢���� �ε巴�� ó��
			graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
			if (getModel().isArmed()) { 
				graphics.setColor(new Color(0,150,250).darker()); 
			} else if (getModel().isRollover()) { 
				graphics.setColor(new Color(50,130,250).darker()); 
			} else { 
				graphics.setColor(new Color(30,120,250).darker()); 
			}

			graphics.fillRoundRect(0, 0, width, height, 20, 20);
			
			// ���� ������ ��Ʈ�� ������ ������ �ִ� Ŭ����
			FontMetrics fontMetrics = graphics.getFontMetrics();
			// �簢���� ũ�⸦ ���Ѵ�
			Rectangle stringBounds = fontMetrics.getStringBounds(this.getText(), graphics).getBounds();
			
			int textX = (width - stringBounds.width) / 2;
			int textY = (height - stringBounds.height) / 2 + fontMetrics.getAscent();
			
			graphics.setColor(getForeground());
			graphics.setFont(fnt);
			graphics.drawString(getText(), textX, textY);
			graphics.dispose();
			
		}
	}

	public static void main(String[] args) {
		new DesignButtonTest();

	}

}

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
		Font fnt = new Font("휴면편지체",Font.BOLD,12);
		public RoundedButton() {
			super("테스트");
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
			//렌더링힌트를 통해 배경의 사각형을 부드럽게 처리
			graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
			if (getModel().isArmed()) { 
				graphics.setColor(new Color(0,150,250).darker()); 
			} else if (getModel().isRollover()) { 
				graphics.setColor(new Color(50,130,250).darker()); 
			} else { 
				graphics.setColor(new Color(30,120,250).darker()); 
			}

			graphics.fillRoundRect(0, 0, width, height, 20, 20);
			
			// 현재 설정된 폰트의 정보를 가지고 있는 클래스
			FontMetrics fontMetrics = graphics.getFontMetrics();
			// 사각형의 크기를 구한다
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

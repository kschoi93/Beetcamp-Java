

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;

public class KeyPressedTest  implements KeyListener{

	public KeyPressedTest() {
		JFrame frm = new JFrame();
		frm.setSize(400,400);
		frm.setVisible(true);
		
		frm.addKeyListener(this);
	}

	@Override
	public void keyTyped(KeyEvent e) {
		System.out.println("keyTyped");
	}

	@Override
	public void keyPressed(KeyEvent e) {
		System.out.println("keyPressed");		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		System.out.println("keyReleased");
		
	}
	
	public static void main(String[] args) {
		new KeyPressedTest();
	}
}

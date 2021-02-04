import java.awt.Dialog;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class WindowEventTest extends JFrame implements WindowListener{
	JLabel lbl = new JLabel("����");
	Calculator cal = new Calculator();
	Dialog di;
	public WindowEventTest() {
		add("North",lbl);
		add(cal);
		setSize(500,300);
		setVisible(true);
		//���α׷� ����� �ڿ�����
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		//â�ݱ� ����
//		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		addWindowListener(this);
	}
	
	public static void main(String[] args) {
		new WindowEventTest();
	}
	@Override
	public void windowOpened(WindowEvent e) {
		System.out.println("Opened");		
	}
	@Override
	public void windowClosing(WindowEvent e) {
		int state =JOptionPane.showConfirmDialog(this, "�����Ͻðڽ��ϱ�?", "����Ȯ��", JOptionPane.YES_NO_OPTION);
		
		if(state == JOptionPane.YES_OPTION) {
			System.exit(0);
		}
		System.out.println("Closing");
	}
	@Override
	public void windowClosed(WindowEvent e) {
		System.out.println("Closed");
	}
	@Override
	public void windowIconified(WindowEvent e) {
		System.out.println("Iconified");		
	}
	@Override
	public void windowDeiconified(WindowEvent e) {
		System.out.println("Deiconified");		
	}
	@Override
	public void windowActivated(WindowEvent e) {
		System.out.println("Activated");
	}
	@Override
	public void windowDeactivated(WindowEvent e) {
		System.out.println("Deactivated");
	}
}

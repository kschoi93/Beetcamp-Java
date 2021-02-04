// 최경식


import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;


public class CalculatorFrame extends JFrame implements ActionListener, KeyListener{
	String[] word = {"7","8","9","+","4","5","6","-","1","2","3","*","0",".","=","/"};
	String[] str = {"BackSpace","Clear","End"};

	JLabel label = new JLabel("0.0");
	JPanel displayPanel = new JPanel();
	JPanel buttonPanel = new JPanel();
	JPanel calButtonPanel = new JPanel();
	
	JButton button[] = new JButton[str.length];
	JButton calButton[] = new JButton[word.length];
	public CalculatorFrame() {
		super("Calculator");
		Container contentPane = getContentPane();
		

		// 상단 텍스트 부분
		add(label,displayPanel);
			label.setText("0.0");
			label.setHorizontalAlignment(JLabel.RIGHT);
		
			
		// 중간 버튼 부분
		add(BorderLayout.CENTER,buttonPanel);
			buttonPanel.setLayout(new GridLayout(1,3));
			for(int i=0; i<str.length;i++) {
				buttonPanel.add(button[i] = new JButton(str[i]));
			}
		
		// 하단 버튼 부분
		add(BorderLayout.SOUTH,calButtonPanel);
			calButtonPanel.setLayout(new GridLayout(4,4));
			for(int i=0; i<word.length;i++) {
				calButtonPanel.add(calButton[i] = new JButton(word[i]));
			}
			
		for(int i=0; i<button.length;i++) {
			button[i].addActionListener(this);
		}
		for(int i=0; i<calButton.length;i++) {
			calButton[i].addActionListener(this);
		}
		
		setSize(500,500);
		pack();
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}


	public static void main(String[] args) {
		new CalculatorFrame();
	}


	@Override
	public void actionPerformed(ActionEvent e) {

	}


	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}

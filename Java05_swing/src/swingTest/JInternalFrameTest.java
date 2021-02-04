package swingTest;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JDesktopPane;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JSlider;
import javax.swing.JTextArea;
import javax.swing.JToolBar;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class JInternalFrameTest extends JFrame implements ActionListener, ChangeListener, ListSelectionListener{
	JDesktopPane dp = new JDesktopPane();
	JInternalFrame if1, if2,if3,if4;
	JTextArea ta = new JTextArea();
	
	JToolBar tb = new JToolBar();
		JButton saveBtn = new JButton("����");
		JButton colorBtn = new JButton("����ǥ-���ڻ�");
		JButton calBtn = new JButton("����");
		
	JSlider redSlider = new JSlider(JSlider.HORIZONTAL,0,255,150);
	
	JList<String> list = new JList<String>();
		DefaultListModel<String> model = new DefaultListModel<String>();
		String flower[] = {"�ǵ���","ƫ��","�ڽ���","���","�عٶ��","���߽Ž�","�Ȱ���","���ò�"};
		JScrollPane sp = new JScrollPane(list);
	
	public JInternalFrameTest() {
		///////
		add("North",tb);
		tb.add(saveBtn);
		tb.add(colorBtn);
		tb.add(calBtn);
		///////
		add("South", redSlider);
		redSlider.setMajorTickSpacing(50);//�ִ���
		redSlider.setMinorTickSpacing(5);//��������
		redSlider.setPaintTicks(true);// ���� �����ֱ�
		redSlider.setPaintLabels(true);// ��ǥ��
		redSlider.setSnapToTicks(true);//����� ���ݼ����� ��ƽ�� �̵��Ѵ�.
		
		add(dp);
		
		for(String flowerName:flower) {
			model.addElement(flowerName);
		}
		list.setModel(model);
		add("East",sp);
		
		//Frame �����
    	// borderLayout
		if1 = new JInternalFrame();
		if1.add(ta);
		if1.setSize(300,800);
		if1.setVisible(true);
		dp.add(if1);
		
		// String title, boolean reizable, boolean closable,boolean maximizable,boolean iconifiable
		if2 = new JInternalFrame("�޷�",true, true, true, true);
		CalendarSwing cs = new CalendarSwing();
		if2.add(cs);
		if2.setBounds(100,100,400,300);
		if2.setVisible(true);
		dp.add(if2);
		
		if3 = new JInternalFrame("�ð�");
		DigitalClock dc = new DigitalClock();
		if3.add(dc);
		if3.setBounds(1,500,600,200);
		if3.setVisible(true);
		dp.add(if3);
		
		if4 = new JInternalFrame("�Ѹ�");
		PackMan pm = new PackMan();
		if4.add(pm);
		if4.setBounds(150,1,500,500);
		if4.setVisible(true);
		dp.add(if4);

		
		setSize(1000,800);
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		try {
			if2.setSelected(true);
			if4.setSelected(true);

			pm.getPackManSize();
		} catch(Exception e) {}
		Thread t1 = new Thread(dc);
		t1.start();
		Thread t2 = new Thread(pm);
		t2.start();
		saveBtn.addActionListener(this);
		colorBtn.addActionListener(this);
		redSlider.addChangeListener(this);
		list.addListSelectionListener(this);
		calBtn.addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent ae) {
		Object obj = ae.getSource();
		
		if(obj == saveBtn) {
			//Ȱ��ȭ �Ǿ� �ִ� JInternalFrame ��ü ������
			JInternalFrame eventIf= dp.getSelectedFrame();
			if(eventIf == if1) {
				JTextArea eventTa= (JTextArea)eventIf.getFocusOwner();
				String taStr = eventTa.getText();
				try {
					FileWriter fw = new FileWriter(new File("D://javaIO/internal.txt"));
					fw.write(taStr);
					fw.close();
				}catch(Exception e) {
					e.printStackTrace();
				}
			}
		} else if(obj == colorBtn) {
			JColorChooser cc = new JColorChooser(Color.blue);
			//			  �θ������̳�
			Color color = cc.showDialog(this,"����ǥ",Color.green);
			ta.setForeground(color);
		} else if(obj == calBtn) {
			JDialog dialog = new JDialog(this,"����",true);
			Calculator cal = new Calculator();
			dialog.add(cal);
			dialog.setSize(400,500);
			dialog.setVisible(true);
			
		}
		
	}
	public void stateChanged(ChangeEvent ce) {
		if(ce.getSource()==redSlider) {
			ta.setBackground(new Color(redSlider.getValue(),0,0));
		}
	}
	@Override
	public void valueChanged(ListSelectionEvent lse) {
		List<String> selectList= list.getSelectedValuesList();
		String txt ="";
		for(int i=0; i<selectList.size();i++) {
//			ta.append(selectList.get(i)+"\n");
			txt += selectList.get(i)+"\n";
		}
		ta.setText(txt);
	}
	public static void main(String[]args) {
		new JInternalFrameTest();
	}



}

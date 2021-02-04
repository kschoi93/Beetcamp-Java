import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class FileUnicasteSend extends JFrame implements ActionListener{
	JTextField tf = new JTextField("192.168.0.25");
	JButton btn = new JButton("파일 보내기");
	InetAddress ia;
	public FileUnicasteSend() {
		add("North", tf);
		add("South", btn);
		
		setSize(400,200);
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		tf.addActionListener(this);
		btn.addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent ae) {
		Object obj = ae.getSource();
		if(obj == tf) {
			
		}else if(obj == btn) {
			startSend();
		}
	}
	
	public void startSend() {
		try {
			JFileChooser fc = new JFileChooser();
			int state = fc.showOpenDialog(this);
			if(state==0) {// 열기 선택시 전송
				File f = fc.getSelectedFile();
				String filename = "&&FN$$"+f.getName();
				
				ia = InetAddress.getByName(tf.getText());
				DatagramSocket ds = new DatagramSocket();
				
				DatagramPacket dp = new DatagramPacket(filename.getBytes(),filename.getBytes().length,ia,20000);
				ds.send(dp);
				
				//파일내용
				FileInputStream fis = new FileInputStream(f);
				while(true) {
					byte[] sendData = new byte[256];
					int readCount = fis.read(sendData, 0, 256);
					if(readCount<=0)break;
					dp = new DatagramPacket(sendData, readCount, ia,20000);
					ds.send(dp);
					Thread.sleep(100);
				}
				
				//마지막 알림 
				String endData = "*&CL^&";
				dp = new DatagramPacket(endData.getBytes(),endData.getBytes().length,ia,20000);
				ds.send(dp);
				System.out.println(f.getPath()+"--> 파일 전송 완료");
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		System.out.println("데이터 보내기 완료");
	}

	public static void main(String[] args) {
		new FileUnicasteSend();

	}

}

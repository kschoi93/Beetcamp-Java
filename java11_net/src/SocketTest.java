import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;


public class SocketTest {
	
	public SocketTest() {
		try {
		InetAddress ia = InetAddress.getByName("180.233.244.51");
		int port = 12000;
		
		// ������ �����ϴ� ��ü�̴�.
		Socket s = new Socket(ia,12000);
		//�������� ���� ������ �ޱ�
		InputStream is = s.getInputStream(); // byte
		InputStreamReader isr = new InputStreamReader(is); // cahr
		BufferedReader br = new BufferedReader(isr); // line
		
		String data = br.readLine();
		System.out.println("�������� ���� ����--->"+data);
		
		
		// Ŭ���̾�Ʈ�� �������� ������ ������
		OutputStream os = s.getOutputStream();
		OutputStreamWriter osw = new OutputStreamWriter(os);
		PrintWriter pw = new PrintWriter(osw);
		
		pw.println("����...... server!!!!");
		pw.flush();
		br.close();
		pw.close();
		
		System.out.println("�������� ���ڸ� ���½��ϴ�");
		}catch(Exception e) {e.printStackTrace();}
	}

	public static void main(String[] args) {
		new SocketTest();

	}

}

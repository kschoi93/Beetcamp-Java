import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerSocketTest {

	public ServerSocketTest() {
			try {//								��Ʈ��ȣ
				
			ServerSocket ss = new ServerSocket(12000);
			
			//Ŭ���̾�Ʈ�� ���� �� �� ���� ����ϰ� �ִ�.
			//Ŭ���̾�Ʈ�� ������ �ϸ� Socket��ü�� �������ش�
			System.out.println("���� �����");
			Socket s = ss.accept();
			
			System.out.println("Ŭ���̾�Ʈ�� �����Ͽ����ϴ�");
			//Ŭ���̾�Ʈ�� �����ϸ� �������� ��ǻ�� ip�� indetAddress ��ü�� ������
			InetAddress ia = s.getInetAddress();
			System.out.println("�������� ip="+ia.getHostAddress());
			//������ �����ڿ��� ���ں�����
			OutputStream os = s.getOutputStream(); //byte
			OutputStreamWriter osw = new OutputStreamWriter(os);//char
			PrintWriter pw = new PrintWriter(osw);
			pw.println("�ȳ�..... �� ������...");
			pw.flush();
			System.out.println("Ŭ���̾�Ʈ���� ���ڸ� ���½��ϴ�....");
			
			// Ŭ���̾�Ʈ�� ���� ���� �ޱ�
			InputStream is = s.getInputStream();
			InputStreamReader isr = new InputStreamReader(is);
			BufferedReader br = new BufferedReader(isr);
			String data = br.readLine();
			System.out.println("Ŭ���̾�Ʈ���� ���� ����--->"+data);
			pw.close();
			br.close();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	public static void main(String[]args) {
		new ServerSocketTest();
	}
}

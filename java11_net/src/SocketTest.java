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
		
		// 서버에 접속하는 객체이다.
		Socket s = new Socket(ia,12000);
		//서버에서 보낸 데이터 받기
		InputStream is = s.getInputStream(); // byte
		InputStreamReader isr = new InputStreamReader(is); // cahr
		BufferedReader br = new BufferedReader(isr); // line
		
		String data = br.readLine();
		System.out.println("서버에서 받은 문자--->"+data);
		
		
		// 클라이언트가 서버에게 데이터 보내기
		OutputStream os = s.getOutputStream();
		OutputStreamWriter osw = new OutputStreamWriter(os);
		PrintWriter pw = new PrintWriter(osw);
		
		pw.println("하이...... server!!!!");
		pw.flush();
		br.close();
		pw.close();
		
		System.out.println("서버에게 문자를 보냈습니다");
		}catch(Exception e) {e.printStackTrace();}
	}

	public static void main(String[] args) {
		new SocketTest();

	}

}

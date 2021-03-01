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
			try {//								포트번호
				
			ServerSocket ss = new ServerSocket(12000);
			
			//클라이언트가 접속 할 때 까지 대기하고 있다.
			//클라이언트가 접속을 하면 Socket객체를 리턴해준다
			System.out.println("접속 대기중");
			Socket s = ss.accept();
			
			System.out.println("클라이언트가 접속하였습니다");
			//클라이언트가 접속하면 접속자의 컴퓨터 ip를 indetAddress 객체로 가진다
			InetAddress ia = s.getInetAddress();
			System.out.println("접속자의 ip="+ia.getHostAddress());
			//서버가 접속자에게 문자보내기
			OutputStream os = s.getOutputStream(); //byte
			OutputStreamWriter osw = new OutputStreamWriter(os);//char
			PrintWriter pw = new PrintWriter(osw);
			pw.println("안녕..... 난 서버야...");
			pw.flush();
			System.out.println("클라이언트에게 문자를 보냈습니다....");
			
			// 클라이언트가 보낸 문자 받기
			InputStream is = s.getInputStream();
			InputStreamReader isr = new InputStreamReader(is);
			BufferedReader br = new BufferedReader(isr);
			String data = br.readLine();
			System.out.println("클라이언트에서 보낸 문자--->"+data);
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

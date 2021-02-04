import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UnicastSend {
	DatagramSocket ds;
	DatagramPacket dp;
	InetAddress ia;
	public UnicastSend() {
		//UDP방식 데이터 보내기
		try {
			// 보낼 객체
			ds = new DatagramSocket();
			
			String data = "Java network 유니캐스트 통신 연습중..";
			// 받는쪽 아이피를 적어야 한다
			ia = InetAddress.getByName("192.168.0.25");
			//전송할 데이터 그램 패킷 객체생성
			//                     256 바이트 권장 바이트
			dp = new DatagramPacket(data.getBytes(), data.getBytes().length,ia,10000);
			
			//데이터 보내기
			ds.send(dp);
			ds.close();
		}catch(Exception e) {
			
		}
		System.out.println("보내기 완료");
	}

	public static void main(String[] args) {
		new UnicastSend();
	}

}

import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

//범용 아이피
//224.0.0.0 ~ 239.255.255.255

// 230.0.0.4
public class MulticastSocketSend {

	public MulticastSocketSend() {
		String sendData = "멀티캐스트 전송 테스트중.....";
		try {
			MulticastSocket ms = new MulticastSocket();
			
			InetAddress ia = InetAddress.getByName("230.0.0.4");
			
			DatagramPacket dp = new DatagramPacket(sendData.getBytes()
					,sendData.getBytes().length,ia,25000);
			
			//공용 ip로 데이터 보내기
			ms.send(dp);
			
			System.out.println("보내기 완료.......");
			
			
		}catch(Exception e) {
			e.printStackTrace();
			
		}
		
	}

	public static void main(String[] args) {
		new MulticastSocketSend();
	}

}

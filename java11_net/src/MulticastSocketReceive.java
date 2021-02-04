import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

public class MulticastSocketReceive {

	public MulticastSocketReceive() {
		//받기
		try {
			MulticastSocket ms = new MulticastSocket(25000);
			
			InetAddress ia = InetAddress.getByName("230.0.0.4");
			
			ms.joinGroup(ia);
			byte data[] = new byte[512];
			
			DatagramPacket dp = new DatagramPacket(data, data.length);
			
			System.out.println("받기 대기중");
			ms.receive(dp);
			
			////////////////////////////////////
			byte receiveData[] = dp.getData();
			int receiveCount = dp.getLength();
			
			System.out.println("받은 문자-->"+ new String(receiveData,0,receiveData.length));
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		new MulticastSocketReceive();
	}

}

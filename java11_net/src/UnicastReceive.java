import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UnicastReceive {
	DatagramSocket ds;
	DatagramPacket dp;
	public UnicastReceive() {
		//UDP방식 데이터 받기
		try {
			//받기를 할 객체
			ds = new DatagramSocket(10000);
			
			//받은 데이터를 저장할 배열
			byte data[] = new byte[256];
			
			dp = new DatagramPacket(data,data.length);
			
			System.out.println("전송 받기 대기중.....");
			ds.receive(dp);
			
			// 받은 데이터 처리
			byte receiveData[] = dp.getData();// 전송받은 데이터 배열
			int len = dp.getLength();// 전송받은 byte수 구하기
			System.out.println("받은 문자-->"+ new String(receiveData,0,len)+"-------------");
		
		}catch(Exception e) {
			e.printStackTrace();
		}
		System.out.println("프로그램이 종료되었습니다.");
	}

	public static void main(String[] args) {
		new UnicastReceive();

	}

}

import java.net.InetAddress;

public class InetAddressTest {

	public InetAddressTest() {
		try {
			//InetAddress , 자신의 아이피 주소와 컴퓨터 이름을 가져온다
			InetAddress ia1 = InetAddress.getLocalHost();
			System.out.println("자신의 아이피, 이름");
			String ip = ia1.getHostAddress();
			String hostname = ia1.getHostName();
			System.out.println("ia1.getHostAddress()->"+ip);
			System.out.println("ia1.getHostName()->"+hostname);
			System.out.println();
			
			//URL을 통한 주소, 이름 받아오기
			System.out.println("getbyname에 들어있는 주소의 아이피, 이름");
			InetAddress ia2 = InetAddress.getByName("www.nate.com");
			System.out.println("ia2.address->"+ia2.getHostAddress());
			System.out.println("ia2.hostName->" + ia2.getHostName());
			System.out.println();
			
			//ip를 통한 주소 이름 받아오기
			System.out.println("getbyname에 들어있는 주소의 아이피, 이름");
			InetAddress ia3 = InetAddress.getByName("120.50.132.112");
			System.out.println("ia3.address->"+ia3.getHostAddress());
			System.out.println("ia3.HostName->"+ia3.getHostName());
			System.out.println();
			
			//주소에서 사용하고 있는 모든 아이피와 이름을 가져온다.
			System.out.println("getbyname에 들어있는 주소의 모든 아이피, 이름");
			InetAddress[] ia4 =InetAddress.getAllByName("www.naver.com");
			for(InetAddress ia :ia4) {
				System.out.println("ia.address--->"+ia.getHostAddress());
				System.out.println("ia.hostName-->"+ia.getHostName());
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		new InetAddressTest();
	}

}

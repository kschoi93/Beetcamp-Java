import java.net.InetAddress;

public class InetAddressTest {

	public InetAddressTest() {
		try {
			//���� ��ǻ���� ip�� ���϶�.
			//	ip,url�ּҰ� �� �ִ�
			InetAddress ia1 = InetAddress.getLocalHost();
			
			String ip = ia1.getHostAddress();
			String hostname = ia1.getHostName();
			System.out.println("ia1.getHostAddress()->"+ip);
			System.out.println("ia1.getHostName()->"+hostname);
			Object test = ia1.hashCode();
			System.out.println("ia1.hashCode()->"+test);
//			Boolean b = ia1.isAnyLocalAddress();
//			System.out.println(b);
			
			//URL �ּҸ� �̿��Ͽ� ip �˾ƺ���
			InetAddress ia2 = InetAddress.getByName("www.nate.com");
			System.out.println("ia2.address->"+ia2.getHostAddress());
			System.out.println("ia2.hostName->" + ia2.getHostName());

			
			//ip�� �̿��� inetAddress���� - ip�� ��ü������ url�� ������ �ʴ´�.
			InetAddress ia3 = InetAddress.getByName("120.50.132.112");
			System.out.println("ia3.address->"+ia3.getHostAddress());
			System.out.println("ia3.HostName->"+ia3.getHostName());
			System.out.println();
			
			//�������� InetAddress ������
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

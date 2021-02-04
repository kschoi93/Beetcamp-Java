import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class URLTest {

	public URLTest() {
		try {
			//
			URL url = new URL("https://www.naver.com");
//			URL url = new URL("https://www.nate.com/Bestsellers?viewType=G&groupCode=G03");
			System.out.println("protocol--> "+ url.getProtocol());
			System.out.println("hostname--> "+ url.getHost());
			System.out.println("port--> "+url.getPort());
			System.out.println("fileName--> "+url.getFile());
			System.out.println("path--> "+url.getPath());
			System.out.println("query--> "+url.getQuery());
			System.out.println("authority--> "+url.getAuthority());
			System.out.println("content--> "+url.getContent());
			System.out.println("toString--> "+url.toString());
			System.out.println("userinfo--> "+url.getUserInfo());
			System.out.println("defaultport--> "+url.getDefaultPort());
			System.out.println("externalfrom--> "+url.toExternalForm());
			
			//URL Connection 객체를 구해 Header의 CententType을 구하면 한글코드를 알아낼 수 있다.
			URLConnection con =url.openConnection();
			con.connect();//Header정보를 얻기 전에 통신채널을 확보한다
			//Header의 contentType 가져오기
			String contentType= con.getContentType();
			System.out.println("contentType--> "+contentType);
			String encode = contentType.substring(contentType.indexOf("=")+1);
			System.out.println("substring-->"+encode);
//			String encode2[] = contentType.split("=");
//			System.out.println("split-->"+ encode2[1]);
			
			
			
			
//			//url 객체를 통해 리소스 가져오기
//			InputStream is = url.openStream();
//			InputStreamReader isr = new InputStreamReader(is);
//			BufferedReader br = new BufferedReader(isr);
//			
//			while(true) {
//				String inData = br.readLine();
//				if(inData==null) break;
//				System.out.println(inData);
//			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		new URLTest();

	}

}

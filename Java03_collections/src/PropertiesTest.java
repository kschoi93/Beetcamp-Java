import java.util.Enumeration;
import java.util.Properties;

public class PropertiesTest {
	public PropertiesTest() {
		// key, value 가 String인 컬렉션
		Properties prop = new Properties();
		
		prop.setProperty("네이트","https://www.nate.com");
		prop.setProperty("다음", "http://www.daum.net");
		prop.setProperty("네이버","http://www.naver.com");
		prop.setProperty("비트캠프","http://bitcamp.co.kr");
		
		String url = prop.getProperty("비트캠프");
		System.out.println("비트캠프->"+url);
		
		Enumeration Key = prop.propertyNames();
		
		while(Key.hasMoreElements()) {
			String k = (String)Key.nextElement();
			System.out.println("key="+k+",value=" + prop.getProperty(k));
		}
		
	}
	public static void main(String[] args) {
		new PropertiesTest();
	}
}

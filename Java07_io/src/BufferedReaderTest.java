import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BufferedReaderTest {

	public BufferedReaderTest() {
		//���� ������ �Է��� �� �ִ� Ŭ����
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		try {
		System.out.print("���ڿ��Է�=");
		
		// null�� ��� �о�� �����Ͱ� ����.
		String inData = br.readLine();
		System.out.println("inData="+inData);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		new BufferedReaderTest();

	}

}

import java.io.IOException;
import java.io.InputStreamReader;

public class InputStreamReaderTest {

	public InputStreamReaderTest() {
		try {
		//�ֿܼ��� ���ڴ��� �Է��ϴ� Ŭ����
		InputStreamReader isr = new InputStreamReader(System.in);
		System.out.print("�����Է�=");
		while(true) {
			/*
			int inData = isr.read(); // �ѹ��� �� ���ڸ� �о�´�.
			if(inData == -1) break;
			System.out.println(inData+"-->"+(char)inData);
			*/
			// char�迭�� �̿��Ͽ� ���� ���ڸ� �ѹ��� �о����
			char[] inData = new char[5];
			// ���� ������ ���� ���ϵȴ�.
			int cnt = isr.read(inData);
			String inStr1 = new String(inData,0,cnt);
			String inStr2 = String.valueOf(inData,0,cnt);
			
			System.out.println(inStr1 + "===" + inStr2);
		}
		} catch(IOException e) {
			System.out.println(e.getMessage());
		}
	}

	public static void main(String[] args) {
		new InputStreamReaderTest();

	}

}

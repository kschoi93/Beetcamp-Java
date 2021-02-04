import java.io.IOException;
import java.io.InputStream;

public class InputStreamTest {

	public InputStreamTest() {

		try {
			//InputStream Class�� �߻�Ŭ�����μ� ��ü ������ �� ����
			//InputStream�� Byte ������ �Է¹޴� Ŭ����
			InputStream is = System.in;
			
			System.out.print("�Է�=");
			
			while(true) {
				//read() -> �Է¹��ڸ� 1byte�� �о�´�
				
				int inData = is.read(); // ���� �����ͤ� ������ -1�Է�
				System.out.println(inData+","+(char)inData);
				
				if(inData == -1) {
					break;
				}
				
				
				//read(a[]) : �迭ũ��ŭ �ѹ��� �о�´�
				/*
				byte inData[] = new byte[50]; 
				// byte��      ���� Byte�� �迭�� ����
				int cnt = is.read(inData);
				System.out.println(new String(inData,0,cnt) + "-->"+ cnt);
				if(cnt<=0)break;
				*/
				
				//read(arr[],int,int)
//				byte inData[] = new byte[10];
//				// ���� ������ ���� �迭, �迭�� ������ġ index, �о�� byte ����
//				int cnt = is.read(inData,3,4);
//				for(int i=0; i<inData.length; i++) {
//					System.out.println("Ȯ�� ["+i+"]-->"+inData[i]);
//				}
			}
		} catch(IOException e) {
		System.out.println(e.getMessage());
	}
}
	public static void main(String[] args) {
		new InputStreamTest();
	}
}

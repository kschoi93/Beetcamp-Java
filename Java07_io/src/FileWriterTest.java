import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileWriterTest {

	public FileWriterTest() {
		try {
			File f = new File("D://io/test_file.txt");
			FileWriter fw = new FileWriter(f);
			String txt = "�ڹٿ��� ���ڿ��� ���Ϸ� ���� ������!!!!!";
			
			//1. �迭�� ����
			// ���ڿ��� char�迭�� ����
			
			char c[] = txt.toCharArray();
			fw.write(c, 5, c.length-5); // c, index ~ ���� ������
			fw.flush();
			
			//2. ���ڿ��� ����
			fw.write(txt,0,txt.length());
			fw.flush();
			
			
			fw.close();
			
		} catch(IOException e) {
			e.printStackTrace();
			System.out.println("����....");
		}
		System.out.println("end......");
	}

	public static void main(String[] args) {
		new FileWriterTest();

	}

}

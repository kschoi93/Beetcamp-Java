import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileReaderTest {

	public FileReaderTest() {
		try {
			File f = new File("d://io/oracle.sql");
			FileReader fr = new FileReader(f);
	//		FileReader fr = new FileReader("d://io/oracle.sql");
			BufferedReader br= new BufferedReader(fr);
			while(true) {
//				int read = fr.read();
//				if(read==-1) break;
//				System.out.print((char)read);
				
				String read = br.readLine();
				if(read==null){break;}
				System.out.println(read);
			}
		
		} catch (FileNotFoundException ffe) {
			System.out.println("������ �������� �ʽ��ϴ�..");
		} catch (IOException io) {
			System.out.println("���� �б� ���� �߻�...");
		}
	}

	public static void main(String[] args) {
		new FileReaderTest();
	}

}
